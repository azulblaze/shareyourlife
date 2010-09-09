package com.zhelazhela.cloudblog.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.zhelazhela.db.model.Providers;

public class ProviderList {
	
	public static final int NEEDUPDATE_YES = 1;
	
	public static final int NEEDUPDATE_NO = 0;
	
	private static XStream xs = new XStream(new XppDriver(new XmlFriendlyReplacer("__", "_")));;
	
	public ProviderList(){
		xs.alias("providerlist", this.getClass());
		xs.alias("provider", com.zhelazhela.db.model.Providers.class);
	}
	
	public String toXML(){
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"+xs.toXML(this);
	}
	
	private int needupdate = 0;
	
	private java.util.List<Providers> providers;

	public int getNeedupdate() {
		return needupdate;
	}

	public void setNeedupdate(int needupdate) {
		this.needupdate = needupdate;
	}

	public java.util.List<Providers> getProviders() {
		return providers;
	}

	public void setProviders(java.util.List<Providers> providers) {
		this.providers = providers;
	}
	
}
