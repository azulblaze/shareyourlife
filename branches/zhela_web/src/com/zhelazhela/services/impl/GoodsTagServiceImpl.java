package com.zhelazhela.services.impl;

import com.zhelazhela.db.dao.GoodsTagDAO;
import com.zhelazhela.db.dao.GoodsUserTagDAO;
import com.zhelazhela.db.model.GoodsTag;
import com.zhelazhela.db.model.GoodsTagExample;
import com.zhelazhela.db.model.GoodsUserTag;
import com.zhelazhela.db.model.GoodsUserTagExample;
import com.zhelazhela.services.GoodsTagService;

public class GoodsTagServiceImpl implements GoodsTagService {

	private GoodsTagDAO goodsTagDAO;
	
	private GoodsUserTagDAO goodsUserTagDAO;
	
	public void setGoodsTagDAO(GoodsTagDAO goodsTagDAO) {
		this.goodsTagDAO = goodsTagDAO;
	}

	public void setGoodsUserTagDAO(GoodsUserTagDAO goodsUserTagDAO) {
		this.goodsUserTagDAO = goodsUserTagDAO;
	}


	@Override
	public GoodsTag addTag(String name, long userId) throws Exception{
		GoodsTag gt;
		GoodsTagExample example = new GoodsTagExample();
		example.createCriteria().andNameEqualTo(name);
		java.util.List<GoodsTag> list = goodsTagDAO.selectByExample(example);
		if(list.size()>0){
			gt = list.get(0);
			GoodsUserTagExample gutex = new GoodsUserTagExample();
			gutex.createCriteria().andGoodsTagIdEqualTo(gt.getId()).andUserIdEqualTo(userId);
			java.util.List<GoodsUserTag> tmp = goodsUserTagDAO.selectByExample(gutex);
			if(tmp.size()<=0){
				insertGoodsUserTag(gt.getId(),userId);
			}
			return gt;
		}else{
			gt = new GoodsTag();
			gt.setName(name);
			gt.setUpdateTime(new java.util.Date());
			goodsTagDAO.insertSelective(gt);
			insertGoodsUserTag(gt.getId(),userId);
			return gt;
		}
	}
	
	@Override
	public GoodsTag loadTag(long id) {
		return null;
	}

	@Override
	public boolean checkTag(long id,long user_id) throws Exception {
		GoodsUserTagExample gutex = new GoodsUserTagExample();
		gutex.createCriteria().andGoodsTagIdEqualTo(id).andUserIdEqualTo(user_id);
		java.util.List<GoodsUserTag> tmp = goodsUserTagDAO.selectByExample(gutex);
		if(tmp.size()>0){
			return true;
		}
		return false;
	}
	

	private void insertGoodsUserTag(long tag_id,long user_id) throws Exception{
		GoodsUserTag gut = new GoodsUserTag();
		gut.setGoodsTagId(tag_id);
		gut.setUserId(user_id);
		gut.setUpdateTime(new java.util.Date());
		goodsUserTagDAO.insertSelective(gut);
	}


}
