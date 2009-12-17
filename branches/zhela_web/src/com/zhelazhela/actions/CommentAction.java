package com.zhelazhela.actions;

@SuppressWarnings("serial")
public class CommentAction extends BaseAction {
	
	public String load_comment() throws Exception{
		
		this.setValue("id_picture", "");
		return SUCCESS;
	}
}
