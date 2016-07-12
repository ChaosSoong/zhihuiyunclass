package com.hdky.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tea_mainActivity extends Activity{
	public Button btn_message_tea,btn_grade_tea,btn_class_tea,btn_my_tea;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_tea);
		initView();
		btn_message_tea.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Tea_mainActivity.this,Tea_sendMessageActivity.class);
				startActivity(intent);	
			}
		});
		
	}

	public void initView() {
		btn_message_tea =(Button) findViewById(R.id.btn_message_tea);
		//btn_grade_tea=(Button) findViewById(R.id.btn_grade_tea);
		btn_class_tea = (Button) findViewById(R.id.btn_classes_tea);
		btn_my_tea = (Button)findViewById(R.id.btn_my_tea);
	}

}
