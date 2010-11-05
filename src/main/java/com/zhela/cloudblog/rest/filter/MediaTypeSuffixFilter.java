package com.zhela.cloudblog.rest.filter;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class MediaTypeSuffixFilter implements ContainerRequestFilter {

	
	public ContainerRequest filter(ContainerRequest request) {
		String uri = request.getRequestUri().getRawPath();
		if(uri.endsWith(".json")){
			uri = uri.substring(0,uri.length()-5);
			request.setUris(request.getBaseUri(), request.getRequestUriBuilder().replacePath(uri).build());
			request.getRequestHeaders().putSingle("Accept", MediaType.APPLICATION_JSON);
		}
		if(uri.endsWith(".xml")){
			uri = uri.substring(0,uri.length()-4);
			request.setUris(request.getBaseUri(), request.getRequestUriBuilder().replacePath(uri).build());
			request.getRequestHeaders().putSingle("Accept", MediaType.APPLICATION_XML);
		}
		return request;
	}
}
