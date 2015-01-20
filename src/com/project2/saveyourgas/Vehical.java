package com.project2.saveyourgas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Vehical extends Activity{
	
	private Intent intent_confirm;
	private Button btn_confirm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vehical);
		
		/*btn_confirm*/
		btn_confirm = (Button) findViewById(R.id.btn_confirm);
		intent_confirm = new Intent(getApplicationContext(), Result.class);
		btn_confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(intent_confirm);
			}
		});
	}


}
