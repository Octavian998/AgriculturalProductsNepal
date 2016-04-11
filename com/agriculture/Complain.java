package com.agriculture.krishibazar;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Complain extends Activity implements OnItemSelectedListener,
		OnClickListener {

	String district;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.complain);

		Spinner spinner = (Spinner) findViewById(R.id.spinnerDistrictList);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.district, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		Button btn = (Button) findViewById(R.id.btnSend);
		btn.setOnClickListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		district = (String) parent.getItemAtPosition(pos);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	@Override
	public void onClick(View view) {
		final SmsManager smsManager = SmsManager.getDefault();

		String phoneno = "9849935186";
		EditText etMessage = (EditText) findViewById(R.id.etMessage);
		String message = String.valueOf("From: " + district + "\n"
				+ etMessage.getText());
		try {
			smsManager.sendTextMessage(phoneno, null, message, null, null);
			Toast.makeText(getBaseContext(), "SMS Sent to " + phoneno,
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getBaseContext(),
					"SMS faild, please try again later!", Toast.LENGTH_LONG)
					.show();
			e.printStackTrace();
		}
		etMessage.setText("");
	}
}
