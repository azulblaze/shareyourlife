package com.zhelazhela.services.impl;

import com.zhelazhela.db.dao.GoodsTrackDAO;
import com.zhelazhela.db.model.GoodsTrack;
import com.zhelazhela.db.model.GoodsTrackExample;
import com.zhelazhela.services.GoodsRelationService;
import com.zhelazhela.services.GoodsTagService;

public class GoodsRelationServiceImpl implements GoodsRelationService {
	
	private GoodsTrackDAO goodsTrackDAO;
	
	private GoodsTagService goodsTagService;

	public void setGoodsTrackDAO(GoodsTrackDAO goodsTrackDAO) {
		this.goodsTrackDAO = goodsTrackDAO;
	}

	public void setGoodsTagService(GoodsTagService goodsTagService) {
		this.goodsTagService = goodsTagService;
	}

	@Override
	public GoodsTrack track(long goodsId, String sn, long userId, float rate,
			long tag, int visibility ,int track_price) throws Exception {
		long tagId = 0;
		if(goodsTagService.checkTag(tag, userId)){
			tagId = tag;
		}
		GoodsTrack gt = new GoodsTrack();
		gt.setGoodsId(goodsId);
		gt.setGoodsTagId(tagId);
		gt.setRatting(rate);
		gt.setSn(sn);
		if(track_price>0){
			gt.setTrackprice(true);
		}else{
			gt.setTrackprice(false);
		}
		gt.setUpdateTime(new java.util.Date());
		gt.setUserId(userId);
		gt.setVisibility(visibility);
		goodsTrackDAO.insertSelective(gt);
		return gt;
	}

	@Override
	public GoodsTrack track(long goodsId, String sn, long userId, float rate,
			String tag, int visibility ,int track_price) throws Exception {
		long tagId = 0;
		if(tag!=null&&tag.trim().length()>0){
			tagId = goodsTagService.addTag(tag, userId).getId();
		}
		GoodsTrack gt = new GoodsTrack();
		gt.setGoodsId(goodsId);
		gt.setGoodsTagId(tagId);
		gt.setRatting(rate);
		gt.setSn(sn);
		if(track_price>0){
			gt.setTrackprice(true);
		}else{
			gt.setTrackprice(false);
		}
		gt.setUpdateTime(new java.util.Date());
		gt.setUserId(userId);
		gt.setVisibility(visibility);
		goodsTrackDAO.insertSelective(gt);
		return gt;
	}

	@Override
	public GoodsTrack editTrack(long trackId, long userId, float rate,
			String tag, int visibility, int trackPrice) throws Exception {
		GoodsTrack gt = goodsTrackDAO.selectByPrimaryKey(trackId);
		if(gt==null||!gt.getUserId().equals(userId)){
			throw new Exception("您未关注过该商品");
		}
		long tagId = 0;
		if(tag!=null&&tag.trim().length()>0){
			tagId = goodsTagService.addTag(tag, userId).getId();
		}
		gt.setGoodsTagId(tagId);
		gt.setRatting(rate);
		if(trackPrice>0){
			gt.setTrackprice(true);
		}else{
			gt.setTrackprice(false);
		}
		gt.setUpdateTime(new java.util.Date());
		gt.setUserId(userId);
		gt.setVisibility(visibility);
		goodsTrackDAO.updateByPrimaryKey(gt);
		return gt;
	}

	@Override
	public boolean delTrack(long trackId, long userId) throws Exception {
		GoodsTrackExample example = new GoodsTrackExample();
		example.createCriteria().andIdEqualTo(trackId).andUserIdEqualTo(userId);
		int row = goodsTrackDAO.deleteByExample(example);
		if(row>0){
			return true;
		}
		return false;
	}


}
