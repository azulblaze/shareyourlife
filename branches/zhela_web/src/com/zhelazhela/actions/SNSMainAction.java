package com.zhelazhela.actions;

import com.zhelazhela.domain.GoodsCollection;
import com.zhelazhela.domain.GoodsDetail;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.domain.SNSUserBaseinfo;
import com.zhelazhela.domain.UserGoodsList;
import com.zhelazhela.services.GoodsBasicService;
import com.zhelazhela.services.GoodsTagService;
import com.zhelazhela.services.UserProfileService;

public class SNSMainAction extends BaseAction {
	
	private static final long serialVersionUID = -6185954932555185651L;
	
	private GoodsBasicService goodsBasicService;
	
	private UserProfileService userProfileService;
	
	private GoodsTagService goodsTagService;
	
	private GoodsCollection gc;
	
	private Long goods_id;
	
	private String goods_sn;
	
	private Integer page;
	
	private Integer pagesize;
	
	private Long user_id;
	
	private Long tagid;

	public void setGoodsBasicService(GoodsBasicService goodsBasicService) {
		this.goodsBasicService = goodsBasicService;
	}

	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public void setGoodsTagService(GoodsTagService goodsTagService) {
		this.goodsTagService = goodsTagService;
	}

	public GoodsCollection getGc() {
		return gc;
	}

	public void setGc(GoodsCollection gc) {
		this.gc = gc;
	}

	public Long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Long goodsId) {
		goods_id = goodsId;
	}

	public String getGoods_sn() {
		return goods_sn;
	}

	public void setGoods_sn(String goodsSn) {
		goods_sn = goodsSn;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long userId) {
		user_id = userId;
	}

	public Long getTagid() {
		return tagid;
	}

	public void setTagid(Long tagid) {
		this.tagid = tagid;
	}

	
	
	public String main() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(tmp==null||tmp.getReg_level()<=0){
			return LOGIN;
		}
		if(page==null||page<1){
			page = 1;
		}
		if(tagid==null||tagid<=0){
			tagid = -1l;
		}
		UserGoodsList ugl = goodsBasicService.loadMyGoodsList(tmp.getId(), page, pagesize,tagid);
		setValue("ugl",ugl);
		setValue("tag",goodsTagService.loadUserTagInfo(tmp.getId()));
		setValue("list_title","我的收藏");
		setValue("userinfo",userProfileService.loadUserBaseInfo(tmp.getId(),-1));
		return SUCCESS;
	}
	
	public String collection() throws Exception{
		String source = this.getRequestParameter("source");
		if(source!=null&&source.trim().length()>0){
			setValue("url","/sns/collection.zl?source="+source);
			setValue("source",source);
			SNSUser tmp = (SNSUser)this.getSession("user");
			if(tmp==null||tmp.getReg_level()<=0){
				return LOGIN;
			}
			return SUCCESS;
		}
		throw new Exception();
	}
	
	public String addgoods() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(tmp==null||tmp.getReg_level()<=0){
			return LOGIN;
		}
		setValue("gc",gc);
		setValue("source",gc.getSource());
		if(gc!=null&&gc.isValid()){
			gc.setUser_id(tmp.getId());
			gc.setRoot_path(getRootPath());
			gc.setGoods_type(GoodsDetail.TYPE_GOODS);
			try{
				GoodsDetail gd = goodsBasicService.addSiteGoods(gc);
				if(gd!=null){
					setValue("gd",gd);
					return SUCCESS;
				}
			}catch(Exception e){
				setValue("error",e.getMessage());
			}
		}else{
			setValue("error","信息不完整");
		}
		return INPUT;
	}
	
	public String loadgoods() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(page==null||page==0){
			page = 1;
		}
		if(goods_id!=null&&goods_id>0){
			GoodsDetail gd = goodsBasicService.loadGoodsDetail(goods_id, tmp, goods_sn, page, 3);
			if(gd==null){
				return "error";
			}
			setValue("gd",gd);
			return SUCCESS;
		}
		throw new Exception();
	}
	
	public String loadUserPage() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(tmp==null){
			return LOGIN;
		}
		if(tmp.getId()==user_id){
			return "mypage";
		}
		if(user_id==null||user_id<1){
			throw new Exception();
		}
		SNSUserBaseinfo dest_user = userProfileService.loadUserBaseInfo(user_id,tmp.getId());
		if(dest_user==null){
			throw new Exception();
		}
		setValue("userinfo",dest_user);
		if(!dest_user.getUserPrivate().isValid()){
			return "hidden";
		}
		if(page==null||page<1){
			page = 1;
		}
		if(tagid==null||tagid<=0){
			tagid = -1l;
		}
		UserGoodsList ugl = goodsBasicService.loadUserGoodsList(tmp.getId(), user_id, page, pagesize,tagid);
		setValue("ugl",ugl);
		setValue("tag",goodsTagService.loadUserTagInfo(user_id));
		return SUCCESS;
	}
	
	public String loadUserWatching() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(tmp==null){
			return LOGIN;
		}
		boolean myuser = false;
		if(user_id==null||user_id<0){
			user_id = tmp.getId();
			myuser = true;
		}
		SNSUserBaseinfo dest_user = userProfileService.loadUserBaseInfo(user_id,tmp.getId());
		if(dest_user==null){
			throw new Exception();
		}
		setValue("userinfo",dest_user);
		setValue("firend",userProfileService.loadUserWatching(user_id, null));
		setValue("tag",goodsTagService.loadUserTagInfo(user_id));
		if(myuser){
			return "my";
		}
		return "dest";
	}
	
	public String loadUserWatcher() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(tmp==null){
			return LOGIN;
		}
		boolean myuser = false;
		if(user_id==null||user_id<0){
			user_id = tmp.getId();
			myuser = true;
		}
		SNSUserBaseinfo dest_user = userProfileService.loadUserBaseInfo(user_id,tmp.getId());
		if(dest_user==null){
			throw new Exception();
		}
		setValue("userinfo",dest_user);
		setValue("firend",userProfileService.loadUserWatcher(user_id, null));
		setValue("tag",goodsTagService.loadUserTagInfo(user_id));
		if(myuser){
			return "my";
		}
		return "dest";
	}
	
	
}
