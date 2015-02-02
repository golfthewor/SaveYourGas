package com.project2.saveyourgas;

import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Vehical extends Activity {

	private Spinner spinner1, spinner2, spinner3;
	private Button btnConfirm;
	private Intent intent_result;
	private Intent intent;

	private String vehical;
	private String engine;
	private String gas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vehical);

		addListenerOnButton();
		addListenerOnSpinnerItemSelection();

	}

	private void addListenerOnButton() {
		// TODO Auto-generated method stub
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner3 = (Spinner) findViewById(R.id.spinner3);

		btnConfirm = (Button) findViewById(R.id.btnConfirm);
		btnConfirm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				vehical = String.valueOf(spinner1.getSelectedItem());
				engine = String.valueOf(spinner2.getSelectedItem());
				gas = String.valueOf(spinner3.getSelectedItem());

				intent_result = new Intent(getApplicationContext(),
						Result.class);
				intent_result.putExtra("vehical", vehical);
				intent_result.putExtra("engine", engine);
				intent_result.putExtra("gas", gas);

				startActivity(intent_result);

			}
		});
	}

	private void addListenerOnSpinnerItemSelection() {
		// TODO Auto-generated method stub
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());

		spinner3 = (Spinner) findViewById(R.id.spinner3);
		spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else if (id == R.id.action_home) {

			intent = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(intent);

		} else if (id == R.id.action_history) {
			Intent intent = new Intent(getApplicationContext(), History.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
