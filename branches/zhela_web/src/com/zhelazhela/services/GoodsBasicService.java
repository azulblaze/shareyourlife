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

	public GoodsDetail addSiteGoods(GoodsCollection gc) throws Exception;
		
	public GoodsDetail loadGoodsDetail(long id,SNSUser user,String sn,int page,int pagesize) throws Exception;
	
	public UserTrackList loadUserTrack(long id,SNSUser user, String sn,int page,int pagesize) throws Exception;
	
	public GoodCommentList loadUserComment(long id,String sn,int page,int pagesize) throws Exception;
	
	public GoodsComment commentGoods(GoodsComment gc) throws Exception;
	
	public GoodsOfferList loadGoodsOffer(long id,String sn,int page,int pagesize) throws Exception;
	
	public UserGoodsList loadUserGoodsList(long user_id,long load_user_id,int page,int pagesize ) throws Exception;
}
