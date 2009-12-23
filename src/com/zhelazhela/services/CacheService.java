package com.zhelazhela.services;

import com.zhelazhela.domain.DiscountNewsList;

public interface CacheService {
	
	public DiscountNewsList loadWeeklyHot() throws Exception;
	
	public DiscountNewsList loadWeeklyWelcome() throws Exception;
	
}
