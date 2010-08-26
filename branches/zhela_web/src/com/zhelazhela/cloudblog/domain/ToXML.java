package com.zhelazhela.cloudblog.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDomDriver;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class ToXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Post p = new Post();
		User u = new User();
		p.setUser(u);
		u.setAccount("chenyan");
		u.setId("123");
		u.setDisplay_name("Cashguy");
		u.setFans_count("21");
		Post p2 = new Post();
		p2.setId("fskdf");
		p.setForward_post(p2);
		p.setId("4324");
		XStream xs =new XStream(new XppDriver(new XmlFriendlyReplacer("__", "_")));
		xs.alias("user", User.class);
		xs.alias("post", Post.class);
		//xs.aliasField("display_name", User.class, "display_name");
		String xml = xs.toXML(p);
		System.out.println(xml);
	}

}
