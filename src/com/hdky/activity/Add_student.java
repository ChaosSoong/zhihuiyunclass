package com.hdky.activity;
import com.hdky.server.Student2server;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_student extends Activity {
	Button btnButton;
	EditText et_idEditText,et_passwordEditText,et_nameEditText,et_classessEditText,et_sexEditText,et_ageEditText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_student);
		initview();
		btnButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final Handler mHandler = new Handler(){
					public void handleMessage(Message msg) {
							Toast.makeText(getApplicationContext(), "register success", 1).show();
					};
				};
				new Thread(new Runnable() {		
					@Override
					public void run() {
						Student2server s =new Student2server();
						s.DoPost(et_idEditText.getText().toString(), et_passwordEditText.getText().toString(), et_nameEditText.getText().toString(),et_classessEditText.getText().toString(),et_sexEditText.getText().toString(),et_ageEditText.getText().toString());
						Message msg = new Message();
						mHandler.sendEmptyMessage(1);
					}
				}).start();	
			}
		});
	}
	private void initview() {
		// TODO Auto-generated method stub
		btnButton = (Button) findViewById(R.id.btn_add_student);
		et_idEditText = (EditText) findViewById(R.id.et_student_id);
		et_passwordEditText = (EditText) findViewById(R.id.et_student_password);
		et_nameEditText = (EditText) findViewById(R.id.et_student_name);
		et_classessEditText = (EditText) findViewById(R.id.et_student_classes);
		et_sexEditText = (EditText) findViewById(R.id.et_student_sex);
		et_ageEditText = (EditText) findViewById(R.id.et_student_age);
	}
}
