package com.zhelazhela.services;

import com.zhelazhela.db.model.GoodsTrack;

public interface GoodsRelationService {

	public GoodsTrack track(long goods_id,String sn,long user_id,float rate,long tag,int visibility,int track_price) throws Exception;
	
	public GoodsTrack track(long goods_id,String sn,long user_id,float rate,String tag,int visibility,int track_price) throws Exception;
	
	public GoodsTrack editTrack(long track_id,long user_id,float rate,String tag,int visibility,int track_price) throws Exception;
	
	public boolean delTrack(long track_id,long user_id) throws Exception;
}
