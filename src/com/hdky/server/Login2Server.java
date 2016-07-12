package com.hdky.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Login2Server {
	public String url = "http://10.0.2.2:8080/login/Login";
	String result = "";
	public String DoPost(String id, String psw,String juese) {
		HttpClient hc=new DefaultHttpClient();
		HttpPost hp = new HttpPost(url);
		NameValuePair param1 = new BasicNameValuePair("username",id) ;
		NameValuePair param2 = new BasicNameValuePair("password",psw) ;
		NameValuePair param3 = new BasicNameValuePair("juese",juese ) ;	
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(param1);
		params.add(param2);
		params.add(param3);
		HttpEntity he; 
		try {
			he = new UrlEncodedFormEntity(params,"GBK");
			hp.setEntity(he);		
			HttpResponse response =hc.execute(hp);
			if (response.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
				HttpEntity het = response.getEntity();
				InputStream is = het.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String readline = null;
				while ((readline=br.readLine())!=null ) {
					result =result+readline;	
				}
				is.close();			
		} else {
			result="error";	
		}
			}catch (Exception e) {			
			e.printStackTrace();
			result="Exception";			
		}
		return result;			
		}	
}
	

