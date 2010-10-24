package com.zhela.cloudblog.rest.provider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zhela.cloudblog.rest.BaseResource;
import com.zhela.cloudblog.service.provider.ProviderService;
import com.zhela.cloudblog.util.ModeConvert;
@Path("/providers")
public class ProviderResource extends BaseResource{

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/")
	public Response getProviders() {
		if(!isAuth()){
			return RESPONSE_UNAUTHORIZED;
		}
		try{
			return genOK(ModeConvert.ProvidersListToREST(0, -1, providerService.selectAllProviders()));
		}catch(Exception e){
			e.printStackTrace();
			return RESPONSE_SERVICE_UNAVAILABLE;
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XHTML_XML})
	@Path("/{providerId}/tweets")
	public Response getTweets(){
		if(!isAuth()){
			return RESPONSE_UNAUTHORIZED;
		}
		try{
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return RESPONSE_SERVICE_UNAVAILABLE;
		}
	}
	
	private ProviderService providerService;
	public void setProviderService(ProviderService providerService) {
		this.providerService = providerService;
	}
	
}
