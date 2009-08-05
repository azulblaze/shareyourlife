package com.twitpic.actions;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.twitpic.db.model.Users;
import com.twitpic.domain.Account;
import com.twitpic.domain.FormLogin;
import com.twitpic.domain.FormRegister;
import com.twitpic.domain.FormUserProfile;
import com.twitpic.services.AccountService;
import com.twitpic.system.config.SystemConfig;
import com.twitpic.util.CommonMethod;
import com.twitpic.util.ConsVar;

@SuppressWarnings("serial")
public class AccountAction extends BaseAction {
	private AccountService accountService;
	
	//form bean
	private FormLogin formLogin;
	private FormRegister formRegister;
	private FormUserProfile formUserProfile;
	
	private File header;
	private String headerContentType;
	
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
	
	public FormUserProfile getFormUserProfile() {
		return formUserProfile;
	}
	
	public File getHeader() {
		return header;
	}

	
	public void setHeader(File header) {
		this.header = header;
	}

	public String getHeaderContentType() {
		return headerContentType;
	}

	public void setHeaderContentType(String headerContentType) {
		this.headerContentType = headerContentType;
	}
	
	public void setFormUserProfile(FormUserProfile formUserProfile) {
		this.formUserProfile = formUserProfile;
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
			Account user = accountService.user_login(formLogin);
			this.getHttpSession().setAttribute(ConsVar.SESSION_USER, user);
			switch(user.getStatus()){
			case Users.STATUS_EMAIL_NOTVALID:
				return "email_valid";
			case Users.STATUS_CLOSED:
				return "been_closed";
			default:
				break;
			}
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	/**
	 * action:logout
	 * @return
	 * @throws Exception
	 */
	public String logout()throws Exception{
		clearSession(ConsVar.SESSION_USER);
		return "index";
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
			Account user = accountService.reg_user(formRegister);
			this.getHttpSession().setAttribute(ConsVar.SESSION_USER, user);
			return "email_valid";
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
	}
	
	/**
	 * action:edit user's profile,ajax
	 * @return
	 * @throws Exception
	 */
	public String edit_profile()throws Exception{
		if(formUserProfile==null){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NONE+"'}");
		}
		if(!isLogin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'/login.do'}");
			return "json";
		}
		Account account = loadAccount();
		try{
			account = accountService.editProfile(account, formUserProfile);
			this.getHttpSession().setAttribute(ConsVar.SESSION_USER, account);
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'更新成功'}");
		}catch(Exception e){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'"+e.getMessage()+"'}");
		}
		return "json";
	}
	
	/**
	 * change user's head picture,ajax
	 * @return
	 * @throws Exception
	 */
	public String edit_header()throws Exception{
		if(headerContentType==null||headerContentType.trim().length()<1||header==null){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NONE+"'}");
			return "json";
		}
		if(!isLogin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'/login.do'}");
			return "json";
		}
		String root_path = ServletActionContext.getServletContext().getRealPath("/");
		String ext_type = CommonMethod.getInstance().isAllowedPicture(headerContentType);
		if(ext_type==null){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"',"+ConsVar.JSON_ACTION_NOTICE_MSG+":'保存失败，不支持该文件格式'}");
		}
		Account account = this.loadAccount();
		try{
			account = accountService.editHeader(account, header, root_path, ext_type);
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"',"+ConsVar.JSON_ACTION_NOTICE_MSG+":'保存成功',data:'"+account.getPicture()+"'}");
		}catch(Exception e){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"',"+ConsVar.JSON_ACTION_NOTICE_MSG+":'保存失败，"+e.getMessage()+"'}");
			return "json";
		}
		return "json";
	}
	/**
	 * change user's password,ajax
	 * @return
	 * @throws Exception
	 */
	public String edit_password()throws Exception{
		if(formUserProfile==null){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NONE+"'}");
			return "json";
		}
		if(!isLogin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'/login.do'}");
			return "json";
		}
		Account account = loadAccount();
		if(formUserProfile.getOldpassword()==null||formUserProfile.getOldpassword().trim().length()<6){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'更新失败，请输入正确的原始密码'}");
			return "json";
		}
		if(formUserProfile.getPassword1()==null||formUserProfile.getPassword1().trim().length()<6||formUserProfile.getPassword2()==null||formUserProfile.getPassword2().trim().length()<6){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'更新失败，请输入正确格式的新密码'}");
			return "json";
		}
		if(!formUserProfile.getPassword1().equals(formUserProfile.getPassword2())){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'更新失败，两次输入的新密码不相同'}");
			return "json";
		}
		try{
			account = accountService.editPassword(account, formUserProfile);
			this.getHttpSession().setAttribute(ConsVar.SESSION_USER, account);
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'更新成功，请妥善保管您的密码'}");
		}catch(Exception e){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'更新失败，"+e.getMessage()+"'}");
		}
		return "json";
	}
	
	/**
	 * action:user's profile manage page
	 * @return
	 * @throws Exception
	 */
	public String profile() throws Exception{
		if(isLogin()){
			return SUCCESS;
		}
		return LOGIN;
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
		Account user = (Account)this.getHttpSession().getAttribute(ConsVar.SESSION_USER);
		if(user!=null){
			if(user.getStatus()==Users.STATUS_VALID){
				return "index";
			}
			String mail = this.getRequestParameter("mail");
			if(mail!=null){
				mail = mail.trim();
				if(mail.length()>0){
					if(!CommonMethod.getInstance().validEmail(mail)){
						addActionError("无效的邮箱");
						return "email_valid";
					}
				}
			}
			try{
				accountService.send_ac_mail(user, mail);
			}catch(Exception e){
				addActionError(e.getMessage());
				return "email_valid";
			}
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
