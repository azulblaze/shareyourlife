package com.zhela.cloudblog.util;

import com.zhela.cloudblog.model.provider.Providers;
import com.zhela.cloudblog.model.users.ProviderUser;
import com.zhela.cloudblog.model.users.Users;
import com.zhela.cloudblog.rest.model.RESTInternalUser;
import com.zhela.cloudblog.rest.model.RESTProvider;
import com.zhela.cloudblog.rest.model.RESTProviderAccount;
import com.zhela.cloudblog.rest.model.RESTProviderAccountList;
import com.zhela.cloudblog.rest.model.RESTProviderList;

public class ModeConvert {

	public static RESTProviderList ProvidersListToREST(long start,int limit,java.util.List<Providers> providers){
		RESTProviderList providerlist = new RESTProviderList();
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
	
	public static RESTInternalUser InternalUserToREST(Users user){
		RESTInternalUser RESTIU = new RESTInternalUser();
		RESTIU.setAccount(user.getAccount());
		RESTIU.setDisplayName(RESTIU.getDisplayName());
		RESTIU.setEmail(user.geteMail());
		RESTIU.setHeader(user.getHeader());
		RESTIU.setUpdateTime(user.getUpdateTime());
		return RESTIU;
	}
	
	public static RESTProviderAccount ProviderUserToREST(ProviderUser puser){
		RESTProviderAccount restpa = new RESTProviderAccount();
		restpa.setProviderAccount(puser.getProviderAccount());
		restpa.setProviderId(puser.getProviderId());
		restpa.setStatus(puser.getStatus());
		restpa.setToken(puser.getToken());
		restpa.setTokenMore(puser.getTokenMore());
		restpa.setUpdateTime(puser.getUpdateTime());
		return restpa;
	}
	
	public static RESTProviderAccountList ProviderUserToREST(java.util.List<ProviderUser> pusers){
		java.util.List<RESTProviderAccount> list = new java.util.ArrayList<RESTProviderAccount>();
		for(ProviderUser puser:pusers){
			list.add(ProviderUserToREST(puser));
		}
		RESTProviderAccountList restpal = new RESTProviderAccountList();
		restpal.setProviderAccounts(list);
		return restpal;
	}
}
