package com.zhelazhela.actions;

import com.zhelazhela.domain.GoodsCollection;
import com.zhelazhela.domain.GoodsDetail;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.services.GoodsBasicService;

public class SNSMainAction extends BaseAction {
	
	private static final long serialVersionUID = -6185954932555185651L;
	
	private GoodsBasicService goodsBasicService;
	
	private GoodsCollection gc;

	public void setGoodsBasicService(GoodsBasicService goodsBasicService) {
		this.goodsBasicService = goodsBasicService;
	}

	public GoodsCollection getGc() {
		return gc;
	}

	public void setGc(GoodsCollection gc) {
		this.gc = gc;
	}

	public String main() throws Exception{
		SNSUser tmp = (SNSUser)this.getSession("user");
		if(tmp==null||tmp.getReg_level()<=0){
			return LOGIN;
		}
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
}
