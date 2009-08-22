package com.twitpic.domain;

public class FormHome {
	
	private Integer picturesPageIndex = 0;

	private Integer tagsPageIndex = 0;

	public void setPicturesPageIndex(Integer _picturesPageIndex) {
		if( _picturesPageIndex < 0 ){
			_picturesPageIndex = 0;
		}
		this.picturesPageIndex = _picturesPageIndex;
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
