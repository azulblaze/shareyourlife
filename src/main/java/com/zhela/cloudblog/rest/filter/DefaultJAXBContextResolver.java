package com.zhela.cloudblog.rest.filter;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import com.sun.jersey.spi.resource.Singleton;
import com.zhela.cloudblog.rest.model.RESTCategory;
import com.zhela.cloudblog.rest.model.RESTCategoryList;
import com.zhela.cloudblog.rest.model.RESTCommentList;
import com.zhela.cloudblog.rest.model.RESTMessageList;
import com.zhela.cloudblog.rest.model.RESTNewsList;
import com.zhela.cloudblog.rest.model.RESTProviderAccountList;
import com.zhela.cloudblog.rest.model.RESTProviderList;
import com.zhela.cloudblog.rest.model.RESTServiceCommentList;
import com.zhela.cloudblog.rest.model.RESTTweet;
import com.zhela.cloudblog.rest.model.RESTTweetList;
import com.zhela.cloudblog.rest.model.RESTUserList;

@Provider
@Singleton
public class DefaultJAXBContextResolver implements ContextResolver<JAXBContext> {

    private JAXBContext context;
     @SuppressWarnings("unchecked")
	private Class[] types = {RESTCategory.class,RESTCategoryList.class,RESTCommentList.class,RESTMessageList.class,RESTNewsList.class,RESTProviderAccountList.class,RESTProviderList.class,RESTTweet.class,RESTTweetList.class,RESTUserList.class,RESTServiceCommentList.class};
 
     public DefaultJAXBContextResolver() throws Exception {
        //these tags should be treated as array type.
    	 this.context = new JSONJAXBContext( 
	    JSONConfiguration.mapped().arrays("subCategories","categories","comments","messages","newses","providerAccounts","providers","images","videos","tweets","users","s_comments").rootUnwrapping(true).build(), types); 
     }

     @SuppressWarnings("unchecked")
	public JAXBContext getContext(Class<?> objectType) {
         for (Class type : types) {
             if (type == objectType) {
                 return context;
            }
         }
         return null;
     }
}