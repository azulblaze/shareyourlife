package com.zhelazhela.services;

import com.zhelazhela.db.model.GoodsComment;
import com.zhelazhela.domain.GoodCommentList;
import com.zhelazhela.domain.GoodsCollection;
import com.zhelazhela.domain.GoodsDetail;
import com.zhelazhela.domain.GoodsOfferList;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.domain.UserGoodsList;
import com.zhelazhela.domain.UserTrackList;

public interface GoodsBasicService {

	/**
	 * 收集商品到网站上保存
	 * @param gc
	 * @return
	 * @throws Exception
	 */
	public GoodsDetail addSiteGoods(GoodsCollection gc) throws Exception;
	/**
	 * 返回商品详细信息
	 * @param id
	 * @param user
	 * @param sn
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public GoodsDetail loadGoodsDetail(long id,SNSUser user,String sn,int page,int pagesize) throws Exception;
	/**
	 * 返回关注指定商品的用户
	 * @param id
	 * @param user
	 * @param sn
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public UserTrackList loadUserTrack(long id,SNSUser user, String sn,int page,int pagesize) throws Exception;
	/**
	 * 返回指定商品的评论
	 * @param id
	 * @param sn
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public GoodCommentList loadUserComment(long id,String sn,int page,int pagesize) throws Exception;
	/**
	 * 对指定商品进行评论
	 * @param gc
	 * @return
	 * @throws Exception
	 */
	public GoodsComment commentGoods(GoodsComment gc) throws Exception;
	/**
	 * 返回指定商品的销售提供信息
	 * @param id
	 * @param sn
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public GoodsOfferList loadGoodsOffer(long id,String sn,int page,int pagesize) throws Exception;
	/**
	 * 返回指定用户关注商品列表
	 * @param user_id
	 * @param load_user_id
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public UserGoodsList loadUserGoodsList(long user_id,long load_user_id,int page,int pagesize ) throws Exception;
	/**
	 * 返回我关注的商品列表
	 * @param userId
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public UserGoodsList loadMyGoodsList(long userId,int page, int pagesize) throws Exception;
	/**
	 * 返回最近我关注用户所关注产品的列表
	 * @param userId
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public UserGoodsList loadMyLatestList(long userId,int page, int pagesize) throws Exception;
}
