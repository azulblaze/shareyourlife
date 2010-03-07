package com.zhelazhela.services;

import com.zhelazhela.db.model.GroupDiscussion;
import com.zhelazhela.db.model.GroupDiscussionPost;

public interface GroupDiscussionService {

	public GroupDiscussion createDiscussion(GroupDiscussion gd) throws Exception;
	
	public boolean delDiscussion(long id) throws Exception;
	
	public GroupDiscussion editDiscussion(GroupDiscussion gd) throws Exception;
	
	public GroupDiscussionPost postDiscussion(GroupDiscussionPost gdp) throws Exception;
	
	public GroupDiscussionPost editPost(GroupDiscussionPost gdp, long myid) throws Exception;
	
	public boolean delPost(long id,long groupid,long user_id) throws Exception;
	
}
