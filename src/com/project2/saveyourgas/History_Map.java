package com.project2.saveyourgas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class History_Map extends Activity{
	
	private Intent intent_menu;
	private Button btn_menu;
	private Intent intent_history;
	private Button btn_history;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history_map);
		
		/*btn_map*/
		btn_history = (Button) findViewById(R.id.btn_history);
		intent_history = new Intent(getApplicationContext(), History.class);
		btn_history.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(intent_history);
			}
		});
		
		/*btn_menu*/
		btn_menu = (Button) findViewById(R.id.btn_menu);
		intent_menu = new Intent(getApplicationContext(), MainActivity.class);
		btn_menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(intent_menu);
			}
		});
	}


}
