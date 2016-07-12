package com.hdky.activity;

import com.hdky.server.Login2Server;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Button btn_login , btn_concle;
	RadioButton rb_student , rb_teacher , rb_manger ;
	EditText et_user , et_password;
	RadioGroup rGroup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
		btn_concle.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this,Add_student.class);
				startActivity(intent);
			}
		});
		btn_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				final Handler mHandler = new Handler(){
					@Override
					public void handleMessage(Message msg) {
						String respone = (String) msg.obj;
						System.out.println(respone);
						if (et_user.getText().toString()==null) {
							Toast.makeText(getApplicationContext(), "请填写用户名亲", Toast.LENGTH_LONG).show();
						}
						if (et_password.getText().toString()==null) {
							Toast.makeText(getApplicationContext(), "密码不能为空哦", Toast.LENGTH_LONG).show();
						}
						if (rb_student.isChecked()) {
							if ("true".equals(respone)) {
								Intent intent = new Intent(LoginActivity.this,Stu_mainActivity.class);
								startActivity(intent);
							}else {
								Toast.makeText(getApplicationContext(), "用户名与密码不匹配", Toast.LENGTH_LONG).show();;
						}
							}
						if (rb_teacher.isChecked()) {
							if ("true".equals(respone)) {
								Intent intent = new Intent(LoginActivity.this,Tea_mainActivity.class);
								startActivity(intent);
							}else {
								Toast.makeText(getApplicationContext(), "用户名与密码不匹配", Toast.LENGTH_LONG).show();
						}
							}
						if (rb_manger.isChecked()) {
						if ("true".equals(respone)) {
							Intent intent = new Intent(LoginActivity.this,Man_mainActivity.class);
							startActivity(intent);
						}else {
							Toast.makeText(getApplicationContext(), "用户名与密码不匹配", Toast.LENGTH_LONG).show();;
						}
			}
					}		
				};				
				new Thread(new Runnable() {		
					@Override
					public void run() {
						Login2Server login =new Login2Server();
						String result = null;
						try {
							if (rb_student.isChecked()) {
								result = login.DoPost(et_user.getText().toString(), et_password.getText().toString(),"1");
								System.out.println(result);
							}
							if (rb_teacher.isChecked()) {
								result = login.DoPost(et_user.getText().toString(), et_password.getText().toString(),"2");
								System.out.println(result);
							}
							if (rb_manger.isChecked()) {
								result = login.DoPost(et_user.getText().toString(), et_password.getText().toString(),"3");
								System.out.println(result);
							}	
						} catch (Exception e) {
							e.printStackTrace();
						}
						Message msg = new Message();
						msg.obj = result;
						mHandler.sendMessage(msg);
					}
				}).start();
}
	});
	}
	private void initView() {
		et_user = (EditText) findViewById(R.id.UserName);
		et_password = (EditText) findViewById(R.id.textPasswd);
		btn_login = (Button) findViewById(R.id.btnLogin);
		btn_concle = (Button) findViewById(R.id.btnconcle);
		rb_manger = (RadioButton) findViewById(R.id.rb_manger);
		rb_teacher = (RadioButton) findViewById(R.id.rb_teacher);
		rb_student = (RadioButton) findViewById(R.id.rb_student);
	}
}
