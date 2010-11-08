package com.zhela.cloudblog.rest.user;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import com.zhela.cloudblog.model.users.Users;
import com.zhela.cloudblog.rest.BaseResource;
import com.zhela.cloudblog.rest.model.RESTInternalUser;
import com.zhela.cloudblog.rest.model.RESTResponse;
import com.zhela.cloudblog.service.internaluser.InternalUserService;
import com.zhela.cloudblog.util.CommonMethod;
import com.zhela.cloudblog.util.ModeConvert;
@Path("/users")
public class UserResource extends BaseResource {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{account}/{password}")
	public Response getUser(@PathParam("account") String account,
			@PathParam("password") String password){
		clearSession(SESSION_USER);
		clearSession(SESSION_PROVIDERACCOUNT);
		try{
			RESTInternalUser restiu = ModeConvert.InternalUserToREST(internalUserService.getUsers(account, password));
			saveSession(SESSION_USER,restiu);
			saveSession(SESSION_PROVIDERACCOUNT,internalUserService.getProviderAccount(account));
			return genOK(restiu);
		}catch(Exception e){
			return genNotAcceptable(e.getMessage());
		}
	}
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{account}/{password}/{email}/{name}")
	public Response postUser(@PathParam("account") String account,
			@PathParam("password") String password,
			@PathParam("email") String email,
			@PathParam("name") String name){
		clearSession(SESSION_USER);
		clearSession(SESSION_PROVIDERACCOUNT);
		if(!isAuth()){
			return RESPONSE_UNAUTHORIZED;
		}
		try{
			RESTInternalUser restiu = ModeConvert.InternalUserToREST(internalUserService.insertUsers(account, password, email, name));
			saveSession(SESSION_USER,restiu);
			return genOK(restiu);
		}catch(Exception e){
			return genNotAcceptable(e.getMessage());
		}
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/providers")
	public Response getProviderUsers(){
		if(!isLogin()){
			return RESPONSE_NEEDLOGIN;
		}
		try{
			RESTInternalUser restiu = (RESTInternalUser)getSession(SESSION_USER);
			return genOK(ModeConvert.ProviderUserToREST(internalUserService.getProviderAccount(restiu.getAccount())));
		}catch(Exception e){
			return genNotAcceptable(e.getMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	@Path("/header")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response putUserHeader(@FormDataParam("attachmentFile") InputStream attachmentFile,
			@FormDataParam("attachmentFile") FormDataContentDisposition dispostion){
		try{
			if(!isLogin()){
				return RESPONSE_NEEDLOGIN;
			}
			String fileName = dispostion.getFileName();
			int index = fileName.lastIndexOf(".");
			String extType = "";
			if(index>0){
				extType = fileName.substring(index+1);
				extType = extType.toLowerCase();
			}
			if(CommonMethod.getInstance().isAllowedPicture(extType)!=null){
				RESTInternalUser restiu = (RESTInternalUser)getSession(SESSION_USER);
				Users users = internalUserService.updateUsersHeader(restiu.getAccount(), attachmentFile, servletRequest.getRealPath("/"), extType);
				return genOK(ModeConvert.InternalUserToREST(users));
			}else{
				return genNotAcceptable(new RESTResponse(Status.NOT_ACCEPTABLE,"Cannot support your format"));
			}
		}catch(Exception e){
		}
		return RESPONSE_SERVICE_UNAVAILABLE;
	}
	
	private InternalUserService internalUserService;
	public void setInternalUserService(InternalUserService internalUserService) {
		this.internalUserService = internalUserService;
	}
	
}
