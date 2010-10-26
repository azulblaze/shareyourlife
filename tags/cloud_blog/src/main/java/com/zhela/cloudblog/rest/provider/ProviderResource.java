package com.zhela.cloudblog.rest.provider;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.zhela.cloudblog.model.users.ProviderUser;
import com.zhela.cloudblog.rest.BaseResource;
import com.zhela.cloudblog.rest.model.RESTInternalUser;
import com.zhela.cloudblog.rest.model.RESTResponse;
import com.zhela.cloudblog.service.internaluser.InternalUserService;
import com.zhela.cloudblog.service.provider.ProviderService;
import com.zhela.cloudblog.util.ModeConvert;
@Path("/providers")
public class ProviderResource extends BaseResource{

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/")
	public Response getProviders() {
		if(!isLogin()){
			return RESPONSE_NEEDLOGIN;
		}
		try{
			return genOK(ModeConvert.ProvidersListToREST(0, -1, providerService.selectAllProviders()));
		}catch(Exception e){
			e.printStackTrace();
			return RESPONSE_SERVICE_UNAVAILABLE;
		}
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XHTML_XML})
	@Path("/{providerId}/{providerAccount}")
	public Response deleteProviderAccount(@PathParam("providerId") long providerId,
			@PathParam("providerAccount") String providerAccount){
		if(!isLogin()){
			return RESPONSE_NEEDLOGIN;
		}
		try{
			RESTInternalUser restiu = (RESTInternalUser)getSession(SESSION_USER);
			internalUserService.delProviderUser(providerId, restiu.getAccount(), providerAccount);
			saveSession(SESSION_PROVIDERACCOUNT,internalUserService.getProviderAccount(restiu.getAccount()));
			return genOK(new RESTResponse(Status.OK,"Success"));
		}catch(Exception e){
			return RESPONSE_SERVICE_UNAVAILABLE;
		}
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XHTML_XML})
	@Path("/{providerId}/{providerAccount}/{status}")
	public Response updateProviderAccountStatus(@PathParam("providerId") long providerId,
			@PathParam("providerAccount") String providerAccount,
			@PathParam("status") int status){
		if(!isLogin()){
			return RESPONSE_NEEDLOGIN;
		}
		try{
			RESTInternalUser restiu = (RESTInternalUser)getSession(SESSION_USER);
			internalUserService.updateProviderUser(providerId, restiu.getAccount(), providerAccount, status, null, null);
			saveSession(SESSION_PROVIDERACCOUNT,internalUserService.getProviderAccount(restiu.getAccount()));
			return genOK(new RESTResponse(Status.OK,"Success"));
		}catch(Exception e){
			return RESPONSE_SERVICE_UNAVAILABLE;
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XHTML_XML})
	@Path("/{providerId}/{providerAccount}/{providerPassword}")
	public Response postProviderAccount(@PathParam("providerId") long providerId,
			@PathParam("providerAccount") String providerAccount,
			@PathParam("providerPassword") String providerPassword){
		if(!isLogin()){
			return RESPONSE_NEEDLOGIN;
		}
		try{
			RESTInternalUser restiu = (RESTInternalUser)getSession(SESSION_USER);
			internalUserService.updateProviderUser(providerId, restiu.getAccount(),providerAccount, ProviderUser.STATUS_OK, providerAccount, providerPassword);
			saveSession(SESSION_PROVIDERACCOUNT,internalUserService.getProviderAccount(restiu.getAccount()));
			return genOK(new RESTResponse(Status.OK,"Success"));
		}catch(Exception e){
			return genNotAcceptable(new RESTResponse(Status.NOT_ACCEPTABLE,e.getMessage()));
		}
	}
	
	private ProviderService providerService;
	private InternalUserService internalUserService;
	public void setInternalUserService(InternalUserService internalUserService) {
		this.internalUserService = internalUserService;
	}
	public void setProviderService(ProviderService providerService) {
		this.providerService = providerService;
	}
	
}
