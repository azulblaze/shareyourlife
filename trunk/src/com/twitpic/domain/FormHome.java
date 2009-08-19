package com.twitpic.domain;

public class FormHome {
	
	private Integer picturesPageIndex = 0;

	private Integer tagsPageIndex = 0;

	public void setPicturesPageIndex(Integer picturesPageIndex) {
		this.picturesPageIndex = picturesPageIndex;
	}

	public Integer getPicturesPageIndex() {
		return picturesPageIndex;
	}

	public void setTagsPageIndex(Integer tagsPageIndex) {
		this.tagsPageIndex = tagsPageIndex;
	}

	public Integer getTagsPageIndex() {
		return tagsPageIndex;
	}
	
	
	

}
