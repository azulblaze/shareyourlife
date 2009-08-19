package com.twitpic.services.impl;


import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.twitpic.db.dao.UsersDAO;
import com.twitpic.db.dao.UsersProfileDAO;
import com.twitpic.db.model.Users;
import com.twitpic.db.model.UsersExample;
import com.twitpic.db.model.UsersProfile;
import com.twitpic.domain.FormLogin;
import com.twitpic.domain.FormRegister;
import com.twitpic.domain.FormUserProfile;
import com.twitpic.domain.Mail;
import com.twitpic.domain.Account;
import com.twitpic.services.AccountService;
import com.twitpic.system.config.SystemConfig;
import com.twitpic.system.email.MailServices;
import com.twitpic.util.CommonMethod;

public class AccountServiceImpl implements AccountService {
	
	private SystemConfig systemConfig;
	
	private MailServices mailServices;
	
	private UsersDAO usersDAO;
	
	private UsersProfileDAO usersProfileDAO;
	
	private PlatformTransactionManager m_db_tx_manager;
	
	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}
	
	public void setMailServices(MailServices mailServices) {
		this.mailServices = mailServices;
	}
	
	public void setTxManager(PlatformTransactionManager tx){
		this.m_db_tx_manager = tx;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public void setUsersProfileDAO(UsersProfileDAO usersProfileDAO) {
		this.usersProfileDAO = usersProfileDAO;
	}



	@Override
	public Account user_login(FormLogin formLogin)throws Exception{
		Users user = usersDAO.selectByPrimaryKey(formLogin.getName());
		if(user!=null){
			if(user.getPassword().equals(formLogin.getPassword())){
				Account _account = new Account();
				_account.setUsers(user);
				if(_account.getStatus()==Users.STATUS_VALID){
					UsersProfile up = usersProfileDAO.selectByPrimaryKey(_account.getAccount());
					up.setLoginTime(new java.util.Date());
					usersProfileDAO.updateByPrimaryKeySelective(up);
					_account.setUsersProfile(up);
				}
				return _account;
			}else{
				throw new java.lang.Exception("密码错误");
			}
		}
		throw new java.lang.Exception("该用户不存在");
	}



	@Override
	public Account reg_user(FormRegister formRegister) throws Exception {
		Users user = usersDAO.selectByPrimaryKey(formRegister.getAccount());
		if(user!=null){
			throw new java.lang.Exception("帐号已经被注册");
		}
		UsersExample example = new UsersExample();
		example.createCriteria().andNameEqualTo(formRegister.getName());
		java.util.List<Users> users = usersDAO.selectByExample(example);
		if(users.size()>0){
			throw new java.lang.Exception("用户名已经被注册");
		}
		//clear the Criteria list
		example.clear();
		example.createCriteria().andEmailEqualTo(formRegister.getEmail());
		users = usersDAO.selectByExample(example);
		if(users.size()>0){
			throw new java.lang.Exception("邮箱已经被注册");
		}
		user = new Users();
		user.setAccount(formRegister.getAccount());
		user.setActivityCode(CommonMethod.getInstance().GenActivtyCode(30));
		user.setEmail(formRegister.getEmail());
		user.setName(formRegister.getName());
		user.setPassword(formRegister.getPassword1());
		user.setRegTime(new java.util.Date());
		user.setStatus(Users.STATUS_EMAIL_NOTVALID);
		usersDAO.insert(user);
		send_ac_mail(user,null);
		Account _account = new Account();
		_account.setUsers(user);
		return _account;
	}
	
	

	@Override
	public boolean act_user(String ac, String at) throws Exception {
		UsersExample example = new UsersExample();
		example.createCriteria().andAccountEqualTo(ac).andStatusEqualTo(Users.STATUS_EMAIL_NOTVALID);
		java.util.List<Users> users = usersDAO.selectByExample(example);
		if(users.size()==1){
			Users user = users.get(0);
			if(user.getActivityCode().equals(at)){
				TransactionStatus  status = this.m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
				try{
					user.setStatus(Users.STATUS_VALID);
					user.setRegTime(new java.util.Date());
					usersDAO.updateByPrimaryKeySelective(user);
					UsersProfile up = new UsersProfile();
					up.setAccount(user.getAccount());
					up.setPicture(UsersProfile.DEFAULT_PICTURE);
					usersProfileDAO.insert(up);
					this.m_db_tx_manager.commit(status);
					return true;
				}catch(Exception e){
					this.m_db_tx_manager.rollback(status);
				}
			}
			throw new java.lang.Exception("无效的激活链接");
		}
		return false;
	}

	@Override
	public void send_ac_mail(Account _user, String email) throws Exception {
		Users user = usersDAO.selectByPrimaryKey(_user.getAccount());
		send_ac_mail(user,email);
	}

	private void send_ac_mail(Users user, String email) throws Exception {
		if(email!=null&&email.length()>0&&!user.getEmail().equals(email)){
			UsersExample example = new UsersExample();
			example.createCriteria().andEmailEqualTo(email);
			java.util.List<Users> tmp = usersDAO.selectByExample(example);
			if(tmp.size()>0){
				throw new java.lang.Exception("邮箱已经被注册");
			}
			user.setEmail(email);
			usersDAO.updateByPrimaryKeySelective(user);
		}
		Mail mail = new Mail();
		String link = systemConfig.getDomain()+"/act.do?ac="+user.getAccount()+"&at="+user.getActivityCode();
		mail.setContent("使用下面的链接来激活您的帐号。<br/><a href=\""+link+"\">"+link+"</a>");
		mail.setToAddr(user.getEmail());
		mail.setSubject("激活您的帐号");
		mail.setType(Mail.MAIL_TYPE_HTML);
		mailServices.sendMail(mail);
	}

	@Override
	public Account editHeader(com.twitpic.domain.Account account,java.io.File file,String rootpath,String filetype) throws Exception {
		// TODO Auto-generated method stub
		if(file.length()>systemConfig.getUpload_header_maxlength()){
			throw new Exception("上次文件大小超过"+systemConfig.getUpload_header_maxlength()/1024+"KB限制");
		}
		TransactionStatus  status = this.m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
		try{
			//First save image to disk
			CommonMethod cm = CommonMethod.newInstance();
			String[] path = cm.saveImg(file, rootpath,systemConfig.getUpload_header(),null,null,filetype);
			//Save picture path to user_property
			UsersProfile up = new UsersProfile();
			up.setAccount(account.getAccount());
			up.setPicture(path[0]);
			usersProfileDAO.updateByPrimaryKeySelective(up);
			this.m_db_tx_manager.commit(status);
			//return the account info
			if(account.getPicture()!=null&&!account.getPicture().equals(UsersProfile.DEFAULT_PICTURE)){
				cm.deleteFile(rootpath+account.getPicture());
			}
			account.setPicture(path[0]);
			return account;
		}catch(Exception e){
			this.m_db_tx_manager.rollback(status);
			throw new java.lang.Exception(e.getMessage());
		}
	}

	@Override
	public Account editPassword(Account account, FormUserProfile formUserProfile)
			throws Exception {
		Users u = usersDAO.selectByPrimaryKey(account.getAccount());
		if(!formUserProfile.getOldpassword().equals(u.getPassword())){
			throw new Exception("原始密码不正确");
		}
		//the new password is same to old password,no need to change 
		if(formUserProfile.getPassword1().equals(u.getPassword())){
			return account;
		}
		u.setPassword(formUserProfile.getPassword1());
		usersDAO.updateByPrimaryKey(u);
		account.setUsers(u);
		return account;
	}

	@Override
	public Account editProfile(Account account, FormUserProfile formUserProfile)
			throws Exception {
		UsersProfile up = usersProfileDAO.selectByPrimaryKey(account.getAccount());
		up.setLocation(formUserProfile.getLocation());
		up.setSelfIntroduction(formUserProfile.getSelf_introduction());
		up.setSignature(formUserProfile.getSignature());
		usersProfileDAO.updateByPrimaryKey(up);
		account.setUsersProfile(up);
		return account;
	}

	@Override
	public boolean find_password(String email, String account) throws Exception {
		Users u = usersDAO.selectByPrimaryKey(account);
		if(u==null){
			throw new Exception("帐号不存在");
		}
		if(!(u.getEmail().equals(email))){
			throw new Exception("帐号信息确认失败");
		}
		Mail mail = new Mail();
		mail.setContent("尊敬的会员，您的密码是："+u.getPassword()+",请妥善保管您的密码。");
		mail.setToAddr(email);
		mail.setSubject("密码找回服务");
		mail.setType(Mail.MAIL_TYPE_HTML);
		mailServices.sendMail(mail);
		return true;
	}
}
