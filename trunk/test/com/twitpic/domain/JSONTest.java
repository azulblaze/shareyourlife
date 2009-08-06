package com.twitpic.domain;

import java.text.SimpleDateFormat;
import com.twitpic.db.model.PicturesParameter;

public class JSONTest {
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		
		PicturesParameter p = new PicturesParameter();
		p.setUploadTime(new java.util.Date());
		p.setFormat(new SimpleDateFormat("yyyy年MM-dd kk:mm:ss"));
		System.out.println(p.to_json());
	}
}
