package com.zhelazhela.actions;

import net.sf.json.JSONObject;

import com.zhelazhela.db.model.GoodsTrack;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.domain.form.AddFriend;
import com.zhelazhela.services.GoodsBasicService;
import com.zhelazhela.services.GoodsRelationService;
import com.zhelazhela.services.UserRelationService;

@SuppressWarnings("serial")
public class SNSRelationAction extends BaseAction {

	private AddFriend addFriend;
	
	private String goodssn;
	
	private long goodsid;
	
	private long user_id;
	
	private String tag;
	
	private Float rate;
	
	private int visibility;
	
	private int track_price;
	
	private long track_id;
	
	private GoodsBasicService goodsBasicService;
	
	private GoodsRelationService goodsRelationService;
	
	private UserRelationService userRelationService;
	
	public void setGoodsBasicService(GoodsBasicService goodsBasicService) {
		this.goodsBasicService = goodsBasicService;
	}

	public void setGoodsRelationService(GoodsRelationService goodsRelationService) {
		this.goodsRelationService = goodsRelationService;
	}

	public void setUserRelationService(UserRelationService userRelationService) {
		this.userRelationService = userRelationService;
	}

	public AddFriend getAddFriend() {
		return addFriend;
	}

	public void setAddFriend(AddFriend addFriend) {
		this.addFriend = addFriend;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public int getTrack_price() {
		return track_price;
	}

	public void setTrack_price(int trackPrice) {
		track_price = trackPrice;
	}

	public long getTrack_id() {
		return track_id;
	}

	public void setTrack_id(long trackId) {
		track_id = trackId;
	}

	public String tagGoods() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		try{
			GoodsTrack gt = goodsRelationService.track(goodsid, goodssn, tmp.getId(), rate, tag, visibility, track_price);
			if(gt!=null){
				jb.put("result", "success");
				jb.put("data", gt);
				jb.put("msg", "关注成功");
				setValue("json", jb.toString());
				return JSON;
			}else{
				jb.put("msg", "非常抱歉发生了错误");
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return JSON;
	}
	
	public String editTagGoods() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		try{
			GoodsTrack gt = goodsRelationService.editTrack(track_id, tmp.getId(), rate, tag, visibility, track_price);
			if(gt!=null){
				jb.put("result", "success");
				jb.put("data", gt);
				jb.put("msg", "编辑成功");
				setValue("json", jb.toString());
				return JSON;
			}else{
				jb.put("msg", "非常抱歉发生了错误");
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return JSON;
	}
	
	public String delTagGoods() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		try{
			boolean result = goodsRelationService.delTrack(track_id, tmp.getId());
			if(result){
				jb.put("result", "success");
				setValue("json", jb.toString());
				setValue("json", jb.toString());
				return JSON;
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return JSON;
	}
	
	public String addFriend() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		try{
			addFriend.setS_user_id(tmp.getId());
			int result = userRelationService.addFriend(addFriend);
			if(result==-9){
				jb.put("result", "success");
				jb.put("msg", "关注成功");
				setValue("json", jb.toString());
				return JSON;
			}else{
				jb.put("data", result);
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return JSON;
	}
	
	public String delFriend() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		try{
			addFriend.setS_user_id(tmp.getId());
			boolean result = userRelationService.delFriend(addFriend);
			if(result){
				jb.put("result", "success");
				jb.put("msg", "取消成功");
				setValue("json", jb.toString());
				return JSON;
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return JSON;
	}
	
	public String blockUser() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		JSONObject jb = new JSONObject();
		if(tmp==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return JSON;
		}
		try{
			addFriend.setS_user_id(tmp.getId());
			boolean result = userRelationService.blockFriend(addFriend);
			if(result){
				jb.put("result", "success");
				jb.put("msg", "取消成功");
				setValue("json", jb.toString());
				return JSON;
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return JSON;
	}
}
