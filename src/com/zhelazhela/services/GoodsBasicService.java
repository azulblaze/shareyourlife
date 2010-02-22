package com.zhelazhela.services;

import com.zhelazhela.domain.GoodCommentList;
import com.zhelazhela.domain.GoodsCollection;
import com.zhelazhela.domain.GoodsDetail;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.domain.UserTrackList;

public interface GoodsBasicService {

	public GoodsDetail addSiteGoods(GoodsCollection gc) throws Exception;
		
	public GoodsDetail loadGoodsDetail(long id,SNSUser user,String sn,int page,int pagesize) throws Exception;
	
	public UserTrackList loadUserTrack(long id,SNSUser user, String sn,int page,int pagesize) throws Exception;
	
	public GoodCommentList loadUserComment(long id,String sn,int page,int pagesize) throws Exception;
}
