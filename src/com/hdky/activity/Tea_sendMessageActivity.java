package com.hdky.activity;

import com.hdky.server.Message2server;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tea_sendMessageActivity extends Activity {
	Button btn_tea_sendMessage;
	EditText et_tea_message_title,et_tea_message_text,et_tea_message_time;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tea_message);
		initView();
		btn_tea_sendMessage.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				final Handler mHandler = new Handler(){
					public void handleMessage(Message msg) {
							Toast.makeText(getApplicationContext(), "send success", 1).show();
					};
				};
				new Thread(new Runnable() {		
					@Override
					public void run() {
						Message2server m =new Message2server();
						m.DoPost(et_tea_message_title.getText().toString(), et_tea_message_text.getText().toString(), et_tea_message_time.getText().toString());
						Message msg = new Message();
						mHandler.sendEmptyMessage(1);
					}
				}).start();
			}			
		});
	}
	public void initView() {
		btn_tea_sendMessage = (Button) findViewById(R.id.btn_send);
		et_tea_message_title = (EditText) findViewById(R.id.et_mtitle);
		et_tea_message_text = (EditText) findViewById(R.id.et_mtext);
		et_tea_message_time = (EditText) findViewById(R.id.et_mtime);
	}
}
