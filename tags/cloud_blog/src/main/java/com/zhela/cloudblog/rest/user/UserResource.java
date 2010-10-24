package com.zhela.cloudblog.rest.user;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.zhela.cloudblog.rest.BaseResource;
@Path("/user")
public class UserResource extends BaseResource {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{account}/{password}")
	public Response getUser(@PathParam("account") String account,
			@PathParam("password") String password){
		return null;
	}
	
	/**
	 * <form action="upload" enctype="multipart/form-data" method="POST">

		//here we are giving the file name which will be
		//used in service to access the file
		<input type="file" name="attachmentFile" />
		<input type="submit" value="submit" />
		</form>
	 * @param dispostion
	 * @param attachmentFile
	 * @return
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes("multipart/form-data")
	@Path("/header")
	public Response putUserHeader(@FormParam("attachmentFile") FormDataContentDisposition dispostion,
		      @FormParam("attachmentFile") InputStream attachmentFile){
		String fileName = dispostion.getFileName();
		return null;
	}
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{account}/{password}")
	public Response delteUser(){
		return null;
	}
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{account}/{password}/{email}/{name}")
	public Response postUser(){
		return null;
	}
}
