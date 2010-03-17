package com.zhelazhela.services.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.zhelazhela.db.dao.BaseProfileDAO;
import com.zhelazhela.db.dao.BlockUserDAO;
import com.zhelazhela.db.dao.ContactProfileDAO;
import com.zhelazhela.db.dao.FriendListDAO;
import com.zhelazhela.db.dao.GoodsTrackDAO;
import com.zhelazhela.db.dao.UserDAO;
import com.zhelazhela.db.dao.UserinfoDAO;
import com.zhelazhela.db.model.BaseProfile;
import com.zhelazhela.db.model.BlockUserExample;
import com.zhelazhela.db.model.ContactProfile;
import com.zhelazhela.db.model.ContactProfileExample;
import com.zhelazhela.db.model.FriendList;
import com.zhelazhela.db.model.FriendListExample;
import com.zhelazhela.db.model.GoodsTrackExample;
import com.zhelazhela.db.model.User;
import com.zhelazhela.db.model.UserExample;
import com.zhelazhela.db.model.Userinfo;
import com.zhelazhela.db.model.UserinfoExample;
import com.zhelazhela.domain.Mail;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.domain.SNSUserBaseinfo;
import com.zhelazhela.domain.SNSUserBaseinfoList;
import com.zhelazhela.domain.UserPrivate;
import com.zhelazhela.services.UserProfileService;
import com.zhelazhela.system.config.SystemConfig;
import com.zhelazhela.system.email.MailServices;
import com.zhelazhela.util.CommonMethod;

public class UserProfileServiceImpl implements UserProfileService {
	
	private UserDAO userDAO;
	
	private UserinfoDAO userinfoDAO;
	
	private FriendListDAO friendListDAO;
	
	private BlockUserDAO blockUserDAO;
	
	private MailServices mailServices;
	
	private PlatformTransactionManager m_db_tx_manager;
	
	private SystemConfig systemConfig;
	
	private GoodsTrackDAO goodsTrackDAO;
	
	private ContactProfileDAO contactProfileDAO;
	
	private BaseProfileDAO baseProfileDAO;
	
	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

