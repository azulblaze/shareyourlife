package com.zhelazhela.actions;


import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.feed.synd.SyndImage;
import com.sun.syndication.feed.synd.SyndImageImpl;
import com.sun.syndication.io.SyndFeedOutput;
import com.zhelazhela.db.model.DiscountNews;
import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.DiscountNewsService;
import com.zhelazhela.system.config.SystemConfig;

@SuppressWarnings("serial")
public class DiscountNewsAction extends BaseAction {
	
	private DiscountNewsService discountNewsService;
	
	private CacheService cacheService;
	
	private SystemConfig systemConfig;
	
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
	
	private boolean and = false;
	
	private static final String MIME_TYPE = "application/xml; charset=UTF-8";   
    
    // rss_0.90, rss_0.91, rss_0.92, rss_0.93, rss_0.94, rss_1.0, rss_2.0, atom_0.3    
    private static final String RSS_TYPE = "rss_2.0"; 
	
	/**
	 * 提交新闻
	 * @return
	 * @throws Exception
	 */
	public String submit() throws Exception {
		//for right side
		setValue("nav","news_submit");
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
		this.clearSession("news_submit");
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
		setValue("nav","news_submit");
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
		setValue("nav","index");
		setValue("weeklyhot",cacheService.loadWeeklyHot());
		setValue("weeklywelcome",cacheService.loadWeeklyWelcome());
		
		if(page<=0){
			page = 1;
		}
		if(StringUtils.isBlank(order)){
			order = "approve_time desc";
		}
		DiscountNewsList dnl = discountNewsService.loadDiscountNewsList(page, pagesize, category, area, null, null,order,and);
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
		}else{
			throw new Exception();
		}
		return SUCCESS;
	}
	
	public String rss() throws Exception{
		SyndFeed feed = new SyndFeedImpl();
		feed.setAuthor("这啦折啦");
		feed.setTitle("这啦折啦");
		feed.setLink(systemConfig.getDomain());
		feed.setDescription("这啦折啦是一个分享购物打折信息的地方,为您的购物带来实惠.");
		SyndImage image = new SyndImageImpl();
		image.setTitle("这啦折啦");
		image.setLink(systemConfig.getDomain());
		image.setUrl(systemConfig.getDomain()+"/zhelazhela.png");
		feed.setImage(image);
		if(StringUtils.isBlank(order)){
			order = "approve_time desc";
		}
		DiscountNewsList dnl = discountNewsService.loadDiscountNewsList(1, 30, category, area, null, null,order,and);
		java.util.List<SyndEntry> entrys = new java.util.ArrayList<SyndEntry>();
		SyndEntry se = null;
		SyndContent description = null;
		for(DiscountNews dn:dnl.getList()){
			se = new SyndEntryImpl();   
			se.setTitle(dn.getNewsTitle());   
			se.setLink(systemConfig.getDomain()+"/detail.zl?dn_id="+dn.getId());   
			se.setPublishedDate(dn.getApproveTime());   
			description = new SyndContentImpl();   
			description.setType("text/html");   
			description.setValue(dn.getNewsReview());   
			se.setDescription(description);   
			entrys.add(se);
		}
		if(dnl.getList().size()>0){
			feed.setPublishedDate(dnl.getList().get(0).getApproveTime());
		}else{
			feed.setPublishedDate(new java.util.Date());
		}
		
		feed.setEntries(entrys);
		feed.setFeedType(RSS_TYPE);
		HttpServletResponse response = getHttpServletResponse();
		response.setContentType(MIME_TYPE);
		try{
			SyndFeedOutput output = new SyndFeedOutput();
			output.output(feed, response.getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
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
	
	public String read() throws Exception{
		discountNewsService.readDiscountNews(dn_id);
		return null;
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

	public boolean isAnd() {
		return and;
	}

	public void setAnd(boolean and) {
		this.and = and;
	}

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

}
