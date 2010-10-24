package com.zhela.cloudblog.service.provider;

import com.zhela.cloudblog.model.provider.Providers;

public interface ProviderService {

	public java.util.List<Providers> selectAllProviders() throws Exception;
	
	public Providers selectProviderByID(long id) throws Exception;
	
}
