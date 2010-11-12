package com.zhela.android.core.net;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

public class HttpParse {

	private HttpClient httpclient;

	public HttpParse(HttpClient httpclient) {
		this.httpclient = httpclient;
	}

	public <T> T GET(String address, Class<T> classOfT) throws Exception {
		try {
			T d = (T) "d";
			return d;
		} catch (Exception e) {
			throw e;
		}
	}

	public void POST() throws Exception {
		HttpPost hp = new HttpPost(
				"http://10.80.3.141:8080/cloudblog/api/providers/1/yan925%40gmail.com/tweets/content.json");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("user", "kris"));
		params.add(new BasicNameValuePair("pass", "xyz"));
		UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
		hp.setEntity(ent);
	}

	public String post(String action, Map<String, String> params,
			FormFile[] files) throws Exception {
		String BOUNDARY = "***#####";
		String MULTIPART_FROM_DATA = "multipart/form-data";
		URL uri = new URL(action);
		HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
		conn.setDoInput(true);// allow input
		conn.setDoOutput(true);// allow output
		conn.setConnectTimeout(10000);
		conn.setUseCaches(false); // no allow cache
		// the follow parameters must be set
		conn.setRequestMethod("POST");
		conn.setRequestProperty("connection", "keep-alive");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
		conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA
				+ ";boundary" + BOUNDARY);
		// conn.setRequestProperty("Cookie",sessionId);
		// first add the test value
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			sb.append("--");
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition:form-data; name=\"" + entry.getKey()
					+ "\r\n\r\n");
			sb.append(entry.getValue());
			sb.append("\r\n");
		}
		DataOutputStream outStream = new DataOutputStream(conn
				.getOutputStream());
		outStream.write(sb.toString().getBytes());
		// here, send the file
		for (FormFile file : files) {
			sb = new StringBuilder();
			sb.append("--");
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition:form-data:name=\""
					+ file.getFormname());
			sb.append("Content-Type" + file.getContentType() + "\r\n\r\n");
			outStream.write(sb.toString().getBytes());
			// check the file is exist,if yes read and send
			if (file.getInStream() != null) {
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = file.getInStream().read(buffer)) != -1) {
					outStream.write(buffer, 0, len);
				}
				file.getInStream().close();
			}
			outStream.write("\r\n".getBytes());
		}
		byte[] end_data = ("--" + BOUNDARY + "\r\n").getBytes();
		outStream.write(end_data);
		outStream.flush();
		// here we get response
		int res = conn.getResponseCode();
		if (res != 200) {
			throw new RuntimeException("request fail");
		}
		InputStream in = conn.getInputStream();
		String result = getFromZip(in);
		outStream.close();
		conn.disconnect();
		return result;
	}

	public String put(String targetURL,Map<String, String> params, FormFile file) throws Exception {

        String BOUNDRY = "---------------------------902317271771";
        HttpURLConnection conn = null;
        String prefix = "--";
        String newline = "\n";
        try {

            // These strings are sent in the request body. They provide information about the file being uploaded
            String contentDisposition = "Content-Disposition: form-data; name=\""+file.getFormname()+"\"; filename=\""+file.getFileName()+"\"";
            String contentType = "Content-Type: "+file.getContentType();
            // This is the standard format for a multipart request
            StringBuffer requestBody = new StringBuffer();
            requestBody.append("Content-Type: multipart/form-data; boundary="+BOUNDRY);
            requestBody.append(newline);
            for(String key:params.keySet()){
            	requestBody.append(newline);
            	requestBody.append(prefix+BOUNDRY);
            	requestBody.append(newline);
            	requestBody.append("Content-Disposition: form-data; name=\""+key+"\" "+params.get(key));
            }
            requestBody.append(newline);
            requestBody.append(contentDisposition);
            requestBody.append(newline);
            requestBody.append(contentType);
            requestBody.append(newline);
            // Make a connect to the server
            URL url = new URL(targetURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(10000);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setChunkedStreamingMode(100);
            conn.setFollowRedirects(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDRY);
    		conn.setRequestProperty("connection", "keep-alive");
    		conn.setRequestProperty("Charset", "UTF-8");
    		conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
    		conn.setRequestProperty("Cookie",getSessionId());
            // Send the body
            DataOutputStream dataOS = new DataOutputStream(conn.getOutputStream());
            //write header
            dataOS.write(requestBody.toString().getBytes());
            //write body
            if (file.getInStream() != null) {
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = file.getInStream().read(buffer)) != -1) {
					dataOS.write(buffer, 0, len);
				}
				file.getInStream().close();
			}
            //write end
            dataOS.write("prefix+BOUNDRY+prefix".getBytes());
            dataOS.flush();
            dataOS.close();
    		InputStream in = conn.getInputStream();
    		String result = getFromZip(in);
    		return result;
        }catch(Exception e){
        	e.printStackTrace();
        	return e.getMessage();
        }finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

    }

	public String test() throws Exception {
		HttpGet hm = new HttpGet(
				"http://10.80.3.210:8080/cloudblog/api/users/cashguy/chenyan.json");
		setHeader(hm);
		HttpResponse response = httpclient.execute(hm);
		String str = getFromZip(response);
		if (str != null) {
			return str;
		}
		System.out.println(str);
		hm = new HttpGet(
				"http://10.80.3.210:8080/cloudblog/api/providers/1/tweets/content/hometweet.json?pa=yan925%40gmail.com");
		setHeader(hm);
		response = httpclient.execute(hm);
		str = getFromZip(response);
		return str;
	}

	private void setHeader(HttpRequest hm) {
		hm
				.addHeader(
						"User-Agent",
						"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.9) Gecko/20100824 Firefox/3.6.9 ( .NET CLR 3.5.30729)");
		hm
				.addHeader("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		hm.addHeader("Accept-Language", "en-us,en;q=0.5");
		hm.addHeader("Accept-Encoding", "gzip,deflate");
		hm.addHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
		hm.addHeader("Keep-Alive", "115");
		hm.addHeader("Connection", "keep-alive");
		hm.addHeader("Referer", "url");
	}

	private String getFromZip(HttpResponse hm) throws Exception {
		InputStream is = hm.getEntity().getContent();
		return getFromZip(is);
	}

	private String getFromZip(InputStream is) throws Exception {
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

	public static void main(String[] args) throws Exception {
		HttpClient hc = new DefaultHttpClient();
		HttpParse hp = new HttpParse(hc);
		hp.test();
		System.out.println(hc.getParams().getParameter("Cookie"));
	}

	private String getSessionId() {
		java.util.List<Cookie> cookies = ((AbstractHttpClient) httpclient)
				.getCookieStore().getCookies();
		for (Cookie cookie : cookies) {
			if (cookie != null && cookie.getName().equals("JSESSIONID")) {
				return cookie.getValue();
			}
		}
		return "";
	}
}
