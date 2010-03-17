package com.zhelazhela.actions;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.zhelazhela.db.model.GoodsComment;
import com.zhelazhela.db.model.define.UserComment;
import com.zhelazhela.domain.GoodCommentList;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.services.GoodsBasicService;

@SuppressWarnings("serial")
public class SNSCommentAction extends BaseAction {
	
	private GoodsBasicService goodsBasicService;
	
	private String goodssn;
	
	private long goodsid;
	
	private long user_id;
	
	private int page;
	
	private int pagesize;
	
	private GoodsComment goodcomment;

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

	
	public GoodsComment getGoodcomment() {
		return goodcomment;
	}

	public void setGoodcomment(GoodsComment goodcomment) {
		this.goodcomment = goodcomment;
	}

	/**
	 * 评论物品
	 * @return
	 * @throws Exception
	 */
	public String comment() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		if(tmp.getReg_level()<=0){
			return "act";
		}
		if(goodcomment==null||!goodcomment.isValid()){
			jb.put("result", "fail");
			jb.put("msg", "信息不完整");
			this.setValue("json", jb.toString());
			return JSON;
		}
		if(goodcomment.getRepliedId()==null){
			goodcomment.setRepliedId(0l);
		}
		if(StringUtils.isBlank(goodcomment.getSn())){
			goodcomment.setSn(null);
		}
		goodcomment.setUserId(tmp.getId());
		UserComment uc = goodsBasicService.commentGoods(goodcomment);
		jb.put("result", "success");
		jb.put("data", uc);
		this.setValue("json", jb.toString());
		return JSON;
	}
	/**
	 * 获取评论列表
	 * @return
	 * @throws Exception
	 */
	public String load_comment() throws Exception{
		JSONObject jb = new JSONObject();
		if(goodsid>0||StringUtils.isNotBlank(goodssn)){
			GoodCommentList gcl = goodsBasicService.loadUserComment(goodsid, goodssn, page, pagesize);
			jb.put("result", "success");
			jb.put("data", gcl);
			this.setValue("json", jb.toString());
			return JSON;
		}
		jb.put("result", "fail");
		jb.put("msg", "获取评论失败");
		this.setValue("json", jb.toString());
		return JSON;
	}
}
