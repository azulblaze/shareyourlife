package com.twitpic.domain;


import net.sf.json.JSONException;

import com.twitpic.db.model.Pictures;
import com.twitpic.db.model.PicturesParameter;

import junit.framework.TestCase;

public class TestJsonMode extends TestCase {
	
	public void testPictureInfo() throws JSONException{
		PictureInfo pi = new PictureInfo();
		Pictures p = new Pictures();
		p.setFull("full");
		p.setId(1l);
		p.setLarge("large");
		p.setMin("min");
		p.setThumb("thumb");
		pi.setPictures(p);
		
		PicturesParameter pp = new PicturesParameter();
		pp.setAddtionInfo("addtioninfo");
		pp.setDescription("description");
		pp.setIdPictures(1l);
		pp.setStatus(1);
		pp.setUploadAccount("account");
		pp.setUploadTime(new java.util.Date());
		
		pi.setPicturesParameter(pp);
		
		pi.setAccount("account");
		pi.setName("name");
		pi.setPicture("picture");
		System.out.println(pp.to_json());
		System.out.println(p.to_json());
		System.out.println(pi.to_json());
	}
}
