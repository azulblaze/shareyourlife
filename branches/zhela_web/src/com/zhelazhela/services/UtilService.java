package com.zhelazhela.services;

import com.zhelazhela.db.model.City;
import com.zhelazhela.db.model.Province;
import com.zhelazhela.db.model.MerchandiseCategory;

public interface UtilService {
	
	public java.util.Set<String> loadCategorys(String category) throws Exception;
	
	public java.util.Set<String> loadAreas(String area) throws Exception;
	
	public java.util.List<City> loadCitys(long province_id)throws Exception;
	
	public java.util.List<Province> loadProvinces()throws Exception;
	
	public java.util.List<MerchandiseCategory> loadCategorys(long father)throws Exception;
	
	public java.util.List<MerchandiseCategory> loadAllCategorys(int page,int pagesize) throws Exception;
	
	public MerchandiseCategory loadCategory(long id) throws Exception;
		
	public MerchandiseCategory addCategory(long father,boolean is_system,String name,String description)throws Exception;
	
}
