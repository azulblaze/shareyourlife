package com.zhela.cloudblog.rest.provider;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.zhela.cloudblog.model.users.ProviderUser;
import com.zhela.cloudblog.rest.BaseResource;
import com.zhela.cloudblog.rest.model.RESTInternalUser;
import com.zhela.cloudblog.rest.model.RESTResponse;
import com.zhela.cloudblog.service.internaluser.InternalUserService;
import com.zhela.cloudblog.service.provider.ProviderService;
import com.zhela.cloudblog.service.tweet.TweetService;
import com.zhela.cloudblog.util.ModeConvert;
@Path("/providers")
public class ProviderResource extends BaseResource{

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/")
	public Response getProviders() {
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
	/**
	 * Post provide user to system.
	 */
	public Response postProviderAccount(@PathParam("providerId") long providerId,
			@PathParam("providerAccount") String providerAccount,
			@PathParam("providerPassword") String providerPassword){
		try{
			RESTInternalUser restiu = (RESTInternalUser)getSession(SESSION_USER);
			internalUserService.updateProviderUser(providerId, restiu.getAccount(),providerAccount, ProviderUser.STATUS_OK, providerAccount, providerPassword);
			saveSession(SESSION_PROVIDERACCOUNT,internalUserService.getProviderAccount(restiu.getAccount()));
			return genOK(new RESTResponse(Status.OK,"Success"));
		}catch(Exception e){
			return genNotAcceptable(new RESTResponse(Status.NOT_ACCEPTABLE,e.getMessage()));
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XHTML_XML})
	@Path("/{providerId}/{providerAccount}/tweet/hometweet")
	/**
	 * get Home Twitter.
	 */
	public Response getHomeTweet(@PathParam("providerId") long providerId,
			@PathParam("providerAccount") String providerAccount,
			@DefaultValue("20") @QueryParam("s") int size,
			@DefaultValue("-1") @QueryParam("p") long position,
			@DefaultValue("1") @QueryParam("d") int direction){
		try{
			ProviderUser pu = getProviderUserByAccount(providerId,providerAccount);
			return genOK(tweetService.selectHomeTweetByProvider(position, direction, size, pu));
		}catch(Exception e){
			return genNotAcceptable(new RESTResponse(Status.NOT_ACCEPTABLE,e.getMessage()));
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XHTML_XML})
	@Path("/{providerId}/{providerAccount}/tweet/usertweet/{userId}")
	/**
	 * get Home Twitter.
	 */
	public Response getUserTweet(@PathParam("providerId") long providerId,
			@PathParam("providerAccount") String providerAccount,
			@PathParam("userId") String userId,
			@DefaultValue("20") @QueryParam("s") int size,
			@DefaultValue("-1") @QueryParam("p") long position,
			@DefaultValue("1") @QueryParam("d") int direction){
		try{
			ProviderUser pu = getProviderUserByAccount(providerId,providerAccount);
			return genOK(tweetService.selectUserTweetByProvider(userId,position, direction, size, pu));
		}catch(Exception e){
			return genNotAcceptable(new RESTResponse(Status.NOT_ACCEPTABLE,e.getMessage()));
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XHTML_XML})
	@Path("/{providerId}/{providerAccount}/tweet/{tweetId}")
	/**
	 * get Twitter by ID.
	 */
	public Response getTweet(@PathParam("providerId") long providerId,
			@PathParam("providerAccount") String providerAccount,
			@PathParam("tweetId") String tweetId){
		try{
			ProviderUser pu = getProviderUserByAccount(providerId,providerAccount);
			return genOK(tweetService.selectTweet(tweetId, pu));
		}catch(Exception e){
			return genNotAcceptable(new RESTResponse(Status.NOT_ACCEPTABLE,e.getMessage()));
		}
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XHTML_XML})
	@Path("/{providerId}/{providerAccount}/tweet/{tweetId}")
	/**
	 * get Twitter by ID.
	 */
	public Response deleteTweet(@PathParam("providerId") long providerId,
			@PathParam("providerAccount") String providerAccount,
			@PathParam("tweetId") String tweetId){
		try{
			ProviderUser pu = getProviderUserByAccount(providerId,providerAccount);
			boolean result = tweetService.deleteTweet(tweetId, pu);
			if(result){
				
			}
			return null;
			//return genOK();
		}catch(Exception e){
			return genNotAcceptable(new RESTResponse(Status.NOT_ACCEPTABLE,e.getMessage()));
		}
	}
	
	
	
	private ProviderService providerService;
	private InternalUserService internalUserService;
	private TweetService tweetService;
	public void setInternalUserService(InternalUserService internalUserService) {
		this.internalUserService = internalUserService;
	}
	public void setProviderService(ProviderService providerService) {
		this.providerService = providerService;
	}
	public void setTweetService(TweetService tweetService) {
		this.tweetService = tweetService;
	}
	
}
