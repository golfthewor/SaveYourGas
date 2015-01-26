package com.project2.saveyourgas;

import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Vehical extends Activity{
	
	private Intent intent_confirm;
	private Button btn_confirm;
	
	private ListView listview;
	private ArrayAdapter<String> AdapterXML;
	private ArrayList<String> ListitemXML = new ArrayList<String>();
	
	private SoapPrimitive Results = null;
	
	private static String URL = "http://www.pttplc.com/webservice/pttinfo.asmx?WSDL";
	private static String NAMESPACE = "http://www.pttplc.com/ptt_webservice/";
	private static String METHOD_NAME = "CurrentOilPrice";
	private static String SOAP_ACTION = "http://www.pttplc.com/ptt_webservice/CurrentOilPrice";
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vehical);
		
		/*btn_confirm*/
		btn_confirm = (Button) findViewById(R.id.btn_confirm);
		intent_confirm = new Intent(getApplicationContext(), Result.class);
		
		listview= (ListView) findViewById(R.id.listview);
		GetResponseXML();
		
		btn_confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(intent_confirm);
			}
		});
	}

	private void GetResponseXML() {
		// TODO Auto-generated method stub
		
		Thread s = new Thread() {
    		
    		@Override
    		public void run() {

    			try {
    				
    				SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    				request.addProperty("Language", "EN");
    				
    				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    				envelope.dotNet = true;
    				envelope.setOutputSoapObject(request);
    				
    				HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
					androidHttpTransport.call(SOAP_ACTION, envelope);
					SoapPrimitive resultRequestSOAP = (SoapPrimitive)envelope.getResponse();
					Results = resultRequestSOAP;
					
				} catch (Exception e) {
					// TODO: handle exception
					Results= null;
				} finally {
					if(Results == null) {
						Log.e("WebServiceExample", "Soap object Error");
				
					} else {
						pareser();
					
					}
				}
    			
    		}

    	};
    	s.start();
		
	}
	
	 public void pareser() {
	    	
	    	ListitemXML.add(Results.toString());
	    	Listing();

	    }
	    
	    public void Listing() {
	    	Runnable run = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					AdapterXML = new ArrayAdapter<String>(Vehical.this, android.R.layout.simple_list_item_1,
							ListitemXML);
					AdapterXML.notifyDataSetChanged();
					listview.setAdapter(AdapterXML);
				}
			};
			this.runOnUiThread(run);
	    }


}
