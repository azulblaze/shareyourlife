package com.twitpic.services.impl;

import com.twitpic.db.model.Follow;
import com.twitpic.db.model.FollowExample;
import com.twitpic.services.FollowService;

public class FollowServiceImpl implements FollowService {

	private com.twitpic.db.dao.FollowDAO followDAO;
	
	private com.twitpic.db.dao.UsersDAO usersDAO;
	
	public void setFollowDAO(com.twitpic.db.dao.FollowDAO followDAO) {
		this.followDAO = followDAO;
	}

	public void setUsersDAO(com.twitpic.db.dao.UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	@Override
	public Follow allow_follow(String account, Long id) throws Exception {
		Follow follow = followDAO.selectByPrimaryKey(id);
		if(follow==null||(!follow.getFollowed().equals(account))){
			throw new Exception("错误的请求");
		}
		if(follow.getStatus()!=Follow.STATUS_CONFIRM){
			follow.setStatus(Follow.STATUS_CONFIRM);
			follow.setUpdateTime(new java.util.Date());
			followDAO.updateByPrimaryKey(follow);
		}
		return follow;
	}

	@Override
	public Follow apply_follow(String srcAccount, String destAccount, Follow.FollowFunction function) throws Exception {
		com.twitpic.db.model.Users user = usersDAO.selectByPrimaryKey(destAccount);
		if(user==null){
			throw new Exception("错误的请求");
		}
		FollowExample example = new FollowExample();
		example.createCriteria().andFollowEqualTo(srcAccount).andFollowedEqualTo(destAccount).andFunctionEqualTo(function.toString());
		java.util.List<Follow> follows = followDAO.selectByExample(example);
		if(follows.size()>0){
			throw new Exception("错误得请求");
		}
		Follow follow = new Follow();
		follow.setFollow(srcAccount);
		follow.setFollowed(destAccount);
		follow.setFunction(function.toString());
		follow.setStatus(Follow.STATUS_CONFIRM);
		follow.setUpdateTime(new java.util.Date());
		follow.setId(followDAO.insert_return_id(follow));
		return follow;
	}

	@Override
	public Follow reject_follow(String account, Long id) throws Exception {
		Follow follow = followDAO.selectByPrimaryKey(id);
		if(follow==null||(!follow.getFollowed().equals(account))){
			throw new Exception("错误的请求");
		}
		if(follow.getStatus()!=Follow.STATUS_REJECT){
			follow.setStatus(Follow.STATUS_REJECT);
			follow.setUpdateTime(new java.util.Date());
			followDAO.updateByPrimaryKey(follow);
		}
		return follow;
	}

}
