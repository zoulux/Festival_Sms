package com.zoulux.simplebrodercast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private MyBrodercastReciver mBrodercastReciver;
    private static final String ACTION_DANCE = "ACTION_DOCK_EVENT";

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mBrodercastReciver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter(ACTION_DANCE);
        registerReceiver(mBrodercastReciver,intentFilter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBrodercastReciver=new MyBrodercastReciver();

        mButton= (Button) findViewById(R.id.id_bt_sendBrocat);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(ACTION_DANCE);
                intent.putExtra("tag", "" + Calendar.getInstance().getTime().toString());
                //   sendBroadcast(intent);
                sendOrderedBroadcast(intent, null);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyBrodercastReciver extends BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {

            Toast.makeText(context, "哈哈。。。"+intent.getExtras().getString("tag"), Toast.LENGTH_SHORT).show();
        //    abortBroadcast();
        }
    }
}
