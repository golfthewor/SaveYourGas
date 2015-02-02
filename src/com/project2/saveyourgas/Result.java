package com.project2.saveyourgas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Result extends Activity {

	private Intent intent_map;
	private Button btn_map;
	final Context context = this;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		/* Result page detail */
		final TextView tripName = (TextView) findViewById(R.id.tripResult);
		final TextView vehical = (TextView) findViewById(R.id.vehicalResult);
		final TextView gas = (TextView) findViewById(R.id.gasResult);
		final TextView distance = (TextView) findViewById(R.id.distanceResult);
		final TextView price = (TextView) findViewById(R.id.priceResult);

		/* Dialog for get trip name */
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);

		final EditText input = new EditText(this);

		alertDialogBuilder.setMessage("Please enter trip name.").setView(input)
				.setCancelable(false)
				.setNeutralButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// if this button is clicked, close
						// current activity

						/* set result */
						tripName.setText(input.getText());
						vehical.setText(getIntent().getStringExtra("vehical")
								+ " " + getIntent().getStringExtra("engine"));
						gas.setText(getIntent().getStringExtra("gas")
								+ " price");
						distance.setText("200km.");
						price.setText("500 Bath.");

						dialog.cancel();
					}
				});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
		
		/*btn_map*/
		btn_map = (Button) findViewById(R.id.btnMap);
		intent_map = new Intent(getApplicationContext(), Mapping.class);
		btn_map.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(intent_map);
			}
		});
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
