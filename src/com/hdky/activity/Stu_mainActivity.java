package com.hdky.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Stu_mainActivity extends Activity {
	Button btn_classes_stu,btn_grade_stu,btn_message_stu,btn_my_stu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_stu);
		initView();
		btn_message_stu.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(Stu_mainActivity.this,Stu_message.class);
				startActivity(intent);
			}
		});
	}

	public void initView() {
		btn_my_stu = (Button) findViewById(R.id.btn_classes_stu);
		//btn_grade_stu = (Button) findViewById(R.id.btn_grade_stu);
		btn_message_stu = (Button) findViewById(R.id.btn_message_stu);
		btn_my_stu = (Button) findViewById(R.id.btn_my_stu);
	}
	
}
	
