package com.twitpic.domain;

import com.twitpic.db.model.BaseModel;
import com.twitpic.db.model.Pictures;
import com.twitpic.db.model.PicturesParameter;;

/**
 * <code>PictureInfo.java</code>
 * @version 1.0, 2009-8-3
 */
public class PictureInfo  extends BaseModel{
	
	private Pictures pictures;
	
	private PicturesParameter picturesParameter;
	
	private String name;
	
	private String account;
	
	private String picture;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return the pictures
	 */
	public Pictures getPictures() {
		return pictures;
	}

	/**
	 * @param pictures the pictures to set
	 */
	public void setPictures(Pictures pictures) {
		this.pictures = pictures;
	}

	/**
	 * @return the picturesParameter
	 */
	public PicturesParameter getPicturesParameter() {
		return picturesParameter;
	}

	/**
	 * @param picturesParameter the picturesParameter to set
	 */
	public void setPicturesParameter(PicturesParameter picturesParameter) {
		this.picturesParameter = picturesParameter;
	}
	
	
}
