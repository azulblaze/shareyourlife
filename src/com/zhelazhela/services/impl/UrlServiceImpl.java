package com.zhelazhela.services.impl;

import org.apache.commons.httpclient.URI;
import org.apache.commons.lang.StringUtils;

import com.zhelazhela.db.dao.UrlRedirectionDAO;
import com.zhelazhela.db.model.UrlRedirection;
import com.zhelazhela.db.model.UrlRedirectionExample;
import com.zhelazhela.services.UrlService;

public class UrlServiceImpl implements UrlService {

	private UrlRedirectionDAO urlRedirectionDAO;
	
	private static URI uri;
	
	public void setUrlRedirectionDAO(UrlRedirectionDAO urlRedirectionDAO) {
		this.urlRedirectionDAO = urlRedirectionDAO;
	}

	@Override
	public UrlRedirection addUrl(String url, int level) throws Exception {
		String host = getHost(url);
		if(StringUtils.isNotBlank(host)){
			UrlRedirectionExample ure = new UrlRedirectionExample();
			ure.createCriteria().andSiteExpEqualTo(host);
			if(urlRedirectionDAO.selectByExample(ure).size()>0){
				throw new Exception("该域名已经存在");
			}else{
				UrlRedirection ur = new UrlRedirection();
				ur.setCount(0l);
				ur.setLevel(level);
				ur.setSiteExp(host);
				ur.setUpdateTime(new java.util.Date());
				urlRedirectionDAO.insert(ur);
				return ur;
			}
		}
		return null;
	}

	@Override
	public boolean delUrl(long id) throws Exception {
		int row = urlRedirectionDAO.deleteByPrimaryKey(id);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public UrlRedirection editUrl(long id,String url, int level) throws Exception {
		UrlRedirection ur = urlRedirectionDAO.selectByPrimaryKey(id);
		if(ur==null){
			throw new Exception("不存在该域名");
		}
		boolean update = false;
		if(!url.equals(ur.getSiteExp())){
			ur.setSiteExp(url);
			update = true;
		}
		if(level!=ur.getLevel()){
			ur.setLevel(level);
			update = true;
		}
		if(update){
			ur.setUpdateTime(new java.util.Date());
			urlRedirectionDAO.updateByPrimaryKey(ur);
		}
		return ur;
	}

	@Override
	public int loadLevel(String url) throws Exception {
		String host = getHost(url);
		if(StringUtils.isNotBlank(host)){
			UrlRedirectionExample ure = new UrlRedirectionExample();
			ure.createCriteria().andSiteExpEqualTo(url);
			java.util.List<UrlRedirection> urs = urlRedirectionDAO.selectByExample(ure);
			if(urs.size()==0){
				throw new Exception("不存在该域名");
			}
			return urs.get(0).getLevel();
		}
		return 0;
	}

	private synchronized static String getHost(String url) throws Exception{
		uri = new URI(url,true);
		return uri.getHost();
	}
}
