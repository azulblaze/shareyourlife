package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name="s_comment_list")
public class RESTServiceCommentList {
	@SerializedName("s_comments")
	private java.util.List<RESTServiceComment> comment;
	private int nextPage = 0;
	private int lastPage = 0;
	private int count;
	
	public String loadJSON(){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
	    .create();
		String result = gson.toJson(this);
		return StringUtils.replace(result,"\\","\\\\");
	}
	
	@XmlElement(name="s_comments")
	public java.util.List<RESTServiceComment> getComment() {
		return comment;
	}
	public void setComment(java.util.List<RESTServiceComment> comment) {
		this.comment = comment;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public static void main(String args[]) throws Exception{
		String _tmp = "sdfsdl\\sfds\\fsdf\\n";
		System.out.println(_tmp);
		String str = StringUtils.replace(_tmp,"\\","\\\\");
		System.out.println(str);
	}
}
