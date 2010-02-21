package com.zhelazhela.services;

import com.zhelazhela.db.model.GoodsTag;

public interface GoodsTagService {

	public GoodsTag addTag(String name,long user_id) throws Exception;
	
	public GoodsTag loadTag(long id) throws Exception;
	
	public boolean checkTag(long id,long user_id) throws Exception;
	
}
