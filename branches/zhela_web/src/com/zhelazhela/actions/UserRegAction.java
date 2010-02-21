package com.zhelazhela.actions;

import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import net.sf.json.JSONObject;

import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.UserProfileService;

public class UserRegAction extends BaseAction {
	
	private static final long serialVersionUID = 8584323814602750202L;
	private SNSUser user;
	private long recommend;
	private String url;
	
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
			return "json";
		}
		if(tmp!=null&&tmp.getReg_level()>0){
			jb.put("result", "fail");
			jb.put("msg", "您的账号已经激活，不需要再次激活");
			this.setValue("json",jb);
			return "json";
		}
		try{
			if(user!=null&&!StringUtils.isBlank(user.getEmail())){
				tmp.setEmail(user.getEmail());
			}
			userProfileService.reSendActMail(tmp);
			jb.put("result", "success");
			jb.put("msg", "重新发送成功，请使用链接激活您的账号");
			this.setValue("json",jb);
			return "json";
		}catch(Exception e){
			jb.put("result", "fail");
			jb.put("msg", e.getMessage());
			this.setValue("json",jb);
			return "json";
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
	
	public String trackUser() throws Exception{
		return SUCCESS;
	}
	
}
