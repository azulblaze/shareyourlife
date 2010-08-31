package com.zhelazhela.cloudblog.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class BaseBean {
	
	private static XStream xs = new XStream(new XppDriver(new XmlFriendlyReplacer("__", "_")));;
	
	protected BaseBean(String node_name){
		xs.alias(node_name, this.getClass());
		xs.alias("user", User.class);
		xs.alias("post", Post.class);
		xs.alias("reply", Reply.class);
		xs.alias("message", Message.class);
	}
	
	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	public String getResultCode(){
		if(result!=null){
			return result.getCode();
		}
		return Result.FAIL;
	}
	
	public void setResultCode(String code){
		if(result==null){
			result = new Result();
		}
		result.setCode(code);
	}
	
	public String getResultDesc(){
		if(result!=null){
			return result.getDescription();
		}
		return "";
	}
	
	public void setResultDesc(String desc){
		if(result==null){
			result = new Result();
		}
		result.setDescription(desc);
	}
	
	public String toXML(){
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"+xs.toXML(this);
	}
}
