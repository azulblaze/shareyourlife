package com.zhelazhela.actions;

import net.sf.json.JSONObject;

import com.zhelazhela.db.model.DiscountNews;
import com.zhelazhela.db.model.ManageUser;
import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.AccountService;
import com.zhelazhela.services.UtilService;
import com.zhelazhela.services.DiscountNewsService;
@SuppressWarnings("serial")
public class ManageDiscountNewsAction extends BaseAction {
	
	private static final int DEL = -1;
	
	private static final int PASS = 1;
	
	private static final int REJECT = 0;
	
	private DiscountNewsService discountNewsService;
	
	private AccountService accountService;
	
	private UtilService utilService;

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
	/** 审批操作ID */
	private int approve_action;
	/** 管理员对象 */
	private ManageUser muser;
	
	private String nav;
	
	private static java.util.List<String> navs = new java.util.ArrayList<String>();
	
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
	
	public String delDiscountNews() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			setValue("json", jb.toString());
			return "json";
		}
		if(discountNewsService.delDiscountNews(dn_id)){
			jb.put("result", "success");
		}else{
			jb.put("result", "fail");
		}
		setValue("json", jb.toString());
		return "json";
	}
	
	/** 审批新闻 **/
	public String approve() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return "fail";
		}
		switch(approve_action){
		case DEL:
			discountNewsService.delDiscountNews(dn_id);
			break;
		case REJECT:
			discountNewsService.approveDiscountNews(dn_id, mu.getAccount(),false);
			break;
		case PASS:
			discountNewsService.approveDiscountNews(dn_id, mu.getAccount(),true);
			break;
		default:
			break;
		}
		return SUCCESS;
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
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return "fail";
		}
		String saveandview = (String)this.getSession("saveandview");
		setValue("dn",discountNewsService.editDiscountNews(dnews.getId(), dnews.getpId(), dnews.getDiscountCategory(), dnews.getDiscountArea(), dnews.getDiscountStart(), dnews.getDiscountEnd(), dnews.getNewsSource(), dnews.getNewsTitle(), dnews.getNewsReview(), dnews.getNewsContent()));
		if(saveandview!=null&&saveandview.equals("saveandview")){
			//保存并且预览
			return "view";
		}
		return SUCCESS;
	}
	/** 浏览新闻 */
	public String view() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return "fail";
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
		DiscountNewsList dnl = discountNewsService.loadUnReleaseDiscountNewsList(page, pagesize, null, category, area, null, order);
		setValue("result",dnl);
		return SUCCESS;
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
	public void setDn_id(int dnId) {
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
	
}
