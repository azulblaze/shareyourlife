package com.zhelazhela.services;

import com.zhelazhela.domain.GoodsCollection;
import com.zhelazhela.domain.GoodsDetail;

public interface GoodsBasicService {

	public GoodsDetail addSiteGoods(GoodsCollection gc) throws Exception;
		
	public GoodsDetail loadGoodsDetail(long id,String sn) throws Exception;
}
