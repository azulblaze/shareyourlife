package com.zhelazhela.services;

import java.util.List;

import com.zhelazhela.db.model.MerchandiseCategory;
import com.zhelazhela.db.model.ProgramInfo;
import com.zhelazhela.db.model.Province;
import com.zhelazhela.db.model.SecurityQuestion;
import com.zhelazhela.domain.DiscountNewsList;

public interface CacheService {
	
	public DiscountNewsList loadWeeklyHot() throws Exception;
	
	public DiscountNewsList loadWeeklyWelcome() throws Exception;
	
	public List<MerchandiseCategory> loadCategory() throws Exception;
	
	public List<ProgramInfo> loadProgram() throws Exception;
	
	public List<Province> loadProvinces() throws Exception;
	
	public List<SecurityQuestion> loadSecurityQuestions() throws Exception;
	
}
