package com.zhela.cloudblog.rest.user;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zhela.cloudblog.rest.BaseResource;
import com.zhela.cloudblog.rest.model.RESTInternalUser;
import com.zhela.cloudblog.service.internaluser.InternalUserService;
import com.zhela.cloudblog.util.ModeConvert;
@Path("/user_account")
public class UserAccountResource extends BaseResource {
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
	
	private InternalUserService internalUserService;
	public void setInternalUserService(InternalUserService internalUserService) {
		this.internalUserService = internalUserService;
	}
}
