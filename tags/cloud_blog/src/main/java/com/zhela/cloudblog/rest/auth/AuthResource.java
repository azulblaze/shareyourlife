package com.zhela.cloudblog.rest.auth;

import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.zhela.cloudblog.rest.BaseResource;
import com.zhela.cloudblog.rest.model.RESTResponse;
import com.zhela.cloudblog.service.auth.ClientAuthService;

@Path("/auth")
public class AuthResource extends BaseResource{
	
	public class DeviceStatus{
		public final static int ACTION_LOGIN = 1;
		public final static int ACTION_LOGOUT = 2;
		private String device_id;
		private String device_name;
		private String device_sys;
		private String transID;
		public String getDevice_id() {
			return device_id;
		}
		public void setDevice_id(String deviceId) {
			device_id = deviceId;
		}
		public String getDevice_name() {
			return device_name;
		}
		public void setDevice_name(String deviceName) {
			device_name = deviceName;
		}
		public String getDevice_sys() {
			return device_sys;
		}
		public void setDevice_sys(String deviceSys) {
			device_sys = deviceSys;
		}
		public String getTransID() {
			return transID;
		}
		public void setTransID(String transID) {
			this.transID = transID;
		}
		
	}
	
	private static java.util.List<String> appKeys = new java.util.ArrayList<String>();
	private final static String SESSION_SERIALID = "serialID";
	static{
		appKeys.add("8ca4e82e189afbd");
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{appKey}")
	public Response getAuth(@PathParam("appKey") String appKey){
		Response response;
		servletRequest.getSession().invalidate();
		try{
			if(appKeys.contains(appKey)){
				String sessionid = getSessionId()+System.currentTimeMillis();
				String serialID = clientAuthService.getSerialID(appKey, sessionid);
				if(serialID!=null&&serialID.trim().length()>0){
					saveSession(SESSION_SERIALID, serialID);
					response = genOK(new RESTResponse(Status.OK,serialID));
					return response;
				}
			}
			response = RESPONSE_UNAUTHORIZED;
		}catch(Exception e){
			response = RESPONSE_SERVICE_UNAVAILABLE;
		}
		return response;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{enc_Key}/{deviceType}/{deviceSys}/{deviceID}")
	public Response Auth(@PathParam("enc_Key") String enc_Key,
			@PathParam("deviceType") String deviceType,
			@PathParam("deviceSys") String deviceSys,
			@PathParam("deviceID") String deviceID){
		Response response;
		String serialID = (String)getSession(SESSION_SERIALID);
		clearSession(SESSION_SERIALID);
		try{
			if(clientAuthService.checkSerialID(enc_Key, serialID)){
				DeviceStatus status = new DeviceStatus();
				status.setDevice_id(deviceID);
				status.setDevice_sys(deviceSys);
				status.setDevice_name(deviceType);
				status.setTransID(enc_Key);
				saveSession(SESSION_AUTH, status);
				clientAuthService.insertDeviceLog(status, getSessionId(), DeviceStatus.ACTION_LOGIN);
				response = genOK(new RESTResponse(Status.OK,"Success"));
				return response;
			}
			response = RESPONSE_UNAUTHORIZED;
		}catch(Exception e){
			response = RESPONSE_SERVICE_UNAVAILABLE;
		}
		return response;
	}
	
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/")
	public Response delAuth(){
		if(!isAuth()){
			return RESPONSE_UNAUTHORIZED;
		}
		DeviceStatus status = (DeviceStatus) getSession(SESSION_AUTH);
		clientAuthService.insertDeviceLog(status, getSessionId(), DeviceStatus.ACTION_LOGOUT);
		clearSession(SESSION_AUTH);
		servletRequest.getSession().invalidate();
		return  genOK(new RESTResponse(Status.OK,"Success"));
	}
	
	private ClientAuthService clientAuthService;


	public void setClientAuthService(ClientAuthService clientAuthService) {
		this.clientAuthService = clientAuthService;
	}
	
	
}
