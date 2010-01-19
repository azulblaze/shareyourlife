package com.zhelazhela.actions;

import java.io.File;

import net.sf.json.JSONObject;

import com.zhelazhela.db.model.DiscountNews;
import com.zhelazhela.db.model.ManageUser;
import com.zhelazhela.db.model.ProgramInfo;
import com.zhelazhela.db.model.Attachments;
import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.AccountService;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.UtilService;
import com.zhelazhela.services.DiscountNewsService;
import com.zhelazhela.util.CommonMethod;
@SuppressWarnings("serial")
public class ManageDiscountNewsAction extends BaseAction {
	
	private static final int DEL = -1;
	
	private static final int PASS = 1;
	
	private static final int REJECT = 0;
	
	private DiscountNewsService discountNewsService;
	
	private AccountService accountService;
	
	private UtilService utilService;
	
	private CacheService cacheService;
	
	private boolean edit;

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
	private long dn_id;
	/** 审批操作ID */
	private int approve_action;
	/** 管理员对象 */
	private ManageUser muser;
	
	private String nav;
	
	private static java.util.List<String> navs = new java.util.ArrayList<String>();
	
	private String list_type;
	
	private File pic;
	
	private String picContentType;
	
	static{
		navs.add("add_program");
		navs.add("add_category");
	}
	
	public String static_page() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		if(navs.contains(nav)){
			if(nav.equals("add_category")){
				setValue("categorys",utilService.loadCategorys(0));
			}
			return nav;
		}
		return SUCCESS;
	}
	
	/** 审批新闻,删除 **/
	public String approve() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			setValue("json", jb.toString());
			return "json";
		}
		boolean result = false;
		switch(approve_action){
		case DEL:
			result = discountNewsService.delDiscountNews(dn_id);
			break;
		case REJECT:
			result = discountNewsService.approveDiscountNews(dn_id, mu.getAccount(),false);
			break;
		case PASS:
			result = discountNewsService.approveDiscountNews(dn_id, mu.getAccount(),true);
			break;
		default:
			break;
		}
		if(result){
			jb.put("result", "success");
		}else{
			jb.put("result", "fail");
		}
		setValue("json", jb.toString());
		return "json";
	}
	
	/** 管理员登录 */
	public String login() throws Exception{
		clearSession("manager");
		if(muser==null||muser.getAccount()==null){
			return INPUT;
		}else{
			if(accountService.validateManager(muser)){
				saveSession("manager",muser);
				return SUCCESS;
			}
		}
		setValue("error","请输入正确的帐号信息！");
		return INPUT;
	}
	/** 编辑新闻 */
	public String edit() throws Exception{
		
		//for right side
		setValue("weeklyhot",cacheService.loadWeeklyHot());
		setValue("weeklywelcome",cacheService.loadWeeklyWelcome());
		//for some select
		setValue("categorys",cacheService.loadCategory());
		setValue("provinces",cacheService.loadProvinces());
		setValue("programinfos",cacheService.loadProgram());
		
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		DiscountNews tmp = discountNewsService.viewDiscountNews(dnews.getId());
		if(tmp==null){
			throw new Exception();
		}
		if(edit){
			long[] location = utilService.getLocation(tmp.getDiscountArea());
			setValue("province_id",location[0]);
			setValue("city_id",location[1]);
			setValue("dnews",tmp);
			return INPUT;
		}
		DiscountNews dn = discountNewsService.editDiscountNews(dnews.getId(), dnews.getpId(), dnews.getDiscountCategory(), dnews.getDiscountArea(), dnews.getDiscountStart(), dnews.getDiscountEnd(), dnews.getNewsSource(), dnews.getNewsTitle(), dnews.getNewsReview(), dnews.getNewsContent());
		if(dn==null){
			return INPUT;
		}
		this.dn_id = dnews.getId();
		return SUCCESS;
	}
	/** 浏览新闻 */
	public String view() throws Exception{
		
		//for right side
		setValue("weeklyhot",cacheService.loadWeeklyHot());
		setValue("weeklywelcome",cacheService.loadWeeklyWelcome());
		//for some select
		setValue("categorys",cacheService.loadCategory());
		setValue("provinces",cacheService.loadProvinces());
		setValue("programinfos",cacheService.loadProgram());
		
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		DiscountNews dn = discountNewsService.viewDiscountNews(dn_id);
		setValue("dn",dn);
		return SUCCESS;
	}
	/** 新闻列表 */
	public String list() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		if(page<=0){
			page = 1;
		}
		if(order==null){
			order = "sender_time desc";
		}
		DiscountNewsList dnl = null;
		//查看已经发布的信息
		if(list_type!=null&&list_type.equals("ped")){
			dnl = discountNewsService.loadDiscountNewsList(page, pagesize, category, area, null, null,order,false);
			setValue("result",dnl);
			return SUCCESS;
		}
		dnl = discountNewsService.loadUnReleaseDiscountNewsList(page, pagesize, null, category, area, null, order);
		setValue("result",dnl);
		return SUCCESS;
	}
	
	public String uploadPic() throws Exception{
		ManageUser mu = (ManageUser)getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			setValue("json", jb.toString());
			return "json";
		}
		try{
			String ext_type = CommonMethod.getInstance().isAllowedPicture(picContentType);
			if(picContentType!=null){
				if(ext_type==null){
					jb.put("result", "fail");
					jb.put("msg", "图片不支持您上传的格式");
					setValue("json",jb.toString());
					return "json";
				}
			}
			Attachments am = new Attachments();
			if(dn_id>0){
				am.setRelTable("discount_news");
				am.setRelTableId(dn_id);
				Attachments tmp = discountNewsService.uploadPic(am, getRootPath(), ext_type, pic);
				if(tmp!=null){
					jb.put("result", "success");
					jb.put("pic", tmp);
					jb.put("msg", "上传图片成功");
					setValue("json",jb.toString());
					return "json";
				}
			}
		}catch(Exception e){
			jb.put("msg", "提交失败:"+e.getMessage());
			return null;
		}
		jb.put("result", "fail");
		setValue("json",jb.toString());
		return "json";
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
	public long getDn_id() {
		return dn_id;
	}
	public void setDn_id(long dnId) {
		dn_id = dnId;
	}
	public void setDiscountNewsService(DiscountNewsService discountNewsService) {
		this.discountNewsService = discountNewsService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public ManageUser getMuser() {
		return muser;
	}
	public void setMuser(ManageUser muser) {
		this.muser = muser;
	}
	public int getApprove_action() {
		return approve_action;
	}
	public void setApprove_action(int approveAction) {
		approve_action = approveAction;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}

	public String getNav() {
		return nav;
	}

	public void setNav(String nav) {
		this.nav = nav;
	}

	public void setUtilService(UtilService utilService) {
		this.utilService = utilService;
	}

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getList_type() {
		return list_type;
	}

	public void setList_type(String listType) {
		list_type = listType;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
	
}
