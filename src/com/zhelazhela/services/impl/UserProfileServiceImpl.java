package com.zhelazhela.services.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.zhelazhela.db.dao.UserDAO;
import com.zhelazhela.db.dao.UserinfoDAO;
import com.zhelazhela.db.model.User;
import com.zhelazhela.db.model.UserExample;
import com.zhelazhela.db.model.Userinfo;
import com.zhelazhela.db.model.UserinfoExample;
import com.zhelazhela.domain.Mail;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.services.UserProfileService;
import com.zhelazhela.system.config.SystemConfig;
import com.zhelazhela.system.email.MailServices;
import com.zhelazhela.util.CommonMethod;

public class UserProfileServiceImpl implements UserProfileService {
	
	private UserDAO userDAO;
	
	private UserinfoDAO userinfoDAO;
	
	private MailServices mailServices;
	
	private PlatformTransactionManager m_db_tx_manager;
	
	private SystemConfig systemConfig;
	
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
			user.setEmail(ui.getEmail());
			user.setName(ui.getName());
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

}