	public void setTxManager(PlatformTransactionManager tx){
		this.m_db_tx_manager = tx;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setMailServices(MailServices mailServices) {
		this.mailServices = mailServices;
	}

	public void setUserinfoDAO(UserinfoDAO userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}

	public void setFriendListDAO(FriendListDAO friendListDAO) {
		this.friendListDAO = friendListDAO;
	}

	public void setBlockUserDAO(BlockUserDAO blockUserDAO) {
		this.blockUserDAO = blockUserDAO;
	}

	public void setGoodsTrackDAO(GoodsTrackDAO goodsTrackDAO) {
		this.goodsTrackDAO = goodsTrackDAO;
	}

	public void setContactProfileDAO(ContactProfileDAO contactProfileDAO) {
		this.contactProfileDAO = contactProfileDAO;
	}

	public void setBaseProfileDAO(BaseProfileDAO baseProfileDAO) {
		this.baseProfileDAO = baseProfileDAO;
	}

	
	@Override
	public SNSUser regUser(SNSUser user,long recommendUserId) throws Exception {
		if(!checkUser(user)){
			throw new Exception("非常抱歉，您的账号已经被注册了。");
		}
		TransactionStatus  status = m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
		try{
			User u = new User();
			u.setAccount(user.getAccount());
			u.setPassword(user.getMdpass());
			userDAO.insertSelective(u);
			if(u.getId()>0){
				Userinfo uinfo = new Userinfo();
				uinfo.setEmail(user.getEmail());
				uinfo.setName(user.getName());
				uinfo.setActivationKey(CommonMethod.getInstance().GenActivtyCode(12));
				uinfo.setUserId(u.getId());
				uinfo.setRegisteredDate(new java.util.Date());
				uinfo.setRecommendUserId(recommendUserId);
				uinfo.setQuestionId(user.getQuestionid());
				uinfo.setSecurityAnswer(user.getAnswer());
				userinfoDAO.insertSelective(uinfo);
				user.setId(u.getId());
				user.setActivity(uinfo.getActivationKey());
				m_db_tx_manager.commit(status);
				mailServices.sendMail(Mail.getActvityEmail(user.getId(), user.getEmail(), user.getActivity(), systemConfig.getDomain()));
			}else{
				m_db_tx_manager.rollback(status);
				throw new Exception("注册失败，发生未知错误");
			}
		}catch(Exception e){
			m_db_tx_manager.rollback(status);
			throw new Exception(e);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkUser(SNSUser user) throws Exception {
		UserinfoExample example = new UserinfoExample();
		java.util.List list;
		if(StringUtils.isNotBlank(user.getAccount())){
			UserExample ex = new UserExample();
			ex.createCriteria().andAccountEqualTo(user.getAccount());
			list = userDAO.selectByExample(ex);
			if(list.size()>0){
				return false;
			}
		}
		if(StringUtils.isNotBlank(user.getEmail())){
			example.createCriteria().andEmailEqualTo(user.getEmail());
			list = userinfoDAO.selectByExample(example);
			if(list.size()>0){
				return false;
			}
		}
		if(StringUtils.isNotBlank(user.getName())){
			example.clear();
			example.createCriteria().andNameEqualTo(user.getName());
			list = userinfoDAO.selectByExample(example);
			if(list.size()>0){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean reSendActMail(SNSUser user) throws Exception {
		Userinfo ui = userinfoDAO.selectByPrimaryKey(user.getId());
		if(ui==null){
			throw new Exception("不存在该用户，请重新注册");
		}
		if(StringUtils.isBlank(ui.getActivationKey())){
			throw new Exception("该用户已经被激活，不需要再次激活");
		}
		mailServices.sendMail(Mail.getActvityEmail(user.getId(), user.getEmail(), ui.getActivationKey(), systemConfig.getDomain()));
		return false;
	}

	@Override
	public SNSUser logUser(SNSUser user) throws Exception {
		UserExample example = new UserExample();
		example.createCriteria().andAccountEqualTo(user.getAccount()).andPasswordEqualTo(user.getMdpass());
		java.util.List<User> list = userDAO.selectByExample(example);
		if(list.size()>0){
			user.setId(list.get(0).getId());
			Userinfo ui = userinfoDAO.selectByPrimaryKey(user.getId());
			if(ui==null){
				throw new Exception("不存在该用户");
			}
			user.setPassword("");
			user.setRepassword("");
			user.setNewpassword("");
			user.setAccount(user.getAccount());
			user.setEmail(ui.getEmail());
			user.setName(ui.getName());
			user.setUserinfo(ui);
			if(StringUtils.isBlank(ui.getActivationKey())){
				user.setReg_level(1);
			}else{
				user.setReg_level(0);
			}
			return user;
		}else{
			throw new Exception("账号或者密码错误");
		}
	}

	@Override
	public boolean actUser(long id, String code) throws Exception {
		Userinfo ui = userinfoDAO.selectByPrimaryKey(id);
		if(StringUtils.isBlank(ui.getActivationKey())){
			throw new Exception();
		}
		if(code.equals(ui.getActivationKey())){
			ui.setActivationKey("");
			userinfoDAO.updateByPrimaryKey(ui);
			return true;
		}
		return false;
	}

	@Override
	public SNSUserBaseinfo loadUserBaseInfo(long id,long myid) throws Exception {
		Userinfo ui = userinfoDAO.selectByPrimaryKey(id);
		if(ui==null){
			return null;
		}
		SNSUserBaseinfo user = new SNSUserBaseinfo();
		UserPrivate up = new UserPrivate();
		up.setValid(true);
		if(myid>0){
			BlockUserExample example = new BlockUserExample();
			example.createCriteria().andUserIdEqualTo(id).andBlockedUserIdEqualTo(myid);
			if(blockUserDAO.countByExample(example)>0){
				up.setNotice("您存在于改用户的黑名单中,无法查看他的信息");
				up.setValid(false);
				up.setPrivate_level(1);
				up.setPrivate_type(UserPrivate.BLOCK_USER);
			}
		}
		user.setUserPrivate(up);
		user.setUserinfo(ui);
		user.setTracks(countUserWatching(id));
		user.setBeen_tracks(countUserWatcher(id));
		GoodsTrackExample ge = new GoodsTrackExample();
		ge.createCriteria().andUserIdEqualTo(id);
		user.setGoods(goodsTrackDAO.countByExample(ge));
		return user;
	}

	@Override
	public int countUserWatcher(long userId) throws Exception {
		FriendListExample example = new FriendListExample();
		example.createCriteria().andFriendIdEqualTo(userId).andStatusEqualTo(FriendList.STATUS_SUCCESS);
		return friendListDAO.countByExample(example);
	}

	@Override
	public int countUserWatching(long userId) throws Exception {
		FriendListExample example = new FriendListExample();
		example.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(FriendList.STATUS_SUCCESS);
		return friendListDAO.countByExample(example);
	}

	@Override
	public SNSUserBaseinfoList loadUserWatcher(long userId,
			List<Long> blockedUser) throws Exception {
		SNSUserBaseinfoList sbl = new SNSUserBaseinfoList();
		int size = countUserWatcher(userId);
		sbl.setSize(0);
		if(size==0){
			sbl.setC_size(0);
			return sbl;
		}
		sbl.setList(friendListDAO.loadUserBeenTracked(userId, null, 1, -1));
		return sbl;
	}

	@Override
	public SNSUserBaseinfoList loadUserWatching(long userId,
			List<Long> blockedUser) throws Exception {
		SNSUserBaseinfoList sbl = new SNSUserBaseinfoList();
		int size = countUserWatching(userId);
		sbl.setSize(0);
		if(size==0){
			sbl.setC_size(0);
			return sbl;
		}
		sbl.setList(friendListDAO.loadUserTracked(userId, null, 1, -1));
		return sbl;
	}

	@Override
	public ContactProfile addContactProfile(ContactProfile cp) throws Exception {
		ContactProfileExample cpe = new ContactProfileExample();
		cpe.createCriteria().andUserIdEqualTo(cp.getUserId());
		int size = contactProfileDAO.countByExample(cpe);
		if(size>=ContactProfile.MAX_CONTACT){
			throw new Exception("您最多只能保存3个联系地址");
		}else{
			contactProfileDAO.insert(cp);
		}
		return cp;
	}

	@Override
	public boolean delContactProfile(long id,long userid) throws Exception {
		ContactProfileExample cpe = new ContactProfileExample();
		cpe.createCriteria().andIdEqualTo(id).andUserIdEqualTo(userid);
		int row = contactProfileDAO.deleteByExample(cpe);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public BaseProfile editBaseProfile(BaseProfile bp) throws Exception {
		if(baseProfileDAO.selectByPrimaryKey(bp.getUserId())==null){
			baseProfileDAO.insert(bp);
		}else{
			baseProfileDAO.updateByPrimaryKey(bp);
		}
		return bp;
	}

	@Override
	public ContactProfile editContactProfile(ContactProfile cp)
			throws Exception {
		contactProfileDAO.updateByPrimaryKey(cp);
		return cp;
	}

	@Override
	public Userinfo editUserinfo(Userinfo ui) throws Exception {
		userinfoDAO.updateByPrimaryKeySelective(ui);
		return ui;
	}

	@Override
	public BaseProfile loadBaseProfile(long id) throws Exception {
		return baseProfileDAO.selectByPrimaryKey(id);
	}

	@Override
	public List<ContactProfile> loadContactProfile(long id) throws Exception {
		ContactProfileExample cpe = new ContactProfileExample();
		cpe.createCriteria().andUserIdEqualTo(id);
		return contactProfileDAO.selectByExample(cpe);
	}

	@Override
	public boolean updatePassword(long userId, String newpass) throws Exception {
		User u = new User();
		u.setId(userId);
		u.setPassword(newpass);
		int row  = userDAO.updateByPrimaryKeySelective(u);
		if(row>0){
			return true;
		}
		return false;
	}

}
