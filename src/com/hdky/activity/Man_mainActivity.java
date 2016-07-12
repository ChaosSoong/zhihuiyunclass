package com.hdky.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Man_mainActivity extends Activity {
	Button btnButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_man);
		initView();
		btnButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Man_mainActivity.this,Teacher_add.class);
				startActivity(intent);
			}
		});
	}
	public void initView() {
	  btnButton = (Button) findViewById(R.id.btn_addteacher);
	}

}
