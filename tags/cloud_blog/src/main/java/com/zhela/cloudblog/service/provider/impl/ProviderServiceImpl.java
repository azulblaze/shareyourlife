package com.zhela.cloudblog.service.provider.impl;

import java.util.List;

import com.zhela.cloudblog.dao.provider.ProvidersDAO;
import com.zhela.cloudblog.model.provider.Providers;
import com.zhela.cloudblog.model.provider.ProvidersExample;
import com.zhela.cloudblog.service.provider.ProviderService;

public class ProviderServiceImpl implements ProviderService{

	@Override
	public List<Providers> selectAllProviders() throws Exception {
		return providersDAO.selectByExample(new ProvidersExample());
	}
	
	
	private ProvidersDAO providersDAO;
	public void setProvidersDAO(ProvidersDAO providersDAO) {
		this.providersDAO = providersDAO;
	}
	
	
}
