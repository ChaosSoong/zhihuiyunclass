package com.hdky.activity;

import com.hdky.server.Teacher2server;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Teacher_add extends Activity{
	Button btnButton;
	EditText et_idEditText,et_passwordEditText,et_nameEditText,et_classessEditText,et_sexEditText,et_ageEditText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_teacher);
		initView();
		btnButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final Handler mHandler = new Handler(){
					public void handleMessage(Message msg) {
//						String respone = (String) msg.obj;
						//if ("true".equals(respone)) {
							Toast.makeText(getApplicationContext(), "add success", 1).show();
						//}		
					};
				};
				new Thread(new Runnable() {		
					@Override
					public void run() {
						Teacher2server t =new Teacher2server();
						t.DoPost(et_idEditText.getText().toString(), et_passwordEditText.getText().toString(), et_nameEditText.getText().toString(),et_classessEditText.getText().toString(),et_sexEditText.getText().toString(),et_ageEditText.getText().toString());
//						String result = null;
						Message msg = new Message();
//						msg.obj = result;
						mHandler.sendEmptyMessage(1);
					}
				}).start();
			}
		});
	}

	private void initView() {
		// TODO Auto-generated method stub
		btnButton = (Button) findViewById(R.id.btn_add_teacher);
		et_idEditText = (EditText) findViewById(R.id.et_teacher_id);
		et_passwordEditText = (EditText) findViewById(R.id.et_teacher_password);
		et_nameEditText = (EditText) findViewById(R.id.et_teacher_name);
		et_classessEditText = (EditText) findViewById(R.id.et_teacher_classes);
		et_sexEditText = (EditText) findViewById(R.id.et_teacher_sex);
		et_ageEditText = (EditText) findViewById(R.id.et_teacher_age);
		
	}
}
