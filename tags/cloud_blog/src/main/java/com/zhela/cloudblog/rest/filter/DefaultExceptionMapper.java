package com.zhela.cloudblog.rest.filter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.resource.Singleton;

/**
 * <p>Default exception mapper for any exceptions.</p>
 * <p>Here we can have high-level control of HTTP response.</p> 
 *
 */
//@Provider
//@Singleton
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		
		//handle REST exceptions
		if(exception instanceof WebApplicationException) {
			WebApplicationException webApplicationException = (WebApplicationException) exception;
			
			//map 415(unsupported media type) to 400(bad request)
			if(webApplicationException.getResponse().getStatus() == Status.UNSUPPORTED_MEDIA_TYPE.getStatusCode())
			{
				return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN).entity("Please set Content-Type request header.").build();
			}
		}
		
		//any other exceptions to 503(service unavailable)
		return Response.status(Status.SERVICE_UNAVAILABLE).type(MediaType.TEXT_PLAIN).entity("Try again later.").build();
	
		
	}

}
