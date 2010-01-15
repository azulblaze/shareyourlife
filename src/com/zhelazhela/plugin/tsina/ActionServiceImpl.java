package com.zhelazhela.plugin.tsina;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

public class ActionServiceImpl implements ActionService {
	
	private Logger log = Logger.getLogger(ActionServiceImpl.class);
	
	private HttpClient httpclient;
	
	private String userid;

	@Override
	public boolean login(String name, String password) {
		httpclient = new HttpClient();
		httpclient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		getMethod(INDEX);
		java.util.List<NameValuePair> parameters = new java.util.ArrayList<NameValuePair>();
		parameters.add(new NameValuePair("client","ssologin.js(v1.3.0)"));
		parameters.add(new NameValuePair("encoding","utf-8"));
		parameters.add(new NameValuePair("entry","miniblog"));
		parameters.add(new NameValuePair("gateway","1"));
		parameters.add(new NameValuePair("password",password));
		parameters.add(new NameValuePair("returntype","META"));
		parameters.add(new NameValuePair("savestate","7"));
		parameters.add(new NameValuePair("service","miniblog"));
		parameters.add(new NameValuePair("url","http://t.sina.com.cn/ajaxlogin.php?framelogin=1&callback=parent.sinaSSOController.feedBackUrlCallBack"));
		parameters.add(new NameValuePair("username",name));
		parameters.add(new NameValuePair("useticket","useticket"));
		NameValuePair[] tmp = new NameValuePair[parameters.size()];
		tmp = parameters.toArray(tmp);
		postMethod("http://login.sina.com.cn/sso/login.php?client=ssologin.js(v1.3.0)",tmp);
		String content = getMethod("http://t.sina.com.cn/zhelazhela");
		System.out.println(content);
		return false;
	}
	
	//for local method
	
	private String getMethod(String url) {

		GetMethod getMethod = new GetMethod(url);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		try {
			int statusCode = httpclient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				log.info("Method failed: " + getMethod.getStatusLine());
			}
			return getMethod.getResponseBodyAsString();
		} catch (Exception e) {

		} finally {
			getMethod.releaseConnection();
		}
		return "";
	}

	/**
	 * 
	 * @param url the address that post
	 * @param parameters the data of post
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	private PostMethod postMethod(String url,NameValuePair[] parameters){
		PostMethod postMethod = new PostMethod(url);
		postMethod.setRequestBody(parameters);
		try{
			httpclient.executeMethod(postMethod);
		}catch(Exception e){
			log.info("post error:"+e);
		}
		return postMethod;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActionServiceImpl as = new ActionServiceImpl();
		as.login("zhelazhela@gmail.com", "yanyan1030");
	}

}
