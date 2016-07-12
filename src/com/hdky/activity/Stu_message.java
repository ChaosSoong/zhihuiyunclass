package com.hdky.activity;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.http.util.ByteArrayBuffer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hdky.bean.Message;

public class Stu_message extends Activity {
	WebView v;
	String result="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stu_message);
		v = (WebView) findViewById(R.id.webview);

		final Handler mHandler = new Handler(){
			public void handleMessage(android.os.Message msg) {
				if (msg.what==0x1122) {
					System.out.println(result);
					v.loadDataWithBaseURL(null, result, "text/html", "gbk", null);
				}
			};
		 };
		new Thread (new Runnable() {
			
			@Override
			public void run() {
				try {  
					URL httpUrl = new URL("http://10.0.2.2:8080/login/Query");
					HttpURLConnection conn=(HttpURLConnection)httpUrl.openConnection();
		            conn.setConnectTimeout(3000);
		            conn.setRequestMethod("POST");
		            if (conn.getResponseCode()!=200) {
						throw new RuntimeException("请求失败");
					}
		            InputStream is =conn.getInputStream();
		            result = readData(is, "utf-8");
		        } catch(Exception e) {  
		            e.printStackTrace();
		        }  
				mHandler.sendEmptyMessage(0x1122);
			}
		}).start();;	
   }  
	public String readData(InputStream is,String coding) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			byte[] buffer = new byte[1024];
		int hasread = 0;
		while ((hasread= is.read())!=-1) {
			outputStream.write(buffer,0,hasread);	
		}
		byte[] data= outputStream.toByteArray();
		for(byte i: data){
			if(i != (byte)0){
				//System.out.println("feiquan0");
				Toast.makeText(this, "feiquan0", Toast.LENGTH_LONG).show();
			}
				
		}
		outputStream.close();
		is.close();
		return new String(data,coding);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
		
    }
