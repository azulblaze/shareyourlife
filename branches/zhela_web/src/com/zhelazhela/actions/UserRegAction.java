package com.zhelazhela.actions;


import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.zhelazhela.db.model.BaseProfile;
import com.zhelazhela.db.model.ContactProfile;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.UserProfileService;
import com.zhelazhela.util.CommonMethod;

public class UserRegAction extends BaseAction {
	
	private static final long serialVersionUID = 8584323814602750202L;
	private SNSUser user;
	private long recommend;
	private String url;
	private BaseProfile bp;
	private ContactProfile cp;
	
	private CacheService cacheService;
	
	private UserProfileService userProfileService;
	
	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public SNSUser getUser() {
		return user;
	}

	public void setUser(SNSUser user) {
		this.user = user;
	}

	public long getRecommend() {
		return recommend;
	}

	public void setRecommend(long recommend) {
		this.recommend = recommend;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BaseProfile getBp() {
		return bp;
	}

	public void setBp(BaseProfile bp) {
		this.bp = bp;
	}

	public ContactProfile getCp() {
		return cp;
	}

	public void setCp(ContactProfile cp) {
		this.cp = cp;
	}

	public String login() throws Exception{
		this.clearSession("user");
		setValue("url",this.getRequestParameter("url"));
		if(user==null){
			return INPUT;
		}
		if(StringUtils.isBlank(user.getAccount())||StringUtils.isBlank(user.getPassword())){
			setValue("error","请输入账号和密码");
			return INPUT;
		}
		try{
			user  = userProfileService.logUser(user);
		}catch(Exception e){
			setValue("error",e.getMessage());
			return INPUT;
		}
		saveSession("user",user);
		if(user.getReg_level()>0){
			if(url!=null&&url.trim().length()>0){
				return "url";
			}
			return SUCCESS;
		}else{
			return "act";
		}
	}
	
	public String remail() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			jb.put("msg", "请先登陆后再发送激活链接");
			this.setValue("json",jb);
			return JSON;
		}
		if(tmp!=null&&tmp.getReg_level()>0){
			jb.put("result", "fail");
			jb.put("msg", "您的账号已经激活，不需要再次激活");
			this.setValue("json",jb);
			return JSON;
		}
		try{
			if(user!=null&&!StringUtils.isBlank(user.getEmail())){
				tmp.setEmail(user.getEmail());
			}
			userProfileService.reSendActMail(tmp);
			jb.put("result", "success");
			jb.put("msg", "重新发送成功，请使用链接激活您的账号");
			this.setValue("json",jb);
			return JSON;
		}catch(Exception e){
			jb.put("result", "fail");
			jb.put("msg", e.getMessage());
			this.setValue("json",jb);
			return JSON;
		}
		
	}
	
	public String reg() throws Exception{
		this.clearSession("user");
		this.setValue("questions",cacheService.loadSecurityQuestions());
		if(user ==null){
			return INPUT;
		}
		setValue("user",user);
		if(!user.isValid()){
			throw new Exception();
		}
		try{
			user = userProfileService.regUser(user, recommend);
		}catch(Exception e){
			setValue("error",e.getMessage());
			return INPUT;
		}
		this.saveSession("user", user);
		return SUCCESS;
	}
	
	public String activity() throws Exception{
		String tmp = this.getRequestParameter("id");
		String code = this.getRequestParameter("code");
		long id = 0;
		try{
			id  = Long.parseLong(tmp);
		}catch(Exception e){
			
		}
		if(id<=0||StringUtils.isBlank(code)){
			throw new Exception();
		}
		try{
			boolean result = userProfileService.actUser(id, code);
			if(result){
				setValue("msg","激活成功，您现在可以使用这个账户登陆");
			}else{
				setValue("msg","非常抱歉，激活失败，请确认您的链接是否正确");
			}
		}catch(Exception e){
			throw new Exception(e);
		}
		return SUCCESS;
	}
	
	public String profile() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(tmp==null){
			return LOGIN;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		return SUCCESS;
	}
	
	public String addProfile() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json",jb);
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		try{
			bp.setUserId(tmp.getId());
			bp = userProfileService.editBaseProfile(bp);
			jb.put("result", "success");
			jb.put("msg", "更新成功");
			jb.put("data", bp);
			this.setValue("json",jb);
			return JSON;
		}catch(Exception e){
			jb.put("result", "fail");
			jb.put("msg", e.getMessage());
			this.setValue("json",jb);
			return JSON;
		}
		
	}
	
	public String addContact() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json",jb);
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		try{
			cp.setUserId(tmp.getId());
			cp = userProfileService.addContactProfile(cp);
			jb.put("result", "success");
			jb.put("msg", "增加成功");
			jb.put("data", cp);
			this.setValue("json",jb);
			return JSON;
		}catch(Exception e){
			jb.put("result", "fail");
			jb.put("msg", e.getMessage());
			this.setValue("json",jb);
			return JSON;
		}
	}
	
	public String editContact() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json",jb);
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		try{
			if(cp.getId()==null||cp.getId()<=0){
				jb.put("result", "fail");
				jb.put("msg", "错误的提交");
				jb.put("data", cp);
				this.setValue("json",jb);
				return JSON;
			}
			cp.setUserId(tmp.getId());
			cp = userProfileService.addContactProfile(cp);
			jb.put("result", "success");
			jb.put("msg", "增加成功");
			jb.put("data", cp);
			this.setValue("json",jb);
			return JSON;
		}catch(Exception e){
			jb.put("result", "fail");
			jb.put("msg", e.getMessage());
			this.setValue("json",jb);
			return JSON;
		}
	}
	
	public String delContact() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json",jb);
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		try{
			if(cp.getId()==null||cp.getId()<=0){
				jb.put("result", "fail");
				jb.put("msg", "错误的提交");
				jb.put("data", cp);
				this.setValue("json",jb);
				return JSON;
			}
			boolean result = userProfileService.delContactProfile(cp.getId(), cp.getUserId());
			if(result){
				jb.put("result", "success");
				jb.put("msg", "删除成功");
			}else{
				jb.put("result", "fail");
				jb.put("msg", "删除失败");
			}
			jb.put("data", cp);
			this.setValue("json",jb);
			return JSON;
		}catch(Exception e){
			jb.put("result", "fail");
			jb.put("msg", e.getMessage());
			this.setValue("json",jb);
			return JSON;
		}
	}
	
	public String loadContact() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(tmp==null){
			return LOGIN;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		setValue("contacts",userProfileService.loadContactProfile(tmp.getId()));
		return SUCCESS;
	}
	
	public String updatePassword() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json",jb);
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		boolean check = false;
		String msg = "";
		if(user!=null){
			try{
				user.setId(tmp.getId());
				SNSUser _user  = userProfileService.logUser(user);
				if(_user==null){
					msg = "您输入的原始密码错误";
				}else{
					check = true;
				}
			}catch(Exception e){
				msg = e.getMessage();
			}
		}
		//原始密码验证失败,直接返回
		if(!check){
			jb.put("result", "fail");
			jb.put("msg", msg);
			this.setValue("json",jb);
			return JSON;
		}
		//验证新密码是否合法
		check = false;
		String newpass = user.getNewpassword();
		if(newpass!=null){
			newpass = newpass.trim();
			if(newpass.length()>=6){
				check = true;
			}
		}
		//新密码不合法,返回
		if(!check){
			jb.put("result", "fail");
			jb.put("msg", "新密码不能包含空格,必须大于6位");
			this.setValue("json",jb);
			return JSON;
		}
		//可以更新密码了
		boolean result  = userProfileService.updatePassword(tmp.getId(), CommonMethod.getInstance().getMD5(newpass));
		if(result){
			jb.put("result", "success");
			jb.put("msg", "更新成功,请牢记您的密码");
			this.setValue("json",jb);
			return JSON;
		}else{
			jb.put("result", "fail");
			jb.put("msg", "失败,系统故障");
			this.setValue("json",jb);
			return JSON;
		}
	}
}
