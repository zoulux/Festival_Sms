package com.zoulux.servicemp3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button b1Start,b2Stop,b3Bind,b4UnBind;

    private ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(MainActivity.this, "ServiceConnection onServiceConnected", Toast.LENGTH_SHORT).show();
            Log.i(TAG,"ServiceConnection onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(MainActivity.this, "ServiceConnection onServiceDisconnected", Toast.LENGTH_SHORT).show();
            Log.i(TAG,"ServiceConnection onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "MainActivity onCreate", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainActivity onCreate");

        b1Start= (Button) findViewById(R.id.id_bt_start);
        b2Stop= (Button) findViewById(R.id.id_bt_stop);
        b3Bind= (Button) findViewById(R.id.id_bt_bind);
        b4UnBind= (Button) findViewById(R.id.id_bt_unbind);

        b1Start.setOnClickListener(this);
        b2Stop.setOnClickListener(this);
        b3Bind.setOnClickListener(this);
        b4UnBind.setOnClickListener(this);




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

    @Override
    public void onClick(View v) {

        Intent intent=new Intent(MainActivity.this,MusicService.class);
        switch (v.getId())
        {
            case R.id.id_bt_start:
                startService(intent);
                break;
            case R.id.id_bt_stop:
                stopService(intent);
                break;
            case R.id.id_bt_bind:
                bindService(intent,conn, Context.BIND_AUTO_CREATE);
                break;
            case R.id.id_bt_unbind:
                unbindService(conn);
                break;
           default:
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "MainActivity onDestroy", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainActivity onDestroy");
    }
}
