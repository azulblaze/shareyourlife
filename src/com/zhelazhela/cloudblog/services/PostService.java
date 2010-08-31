package com.zhelazhela.cloudblog.services;

import com.zhelazhela.cloudblog.domain.ACK;
import com.zhelazhela.cloudblog.domain.ForwardResult;
import com.zhelazhela.cloudblog.domain.PostList;
import com.zhelazhela.cloudblog.domain.PostResult;
import com.zhelazhela.cloudblog.domain.ReplyResult;

public interface PostService {

	/**
	 * 发布微薄/包含图片
	 * dopost/send
	 * POST
	 * post:要发布的内容，最好在140个中文字范围内。必须要做URLEncode
	 * pic:要发布的图片文件
	 * @param parameters
	 * @return
	 */
	public PostResult post(java.util.Map<String,String> parameters);
	
	/**
	 * 回复微薄
	 * dopost/reply
	 * POST
	 * post:要发布的内容，最好在140个中文字范围内。必须要做URLEncode
	 * reply_to_post_id：回复的微薄ID
	 * reply_to_user_id：【可选】回复的用户，post里面必须包含该 '@用户名字 才有效。 
	 * is_post:y-回复的时候同时发布微薄，n-回复的时候不发布微薄,只是回复
	 * @param parameters
	 * @return
	 */
	public ReplyResult reply(java.util.Map<String,String> parameters);
	
	/**
	 * 转发微薄
	 * dopost/forward
	 * POST
	 * post:如果is_reply为y，那么该字段不能为空。
	 * forward_to_post_id：转发的微薄ID
	 * reply_to_user_id：【可选】回复的用户，post里面必须包含该 '@用户名字 才有效。 
	 * is_reply:y-转发的时候同时回复微薄，n-转发的时候不回复微薄
	 * @param parameters
	 * @return
	 */
	public ForwardResult forward(java.util.Map<String,String> parameters);
	
	/**
	 * 删除微薄
	 * dopost/delpost
	 * GET
	 * id:要删除的微薄的唯一id
	 * @param parameters
	 * @return
	 */
	public ACK delpost(java.util.Map<String,String> parameters);
	
	/**
	 * 删除回复
	 * dopost/delreply
	 * GET
	 * id:要删除的评论的唯一id
	 * @param parameters
	 * @return
	 */
	public ACK delreply(java.util.Map<String,String> parameters);
	/**
	 * 获取单条微薄
	 * getpost/detail
	 * GET
	 * id:唯一ID
	 * @param parameters
	 * @return
	 */
	public PostList singlelist(java.util.Map<String,String> parameters);
	/**
	 * 获取最新的公共微薄
	 * getpost/public
	 * count:数量
	 * max_id:可选参数，返回小于max_id的微薄
	 * min_id:可选参数，返回大于min_id的微薄
	 * max_id和min_id同时只能有一个有效
	 * @param parameters
	 * @return
	 */
	public PostList publicpost(java.util.Map<String,String> parameters);
	
	/**
	 * 获取关注用户的微薄
	 * GET
	 * getpost/follow
	 * count:数量
	 * max_id:可选参数，返回小于max_id的微薄
	 * min_id:可选参数，返回大于min_id的微薄
	 * max_id和min_id同时只能有一个有效
	 * @param parameters
	 * @return
	 */
	public PostList followpost(java.util.Map<String,String> parameters);
	
	/**
	 * 获取制定用户的微薄
	 * GET
	 * getpost/user
	 * id:用户唯一ID
	 * count:数量
	 * max_id:可选参数，返回小于max_id的微薄
	 * min_id:可选参数，返回大于min_id的微薄
	 * max_id和min_id同时只能有一个有效
	 * @param parameters
	 * @return
	 */
	public PostList userpost(java.util.Map<String,String> parameters);
	
	
}
