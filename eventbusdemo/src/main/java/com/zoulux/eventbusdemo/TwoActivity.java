package com.zoulux.eventbusdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import de.greenrobot.event.EventBus;
/**
 * �ڶ���TwoActivity�����¼�
 * @author mmsx
 *
 */
public class TwoActivity extends Activity implements OnClickListener{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		Button button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			//�¼�����
			EventBus.getDefault().post(new MainSendEvent("from TwoActivity msg"));
			break;
		default:
			break;
		}
		
	}
	



}
