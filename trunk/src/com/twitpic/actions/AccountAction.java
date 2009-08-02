package com.twitpic.actions;

import com.twitpic.db.model.Users;
import com.twitpic.domain.FormLogin;
import com.twitpic.domain.FormRegister;
import com.twitpic.services.AccountService;
import com.twitpic.util.CommonMethod;
import com.twitpic.util.ConsVar;

@SuppressWarnings("serial")
public class AccountAction extends BaseAction {
	
	private AccountService accountService;
	
	//form bean
	private FormLogin formLogin;
	private FormRegister formRegister;
	
	public FormRegister getFormRegister() {
		return formRegister;
	}

	public void setFormRegister(FormRegister formRegister) {
		this.formRegister = formRegister;
	}

	public FormLogin getFormLogin() {
		return formLogin;
	}

	public void setFormLogin(FormLogin formLogin) {
		this.formLogin = formLogin;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * action:login check
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		clearSession(ConsVar.SESSION_USER);
		if(formLogin==null){
			formLogin = new FormLogin();
		}
		String submit = this.getRequestParameter("submit");
		if(submit==null||!submit.equals("true")){
			return INPUT;
		}
		try{
			validLogin();
			Users user = accountService.user_login(formLogin);
			this.getHttpSession().setAttribute(ConsVar.SESSION_USER, user);
			switch(user.getStatus()){
			case Users.STATUS_EMAIL_NOTVALID:
				return "email_valid";
			case Users.STATUS_CLOSED:
				return "been_closed";
			case Users.STATUS_VALID:
				return SUCCESS;
			default:
				break;
			}
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return "home";
	}
	
	/**
	 * action:user register page
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception{
		clearSession(ConsVar.SESSION_USER);
		if(formRegister==null){
			formRegister = new FormRegister();
		}
		this.setValue("formRegister", formRegister);
		String submit = this.getRequestParameter("submit");
		if(submit==null||!submit.equals("true")){
			return INPUT;
		}
		try{
			validRegister();
			Users user = accountService.reg_user(formRegister);
			this.getHttpSession().setAttribute(ConsVar.SESSION_USER, user);
			return "email_valid";
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
	}
	
	public String activity()throws Exception{
		clearSession(ConsVar.SESSION_USER);
		String ac =this.getRequestParameter("ac");
		String at =this.getRequestParameter("at");
		if(at!=null&&ac!=null){
			try{
				if(accountService.act_user(ac, at)){
					this.addActionMessage("激活成功，请登录!");
					return "login";
				}
			}catch(Exception e){
				this.addActionError(e.getMessage());
				return "re_act";
			}
		}
		return ERROR;
	}
	
	public String reSendMail()throws Exception{
		Users user = (Users)this.getHttpSession().getAttribute(ConsVar.SESSION_USER);
		if(user!=null){
			if(user.getStatus()==Users.STATUS_VALID){
				return "home";
			}
			String mail = this.getRequestParameter("mail");
			if(mail!=null){
				mail = mail.trim();
				if(mail.length()>0){
					if(!CommonMethod.validEmail(mail)){
						addActionError("无效的邮箱");
						return "email_valid";
					}
				}
			}
			accountService.send_ac_mail(user, mail);
			this.addActionMessage("激活链接已经发送到您的邮箱，请确认。");
			return "email_valid";
		}
		this.addActionMessage("请先登录");
		return LOGIN;
	}
	
	/**
	 * check the login form bean
	 * @return
	 * @throws Exception
	 */
	private boolean validLogin() throws Exception{
		if(formLogin.getName()==null||formLogin.getName().trim().length()<1){
			throw new java.lang.Exception("请输入帐号");
		}
		if(formLogin.getPassword()==null||formLogin.getPassword().trim().length()<1){
			throw new java.lang.Exception("请输入密码");
		}
		return true;
	}
	private boolean validRegister() throws Exception{
		if(formRegister.getAccount()==null||formRegister.getAccount().trim().length()<1){
			throw new java.lang.Exception("请输入帐号");
		}
		if(formRegister.getName()==null||formRegister.getName().trim().length()<1){
			throw new java.lang.Exception("请输入用户名");
		}
		if(formRegister.getEmail()==null||formRegister.getEmail().trim().length()<1){
			throw new java.lang.Exception("请输入邮箱");
		}
		if(formRegister.getPassword1()==null||formRegister.getPassword1().trim().length()<1){
			throw new java.lang.Exception("请输入密码");
		}
		if(formRegister.getPassword2()==null||formRegister.getPassword2().trim().length()<1){
			throw new java.lang.Exception("请重复输入密码");
		}
		if(!formRegister.getPassword2().equals(formRegister.getPassword1())){
			throw new java.lang.Exception("两次输入的密码不一致");
		}
		return true;
	}
	
}
