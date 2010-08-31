package com.zhelazhela.cloudblog.services;

import com.zhelazhela.cloudblog.domain.ACK;
import com.zhelazhela.cloudblog.domain.Login;
import com.zhelazhela.cloudblog.domain.UserList;

public interface UserService {

	/**
	 * 登录
	 * user/login?account=id&password=pass
	 * GET
	 * @param parameters
	 * @return
	 */
	public Login login(java.util.Map<String,String> parameters);
	/**
	 * 退出
	 * user/logout?account=id
	 * Get
	 * @param parameters
	 * @return
	 */
	public ACK logout(java.util.Map<String, String> parameters);
	/**
	 * 查看指定用户关注的人
	 * user/follow?id&cursor=0&count=10
	 * id:指定用户
	 * cursor:起始位置
	 * count:数量
	 * 默认显示用户：:1,2,3.....19,20
	 * @param parameters
	 * @return
	 */
	public UserList follow(java.util.Map<String, String> parameters);
	
	/**
	 * 查看指定用户关注的人
	 * user/follow?id&cursor=0&count=10
	 * id:指定用户
	 * cursor:起始位置
	 * count:数量
	 * 默认显示用户：:1,2,3.....19,20
	 * @param parameters
	 * @return
	 */
	public UserList fans(java.util.Map<String, String> parameters);
	/**
	 * 关注用户
	 * user/track?id=id
	 * id:指定用户
	 * @param parameters
	 * @return
	 */
	public ACK track(java.util.Map<String, String> parameters);
	/**
	 * 取消关注
	 * user/cancel?id=id
	 * id:指定用户
	 * @param parameters
	 * @return
	 */
	public ACK cancel(java.util.Map<String, String> parameters);
	
}
