package com.zhela.cloudblog.rest.auth;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.zhela.cloudblog.rest.BaseResource;
import com.zhela.cloudblog.rest.model.RESTResponse;
import com.zhela.cloudblog.service.auth.ClientAuthService;

@Path("/auth")
public class AuthResource extends BaseResource{
	
	private static java.util.List<String> appKeys = new java.util.ArrayList<String>();
	private final static String SESSION_SERIALID = "serialID";
	static{
		appKeys.add("android8");
		appKeys.add("android7");
		appKeys.add("android4");
		appKeys.add("android3");
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{appKey}")
	public Response getAuthSerialID(@PathParam("appKey") String appKey,@Context HttpServletRequest servletRequest){
		Response response;
		//clearSession(servletRequest,SESSION_SERIALID);
		servletRequest.getSession().invalidate();
		try{
			if(appKeys.contains(appKey)){
				String sessionid = servletRequest.getSession().getId()+System.currentTimeMillis();
				String serialID = clientAuthService.getSerialID(appKey, sessionid);
				if(serialID!=null&&serialID.trim().length()>0){
					saveSession(servletRequest,SESSION_SERIALID, serialID);
					response = Response.status(Status.OK)
					.entity(new RESTResponse(Status.OK,serialID))
					.build();
					return response;
				}
			}
			response = Response.status(Status.UNAUTHORIZED)
			.entity(new RESTResponse(Status.UNAUTHORIZED,"Not Allowed"))
			.build();
		}catch(Exception e){
			response = Response.status(Status.SERVICE_UNAVAILABLE)
			.entity(new RESTResponse(Status.SERVICE_UNAVAILABLE,"System Exception"))
			.build();
		}
		return response;
	}
	
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{enc_Key}")
	public Response postAuthSerialID(@PathParam("enc_Key") String enc_Key,@Context HttpServletRequest servletRequest){
		Response response;
		String serialID = (String)getSession(servletRequest,SESSION_SERIALID);
		clearSession(servletRequest,SESSION_SERIALID);
		try{
			if(clientAuthService.checkSerialID(enc_Key, serialID)){
				saveSession(servletRequest,SESSION_AUTH, "Success");
				response = Response.status(Status.OK)
				.entity(new RESTResponse(Status.OK,"Success"))
				.build();
				return response;
			}
			response = Response.status(Status.UNAUTHORIZED)
			.entity(new RESTResponse(Status.UNAUTHORIZED,"Not Allowed"))
			.build();
		}catch(Exception e){
			response = Response.status(Status.SERVICE_UNAVAILABLE)
			.entity(new RESTResponse(Status.SERVICE_UNAVAILABLE,"System Exception"))
			.build();
		}
		return response;
	}
	
	
	private ClientAuthService clientAuthService;


	public void setClientAuthService(ClientAuthService clientAuthService) {
		this.clientAuthService = clientAuthService;
	}
	
	
}
