package com.xyb.highmaps.biz.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;


public class HttpClientUtil  {
	
	public static String httpPostWithJSON(String url, String header,String json) throws Exception{
		HttpClientBuilder hb =  HttpClientBuilder.create();
		CloseableHttpClient chc = hb.build();
		HttpPost hp = new HttpPost(url);
		hp.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
		if(header != null && !"".equals(header))hp.setHeader("appVersion", header);
		InputStream is = null;
		ByteArrayOutputStream bos = null; 
		try {
			StringEntity se = new StringEntity(json);
			se.setContentType("text/json");
	        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
	        hp.setEntity(se);
			HttpResponse hr = chc.execute(hp);
			HttpEntity he = hr.getEntity();
			if(he != null) {
				is = he.getContent();
				bos = new ByteArrayOutputStream();
				int len = 0;
				byte[] buf = new byte[1024];
				while((len = is.read(buf)) != -1){
					bos.write(buf, 0, len);
				}
				bos.flush();
				return bos.toString();
			}else {
				return "";
			}
		} finally{
			if(is != null)is.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(httpPostWithJSON("http://localhost:8080/xyb-www-app/user/account/getRewardAccount","", "{\"userId\":10000840}"));
	}
}
