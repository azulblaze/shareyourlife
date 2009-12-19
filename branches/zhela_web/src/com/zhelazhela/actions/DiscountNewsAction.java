package com.zhelazhela.actions;

import com.zhelazhela.db.model.DiscountNews;
import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.DiscountNewsService;

@SuppressWarnings("serial")
public class DiscountNewsAction extends BaseAction {
	
	private DiscountNewsService discountNewsService;

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
	/** 折扣新闻唯一ID */
	private int dn_id;
	/** 打分 */
	private int points;
	
	/**
	 * 提交新闻
	 * @return
	 * @throws Exception
	 */
	public String submit() throws Exception {
		if(dnews==null){
			return INPUT;
		}
		this.setValue("dnews", dnews);
		if(validate_code==null||!validate_code.equals((String)getSession("validate_code"))){
			this.clearSession("validate_code");
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
		return SUCCESS;
	}
	
	/**
	 * 显示新闻列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		if(page<=0){
			page = 1;
		}
		java.util.Map<String,String> parameters = new java.util.HashMap<String,String>();
		parameters.put("seller", seller);
		parameters.put("category", category);
		parameters.put("area", area);
		DiscountNewsList dnl = discountNewsService.loadDiscountNewsList(page, pagesize, parameters);
		setValue("dnl",dnl);
		return SUCCESS;
	}
	/**
	 * 阅读单个新闻
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{
		DiscountNews dn = discountNewsService.viewDiscountNews(dn_id);
		if(dn!=null){
			//只能阅读审批过的内容
			if(dn.getApproveResult()){
				setValue("dn",dn);
			}
		}
		return SUCCESS;
	}
	
	public String support() throws Exception{
		long result = discountNewsService.supportDiscountNews(dn_id);
		setValue("result",result);
		return SUCCESS;
	}
	
	public String point_content() throws Exception{
		DiscountNews dn = discountNewsService.pointContent(dn_id, points);
		setValue("result",dn);
		return SUCCESS;
	}
	
	public String point_publish() throws Exception{
		DiscountNews dn = discountNewsService.pointPublish(dn_id, points);
		setValue("result",dn);
		return SUCCESS;
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
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

}
