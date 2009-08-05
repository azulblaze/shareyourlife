package com.twitpic.domain;
/**
 * <code>FormComment.java</code>
 * @version 1.0, 2009-8-5
 */
public class FormComment {
	
	private Long id_pictures;
	
	private String comment;

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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
