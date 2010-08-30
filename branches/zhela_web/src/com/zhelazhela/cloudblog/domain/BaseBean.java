package com.zhelazhela.cloudblog.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class BaseBean {

	public final static String SUCCESS  = "1";
	
	public final static String FAIL  = "0";
	
	public final static String NEEDLOGIN  = "2";
		
	private static XStream xs = new XStream(new XppDriver(new XmlFriendlyReplacer("__", "_")));;
	
	protected BaseBean(String node_name){
		xs.alias(node_name, this.getClass());
		xs.alias("user", User.class);
		xs.alias("post", Post.class);
	}
	
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String toXML(){
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"+xs.toXML(this);
	}
}
