package com.zhela.cloudblog.util;

import com.zhela.cloudblog.model.provider.Providers;
import com.zhela.cloudblog.rest.model.RESTProvider;
import com.zhela.cloudblog.rest.model.RESTProviderList;

public class ModeConvert {

	public static RESTProviderList ProvidersListToREST(long start,int limit,java.util.List<Providers> providers){
		RESTProviderList providerlist = new RESTProviderList();
		providerlist.setStart(start);
		providerlist.setLimit(limit);
		providerlist.setSize(providers.size());
		java.util.List<RESTProvider> rest_list = new java.util.ArrayList<RESTProvider>();
		RESTProvider rest;
		for(Providers provider:providers){
			rest = new RESTProvider();
			rest.setCode(provider.getCode());
			rest.setDescription(provider.getDescription());
			rest.setId(provider.getId());
			rest.setLogo(provider.getLogo());
			rest.setName(provider.getName());
			rest.setRank(provider.getRank());
			rest.setStatus(provider.getStatus());
			rest.setUrl(provider.getWebUrl());
			rest_list.add(rest);
		}
		providerlist.setProviders(rest_list);
		return providerlist;
	}
}
