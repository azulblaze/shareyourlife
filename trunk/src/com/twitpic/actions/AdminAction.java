package com.twitpic.actions;

import org.apache.struts2.ServletActionContext;

import com.twitpic.db.model.Admins;
import com.twitpic.domain.FormLogin;
import com.twitpic.domain.PictureInfoList;
import com.twitpic.services.AdminService;
import com.twitpic.util.ConsVar;

/**
 * <code>AdminAction.java</code>
 * @version 1.0, 2009-8-12
 */
@SuppressWarnings("serial")
public class AdminAction extends BaseAction {
	private FormLogin formLogin;
	private AdminService adminService;
	private Long from;
	private Long to;
	private Long id_picture;
	private String user_account;
	public String login() throws Exception{
		clearSession(ConsVar.SESSION_ADMIN_USER);
		if(formLogin==null){
			formLogin = new FormLogin();
		}
		String submit = this.getRequestParameter("sub");
		if(submit==null||!submit.equals("true")){
			return INPUT;
		}
		try{
			validLogin();
			Admins user = adminService.user_login(formLogin);
			if(user==null||(user.getEndTime()!=null&&user.getEndTime().getTime()<System.currentTimeMillis())){
				return INPUT;
			}
			this.getHttpSession().setAttribute(ConsVar.SESSION_ADMIN_USER, user);
			return SUCCESS;
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
	}
	
	public String dashboard() throws Exception{
		if(isAdmin()){
			String submit = this.getRequestParameter("sub");
			if(submit==null||!submit.equals("true")){
				return SUCCESS;
			}
			if(from==null&&to==null){
				return SUCCESS;
			}
			PictureInfoList pil = adminService.loadPictures(from, to, 20); 
			this.setValue("pil", pil);
			return SUCCESS;
		}
		return "login";
	}
	
	public String delete_picture() throws Exception{
		if(!isAdmin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'login.do'}");
		}
		String root_path = ServletActionContext.getServletContext().getRealPath("/");
		if(adminService.deletePictures(root_path,id_picture)){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'删除图片成功'}");
		}else{
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'删除图片失败'}");
		}
		return "json";
	}
	
	public String disable_picture() throws Exception{
		if(!isAdmin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'login.do'}");
		}
		if(adminService.disablePictures(id_picture)){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'屏蔽图片成功'}");
		}else{
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'屏蔽图片失败'}");
		}
		return "json";
	}
	
	public String disable_user() throws Exception{
		if(!isAdmin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'login.do'}");
		}
		if(adminService.disableUser(user_account)){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'关闭用户成功'}");
		}else{
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'关闭用户失败'}");
		}
		return "json";
	}
	
	private boolean isAdmin(){
		Admins user = (Admins)this.getHttpSession().getAttribute(ConsVar.SESSION_ADMIN_USER);
		if(user!=null){
			if(user.getEndTime()==null||(user.getEndTime()!=null&&user.getEndTime().getTime()>System.currentTimeMillis())){
				return true;
			}
		}
		return false;
	}
	
	private boolean validLogin() throws Exception{
		if(formLogin.getName()==null||formLogin.getName().trim().length()<1){
			throw new java.lang.Exception("请输入帐号");
		}
		if(formLogin.getPassword()==null||formLogin.getPassword().trim().length()<1){
			throw new java.lang.Exception("请输入密码");
		}
		return true;
	}
	
	public FormLogin getFormLogin() {
		return formLogin;
	}

	/**
	 * @param formLogin the formLogin to set
	 */
	public void setFormLogin(FormLogin formLogin) {
		this.formLogin = formLogin;
	}

	/**
	 * @return the from
	 */
	public Long getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Long from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public Long getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(Long to) {
		this.to = to;
	}

	/**
	 * @return the id_picture
	 */
	public Long getId_picture() {
		return id_picture;
	}

	/**
	 * @param id_picture the id_picture to set
	 */
	public void setId_picture(Long id_picture) {
		this.id_picture = id_picture;
	}

	/**
	 * @return the user_account
	 */
	public String getUser_account() {
		return user_account;
	}

	/**
	 * @param user_account the user_account to set
	 */
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	/**
	 * @param adminService the adminService to set
	 */
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
}
