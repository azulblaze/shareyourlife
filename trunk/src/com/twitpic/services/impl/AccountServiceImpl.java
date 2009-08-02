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
import com.twitpic.domain.Mail;
import com.twitpic.services.AccountService;
import com.twitpic.system.email.MailThread;
import com.twitpic.util.CommonMethod;

public class AccountServiceImpl implements AccountService {
	
	private MailThread mailThread = null;
	
	private UsersDAO usersDAO;
	
	private UsersProfileDAO usersProfileDAO;
	
	private PlatformTransactionManager m_db_tx_manager;
	
	public void setMailThread(MailThread mailThread) {
		this.mailThread = mailThread;
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
	public Users user_login(FormLogin formLogin)throws Exception{
		Users user = usersDAO.selectByPrimaryKey(formLogin.getName());
		if(user!=null){
			if(user.getPassword().equals(formLogin.getPassword())){
				if(user.getStatus()==Users.STATUS_VALID){
					UsersProfile up = new UsersProfile();
					up.setAccount(user.getAccount());
					up.setLoginTime(new java.util.Date());
					usersProfileDAO.updateByPrimaryKey(up);
				}
				return user;
			}else{
				throw new java.lang.Exception("密码错误");
			}
		}
		throw new java.lang.Exception("该用户不存在");
	}



	@Override
	public Users reg_user(FormRegister formRegister) throws Exception {
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
		user.setActivityCode(CommonMethod.GenActivtyCode(30));
		user.setEmail(formRegister.getEmail());
		user.setName(formRegister.getName());
		user.setPassword(formRegister.getPassword1());
		user.setRegTime(new java.util.Date());
		user.setStatus(Users.STATUS_EMAIL_NOTVALID);
		usersDAO.insert(user);
		send_ac_mail(user,null);
		return user;
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
					usersDAO.updateByPrimaryKey(user);
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
	public void send_ac_mail(Users user, String email) {
		if(email!=null&&email.length()>0&&!user.getEmail().equals(email)){
			user.setEmail(email);
			usersDAO.updateByPrimaryKey(user);
		}
		Mail mail = new Mail();
		String link = "http://localhost:911/act.do?ac="+user.getAccount()+"&at="+user.getActivityCode();
		mail.setContent("使用下面的链接来激活您的帐号。<br/><a href=\""+link+"\">"+link+"</a>");
		mail.setToAddr(user.getEmail());
		mail.setSubject("激活您的帐号");
		mail.setType(Mail.MAIL_TYPE_HTML);
		mailThread.setMail(mail);
		mailThread.start();
	}
}
