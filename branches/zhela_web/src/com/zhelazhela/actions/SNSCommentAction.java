package com.zhelazhela.actions;

import com.zhelazhela.services.GoodsBasicService;

@SuppressWarnings("serial")
public class SNSCommentAction extends BaseAction {
	
	private GoodsBasicService goodsBasicService;
	
	private String goodssn;
	
	private long goodsid;
	
	private long user_id;
	
	private int page;
	
	private int pagesize;

	public void setGoodsBasicService(GoodsBasicService goodsBasicService) {
		this.goodsBasicService = goodsBasicService;
	}

	public String getGoodssn() {
		return goodssn;
	}

	public void setGoodssn(String goodssn) {
		this.goodssn = goodssn;
	}

	public long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(long goodsid) {
		this.goodsid = goodsid;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long userId) {
		user_id = userId;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	
	/**
	 * 评论物品
	 * @return
	 * @throws Exception
	 */
	public String comment() throws Exception{
		return JSON;
	}
	/**
	 * 获取评论列表
	 * @return
	 * @throws Exception
	 */
	public String load_comment() throws Exception{
		return JSON;
	}
}
