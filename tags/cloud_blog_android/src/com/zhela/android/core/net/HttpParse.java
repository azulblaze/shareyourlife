package com.zhela.android.core.net;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpParse {

	public final static int METHOD_GET = 0;
	public final static int METHOD_PUT = 1;
	public final static int METHOD_POST = 2;
	public final static int METHOD_MULTIPARTPOST = 3;
	public final static int METHOD_DELETE = 4;
	private Gson gson = new GsonBuilder().registerTypeAdapter(java.util.Date.class, new DateTypeAdapter()).create();
	private HttpClient httpclient;
	
	public HttpParse(HttpClient httpclient) {
		this.httpclient = httpclient;
	}
	
	/**
	 * 
	 * @param <T>
	 * @param type
	 * @param url
	 * @param parameters
	 * @param file
	 * @param fileFormName
	 * @param classOfT
	 * @return
	 * @throws NetStatusException
	 */
	public <T> T getResponse(int type,String url,Map<String,String> parameters,File file,String fileFormName,Class<T> classOfT) throws NetStatusException{
		try{
			switch(type){
			case METHOD_GET:
				return gson.fromJson(GET(url),classOfT);
			case METHOD_PUT:
				return gson.fromJson(PUT(url,parameters),classOfT);
			case METHOD_POST:
				return gson.fromJson(POST(url,parameters),classOfT);
			case METHOD_MULTIPARTPOST:
				return gson.fromJson(POST(url,file,fileFormName,parameters),classOfT);
			case METHOD_DELETE:
				return gson.fromJson(DELETE(url),classOfT);
			}
			return null;
		}catch(NetStatusException e){
			throw e;
		}catch(Exception e){
			throw new NetStatusException(-1,e.getMessage());
		}
	}

	public String GET(String url) throws NetStatusException{
		HttpGet get = new HttpGet(url);
		setHeader(get);
		try{
			HttpResponse response = httpclient.execute(get);
			int code = 0;
			code = response.getStatusLine().getStatusCode();
			if(code==200){
				return getFromZip(response);
			}else{
				NetStatusException nse = new NetStatusException();
				nse.setCode(code);
				nse.setResponse(getFromZip(response));
				throw nse;
			}
		}catch(IOException e){
			throw new NetStatusException(-1,e.getMessage());
		}
	}
	
	public String PUT(String url,Map<String,String> parameters) throws NetStatusException{
		HttpPut put = new HttpPut(url);
		setHeader(put);
		try{
			if(parameters!=null){
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				for(String key:parameters.keySet()){
					params.add(new BasicNameValuePair(key, parameters.get(key)));
				}
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
				put.setEntity(entity);
			}
			HttpResponse response = httpclient.execute(put);
			int code = 0;
			code = response.getStatusLine().getStatusCode();
			if(code==200){
				return getFromZip(response);
			}else{
				NetStatusException nse = new NetStatusException();
				nse.setCode(code);
				nse.setResponse(getFromZip(response));
				throw nse;
			}
		}catch(IOException e){
			throw new NetStatusException(-1,e.getMessage());
		}
	}
	
	public String DELETE(String url) throws NetStatusException{
		HttpDelete delete = new HttpDelete(url);
		setHeader(delete);
		try{
			HttpResponse response = httpclient.execute(delete);
			int code = 0;
			code = response.getStatusLine().getStatusCode();
			if(code==200){
				return getFromZip(response);
			}else{
				NetStatusException nse = new NetStatusException();
				nse.setCode(code);
				nse.setResponse(getFromZip(response));
				throw nse;
			}
		}catch(IOException e){
			throw new NetStatusException(-1,e.getMessage());
		}
	}
	
	public String POST(String url,Map<String,String> parameters) throws NetStatusException{
		HttpPost post = new HttpPost(url);
		setHeader(post);
		try{
			if(parameters!=null){
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				for(String key:parameters.keySet()){
					params.add(new BasicNameValuePair(key, parameters.get(key)));
				}
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,HTTP.UTF_8);
				post.setEntity(entity);
			}
			HttpResponse response = httpclient.execute(post);
			int code = 0;
			code = response.getStatusLine().getStatusCode();
			if(code==200){
				return getFromZip(response);
			}else{
				NetStatusException nse = new NetStatusException();
				nse.setCode(code);
				nse.setResponse(getFromZip(response));
				throw nse;
			}
		}catch(IOException e){
			throw new NetStatusException(-1,e.getMessage());
		}
	}
	
	public String POST(String url, File file, String fileFormName,
			Map<String, String> parameters) throws NetStatusException {
		HttpURLConnection conn = null;
		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "---------------------------28318289637813";
		try {
			// Make a connect to the server
			URL _url = new URL(url);
			conn = (HttpURLConnection) _url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(10000);
			conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
			conn.setRequestProperty("Cookie", getSessionId());
			conn.setRequestProperty("Content-Type","multipart/form-data; boundary=" + boundary);
			// Send the body
			DataOutputStream dataOS = new DataOutputStream(conn
					.getOutputStream());
			if (parameters != null) {
				for (String key : parameters.keySet()) {
					dataOS.writeBytes(twoHyphens + boundary + end);
					dataOS.writeBytes("Content-Disposition: form-data; "
							+ "name=\"" + key + "\"" + end + end);
					dataOS.writeBytes(parameters.get(key) + end);
				}
			}
			if(file!=null&&fileFormName!=null){
				dataOS.writeBytes(twoHyphens + boundary + end);
				dataOS.writeBytes("Content-Disposition: form-data; " + "name=\""
						+ fileFormName + "\";filename=\"" + file.getName() + "\""
						+ end);
				dataOS.writeBytes("Content-Type: application/octet-stream" + end);
				dataOS.writeBytes(end);
				FileInputStream fStream = new FileInputStream(file);
				int bufferSize = 1024;
				byte[] buffer = new byte[bufferSize];
				int length = -1;
				while ((length = fStream.read(buffer)) != -1) {
					dataOS.write(buffer, 0, length);
				}
				fStream.close();
				dataOS.writeBytes(end);
				
			}
			dataOS.writeBytes(twoHyphens + boundary + twoHyphens + end);
			dataOS.flush();
			dataOS.close();
			// Ensure we got the HTTP 200 response code
			int responseCode = conn.getResponseCode();
			InputStream is = conn.getInputStream();
			if (responseCode == 200) {
				return getFromZip(is);
			}else{
				NetStatusException nse = new NetStatusException();
				nse.setCode(responseCode);
				nse.setResponse(getFromZip(is));
				throw nse;
			}
		} catch (IOException e) {
			throw new NetStatusException(-1, e.getMessage());
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
	
	private void setHeader(HttpRequest hm) {
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, 5000);
		HttpConnectionParams.setSoTimeout(httpParameters, 70000);
		hm.setParams(httpParameters);
		hm.addHeader("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.9) Gecko/20100824 Firefox/3.6.9 ( .NET CLR 3.5.30729)");
		hm.addHeader("Accept","application/x-www-form-urlencode");
		hm.addHeader("Accept-Language", "en-us,en;q=0.5");
		hm.addHeader("Accept-Encoding", "gzip,deflate");
		hm.addHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
		hm.addHeader("Keep-Alive", "115");
		hm.addHeader("Connection", "keep-alive");
		hm.addHeader("Referer", "url");
	}
	private String getFromZip(HttpResponse hm) throws IOException {
		InputStream is = hm.getEntity().getContent();
		return getFromZip(is);
	}

	private String getFromZip(InputStream is) throws IOException{
		InputStream gzin = new GZIPInputStream(is);
		InputStreamReader isr = new InputStreamReader(gzin, "utf-8");
		java.io.BufferedReader br = new java.io.BufferedReader(isr);
		String tempbf;
		StringBuffer sb = new StringBuffer();
		while ((tempbf = br.readLine()) != null) {
			sb.append(tempbf);
			sb.append("\r\n");
		}
		isr.close();
		gzin.close();
		return sb.toString();
	}
	private String getSessionId() {
		java.util.List<Cookie> cookies = ((AbstractHttpClient) httpclient)
				.getCookieStore().getCookies();
		String str = "";
		for (Cookie cookie : cookies) {
			if (cookie != null && cookie.getName().equals("JSESSIONID")) {
				str = str +cookie.getName()+"="+cookie.getValue()+";";
			}
		}
		return str;
	}
}
