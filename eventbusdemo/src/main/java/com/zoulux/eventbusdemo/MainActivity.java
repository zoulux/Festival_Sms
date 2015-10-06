package com.zoulux.eventbusdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import de.greenrobot.event.EventBus;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //事件注册
        EventBus.getDefault().register(this);
        InitUI();
    }

    private void InitUI() {
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TwoActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }

    //事件接受
    public void onEventMainThread(MainSendEvent event){
        if(event != null){
            Toast.makeText(getApplicationContext(),
                    "MainActivity接受数据" + event.getStringMsgData(),
                    Toast.LENGTH_LONG).show();
            TextView textView = (TextView)findViewById(R.id.textView1);
            textView.setText(event.getStringMsgData());
        }
    }

    @Override
    public void onDestroy() {
        //取消注册
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
