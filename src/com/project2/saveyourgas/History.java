package com.project2.saveyourgas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class History extends Activity {
	
	private Intent intent_view;
	private Button btn_view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		
		/*btn_view*/
		btn_view = (Button) findViewById(R.id.btn_view);
		intent_view = new Intent(getApplicationContext(), History_Result.class);
		btn_view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(intent_view);
			}
		});
	}

}
