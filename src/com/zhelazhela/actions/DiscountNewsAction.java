package com.zhelazhela.actions;

import java.text.DecimalFormat;

import net.sf.json.JSONObject;

import com.zhelazhela.db.model.DiscountNews;
import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.DiscountNewsService;

@SuppressWarnings("serial")
public class DiscountNewsAction extends BaseAction {
	
	private DiscountNewsService discountNewsService;
	
	private CacheService cacheService;
	
	/** 折扣新闻对象 */
	private DiscountNews dnews;
	/** 提交的验证码  */
	private String validate_code;
	/** 当前页数 */
	private int page;
	/** 每页数量 */
	private int pagesize;
	/** 折扣类别 */
	private String category;
	/** 折扣商家 */
	private String seller;
	/** 折扣地区 */
	private String area;
	/** 排列顺序 **/
	private String order;
	/** 折扣新闻唯一ID */
	private int dn_id;
	/** 打分 */
	private int number;
	
	/**
	 * 提交新闻
	 * @return
	 * @throws Exception
	 */
	public String submit() throws Exception {
		//for right side
		setValue("weeklyhot",cacheService.loadWeeklyHot());
		setValue("weeklywelcome",cacheService.loadWeeklyWelcome());
		//for some select
		setValue("categorys",cacheService.loadCategory());
		setValue("provinces",cacheService.loadProvinces());
		setValue("programinfos",cacheService.loadProgram());
		
		if(dnews==null){
			return INPUT;
		}
		//for select
		setValue("province_id",getRequestParameter("province_id"));
		setValue("city_id",getRequestParameter("city_id"));
		
		this.setValue("dnews", dnews);
		//确保是未审批的内容
		dnews.setApproveResult(null);
		//dnews.setDiscountEndStr(dnews.getDiscountEndStr());
		//dnews.setDiscountStartStr(dnews.getDiscountStartStr());
		if(validate_code==null||!validate_code.equals((String)getSession("news_submit"))){
			this.clearSession("news_submit");
			setValue("error","您必须输入正确的验证码才能提交！");
			return INPUT;
		}
		this.clearSession("validate_code");
		if(dnews.validate()){
			try{
				if(discountNewsService.saveDiscountNews(dnews)!=null){
					return SUCCESS;
				}
				throw new Exception("未知错误");
			}catch(Exception e){
				setValue("error",e.getMessage());
			}
		}else{
			setValue("error","您必须填写完整的信息才能提交！");
		}
		return INPUT;
	}
	
	public String thankyou() throws Exception{
		//for right side
		setValue("weeklyhot",cacheService.loadWeeklyHot());
		setValue("weeklywelcome",cacheService.loadWeeklyWelcome());
		return SUCCESS;
	}
	
	/**
	 * 显示新闻列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		//for right side
		setValue("weeklyhot",cacheService.loadWeeklyHot());
		setValue("weeklywelcome",cacheService.loadWeeklyWelcome());
		
		if(page<=0){
			page = 1;
		}
		if(order==null){
			order = "approve_time desc";
		}
		DiscountNewsList dnl = discountNewsService.loadDiscountNewsList(page, pagesize, category, area, null, null,order);
		setValue("dnl",dnl);
		return SUCCESS;
	}
	/**
	 * 阅读单个新闻
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{
		//for right side
		setValue("weeklyhot",cacheService.loadWeeklyHot());
		setValue("weeklywelcome",cacheService.loadWeeklyWelcome());
		
		DiscountNews dn = discountNewsService.viewDiscountNews(dn_id);
		if(dn!=null){
			//只能阅读审批过的内容
			if(dn.getApproveResult()!=null&&dn.getApproveResult()){
				setValue("dn",dn);
			}
		}
		return SUCCESS;
	}
	
	public String support() throws Exception{
		long result = discountNewsService.supportDiscountNews(dn_id);
		JSONObject jb = new JSONObject();
		jb.put("points", result);
		setValue("json",jb.toString());
		return "json";
	}
	
	public String point_content() throws Exception{
		DiscountNews dn = discountNewsService.pointContent(dn_id, number);
		JSONObject jb = new JSONObject();
		jb.put("times", dn.getContentPointsTimes());
		jb.put("avg_points", dn.getAveCPoints());
		setValue("json",jb.toString());
		return "json";
	}
	
	public String point_publish() throws Exception{
		DiscountNews dn = discountNewsService.pointPublish(dn_id, number);
		JSONObject jb = new JSONObject();
		jb.put("times", dn.getPublishPointsTimes());
		jb.put("avg_points", dn.getAvePPoints());
		setValue("json",jb.toString());
		return "json";
	}
	
	
	public void setDiscountNewsService(DiscountNewsService discountNewsService) {
		this.discountNewsService = discountNewsService;
	}

	public DiscountNews getDnews() {
		return dnews;
	}

	public void setDnews(DiscountNews dnews) {
		this.dnews = dnews;
	}

	public String getValidate_code() {
		return validate_code;
	}

	public void setValidate_code(String validateCode) {
		validate_code = validateCode;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getDn_id() {
		return dn_id;
	}

	public void setDn_id(int dn_id) {
		this.dn_id = dn_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

}
