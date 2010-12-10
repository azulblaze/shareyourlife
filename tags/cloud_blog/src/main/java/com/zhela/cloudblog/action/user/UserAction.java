package com.zhela.cloudblog.action.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


import org.apache.commons.lang.StringUtils;

import com.zhela.cloudblog.action.BaseAction;
import com.zhela.cloudblog.model.users.Users;
import com.zhela.cloudblog.service.internaluser.InternalUserService;
import com.zhela.cloudblog.util.CommonMethod;

@SuppressWarnings("serial")
public class UserAction extends BaseAction{

	private Users user;
	private String newpassword;
	private String re_newpassword;
	private InternalUserService internalUserService;
	private File pic;
	private String picContentType;
	public String postUser() throws Exception{
		clearSession(session_user);
		if(user!=null&&StringUtils.isNotBlank(user.getAccount())&&StringUtils.isNotBlank(user.getDisplayName())&&StringUtils.isNotBlank(user.geteMail())&&StringUtils.isNotBlank(user.getPassword())){
			try{
				String extType = "";
				if(pic!=null&&picContentType!=null){
					extType = CommonMethod.getInstance().isAllowedPicture(picContentType);
					if(extType==null){
						setValue("error","头像必须为PNG,JPEG,GIF格式的图片");
						setValue("user", user);
						return INPUT;
					}
				}
				Users result = internalUserService.insertUsers(user.getAccount(), user.getPassword(), user.geteMail(), user.getDisplayName());
				if(pic!=null&&picContentType!=null){
					InputStream header = new FileInputStream(pic);
					result.setHeader(internalUserService.updateUsersHeader(user.getAccount(), header, getRootPath(), extType).getHeader());
				}
				saveSession(session_user,result);
				return SUCCESS;
			}catch(Exception e){
				setValue("user", user);
				setValue("error",e.getMessage());
				return INPUT;
			}
		}
		if(user!=null){
			setValue("user", user);
			setValue("error", "信息不完整");
		}
		return INPUT;
	}
	
	public String deleteUser() throws Exception{
		clearSession(session_user);
		return LOGIN;
	}
	
	public String signinsuccess() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			return LOGIN;
		}
		return SUCCESS;
	}
	
	public String loadUser() throws Exception{
		if(user!=null&&StringUtils.isNotBlank(user.getAccount())&&StringUtils.isNotBlank(user.getPassword())){
			try{
				Users result = internalUserService.getUsers(user.getAccount(), user.getPassword());
				saveSession(session_user,result);
				return SUCCESS;
			}catch(Exception e){
				setValue("user", user);
				setValue("error",e.getMessage());
				return LOGIN;
			}
		}
		if(user!=null){
			setValue("user", user);
		}
		return LOGIN;
	}
	
	public String updatePassword() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			return LOGIN;
		}
		if(user!=null&&StringUtils.isNotBlank(user.getPassword())&&StringUtils.isNotBlank(newpassword)&&StringUtils.isNotBlank(re_newpassword)){
			if(newpassword.length()<6){
				setValue("error","密码必须大于6个字符");
				setValue("user", user);
				return INPUT;
			}
			if(!newpassword.equals(re_newpassword)){
				setValue("error","两次输入的密码不匹配");
				setValue("user", user);
				return INPUT;
			}
			try{
				Users result = internalUserService.updateUserPassword(_user.getAccount(), user.getPassword(),newpassword);
				clearSession(session_user);
				result.setPassword("");
				setValue("user", result);
				setValue("error", "修改密码成功，请重新登录!");
				return LOGIN;
			}catch(Exception e){
				setValue("user", user);
				setValue("error",e.getMessage());
				return INPUT;
			}
		}
		if(user!=null){
			setValue("user", user);
		}
		return INPUT;
	}
	
	public String updateHeader() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			return LOGIN;
		}
		try{
			String extType = "";
			if(pic!=null&&picContentType!=null){
				extType = CommonMethod.getInstance().isAllowedPicture(picContentType);
				if(extType==null){
					setValue("error","头像必须为PNG,JPEG,GIF格式的图片");
					return INPUT;
				}
				InputStream header = new FileInputStream(pic);
				Users result = internalUserService.updateUsersHeader(_user.getAccount(), header, getRootPath(), extType);
				_user.setHeader(result.getHeader());
				return INPUT;
			}
			setValue("error","请选择图片作为你的头像");
			return INPUT;
		}catch(Exception e){
			setValue("error",e.getMessage());
			return INPUT;
		}
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRe_newpassword() {
		return re_newpassword;
	}

	public void setRe_newpassword(String reNewpassword) {
		re_newpassword = reNewpassword;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getUser() {
		return user;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public void setInternalUserService(InternalUserService internalUserService) {
		this.internalUserService = internalUserService;
	}
	
	
}
