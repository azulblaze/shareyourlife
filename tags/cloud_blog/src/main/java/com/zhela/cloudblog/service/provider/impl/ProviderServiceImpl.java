package com.zhela.cloudblog.service.provider.impl;

import java.util.List;

import com.zhela.cloudblog.dao.provider.ProvidersDAO;
import com.zhela.cloudblog.model.provider.Providers;
import com.zhela.cloudblog.model.provider.ProvidersExample;
import com.zhela.cloudblog.service.provider.ProviderService;

public class ProviderServiceImpl implements ProviderService{

	private static List<Providers> ALL_PROVIDERS;
	private static long LAST_UPDATE = System.currentTimeMillis();
	
	@Override
	public List<Providers> selectAllProviders() throws Exception {
		if(ALL_PROVIDERS==null||(System.currentTimeMillis()-LAST_UPDATE)>=60000){
			ALL_PROVIDERS = providersDAO.selectByExample(new ProvidersExample());
			LAST_UPDATE = System.currentTimeMillis();
		}
		return ALL_PROVIDERS;
	}
	@Override
	public Providers selectProviderByID(long id) throws Exception {
		List<Providers> _providers = selectAllProviders();
		Providers _provider = new Providers();
		_provider.setId(id);
		for(Providers _tmp:_providers){
			if(_tmp.equals(_provider)){
				return _tmp;
			}
		}
		return null;
	}
	
	private ProvidersDAO providersDAO;
	public void setProvidersDAO(ProvidersDAO providersDAO) {
		this.providersDAO = providersDAO;
	}

	
	
}
