package com.zhelazhela.services;

import com.zhelazhela.db.model.UrlRedirection;


public interface UrlService {
	public UrlRedirection addUrl(String url,int level) throws Exception;
	
	public int loadLevel(String url) throws Exception;
	
	public boolean delUrl(long id) throws Exception;
	
	public UrlRedirection editUrl(long id,String url,int level) throws Exception;
}
