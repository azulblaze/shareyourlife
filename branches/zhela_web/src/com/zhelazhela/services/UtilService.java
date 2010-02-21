package com.zhelazhela.services;

import com.zhelazhela.db.model.City;
import com.zhelazhela.db.model.Attachments;
import com.zhelazhela.db.model.Province;
import com.zhelazhela.db.model.MerchandiseCategory;
import com.zhelazhela.domain.CategoryList;

public interface UtilService {
	
	public java.util.Set<String> loadCategorys(String category) throws Exception;
	
	public java.util.Set<String> loadFatherCategorys(String category) throws Exception;
	
	public java.util.Set<String> loadAreas(String area) throws Exception;
	
	public java.util.Set<String> loadFatherAreas(String area) throws Exception;
	
	public java.util.List<City> loadCitys(long province_id)throws Exception;
	
	public java.util.List<Province> loadProvinces()throws Exception;
	
	public java.util.List<MerchandiseCategory> loadCategorys(long father)throws Exception;
	
	public CategoryList loadAllCategorys(int page,int pagesize) throws Exception;
	
	public MerchandiseCategory loadCategory(long id) throws Exception;
		
	public MerchandiseCategory addCategory(long father,boolean is_system,String name,String description)throws Exception;
	
	public boolean delCategory(long id) throws Exception;
	
	public long[] getLocation(String location) throws Exception;
	
	public java.util.List<Attachments> loadAttachments(long news_id,String tablename);
	
	public boolean removeAttachment(long id,String rootpath);
	
	public String loadUrl(String addr);
}
