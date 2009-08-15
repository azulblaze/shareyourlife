package com.twitpic.domain;
/**
 * <code>FormTag.java</code>
 * @version 1.0, 2009-8-5
 */
public class FormTag {
	
	private Long id_pictures;
	
	private String name;
	
	private Long selected_tag_id;
	
	public void setSelectedTagId(Long _id){
		this.selected_tag_id = _id;
	}
	
	public Long getSelectedTagId(){
		return this.selected_tag_id;
	}
	
	

	/**
	 * @return the id_pictures
	 */
	public Long getId_pictures() {
		return id_pictures;
	}

	/**
	 * @param id_pictures the id_pictures to set
	 */
	public void setId_pictures(Long id_pictures) {
		this.id_pictures = id_pictures;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
