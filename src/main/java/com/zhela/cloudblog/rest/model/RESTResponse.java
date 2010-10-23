package com.zhela.cloudblog.rest.model;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name="response")
@XmlType(propOrder={"status","description"})
public class RESTResponse {

	private Status status;
	private String description;
	
	public RESTResponse(){
		
	}
	public RESTResponse(Status status,String description){
		this.status = status;
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
