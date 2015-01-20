package com.project2.saveyourgas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class History_Result extends Activity{
	
	private Intent intent_map;
	private Button btn_map;
	private Intent intent_menu;
	private Button btn_menu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history_result);
		
		/*btn_map*/
		btn_map = (Button) findViewById(R.id.btn_map);
		intent_map = new Intent(getApplicationContext(), History_Map.class);
		btn_map.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(intent_map);
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
