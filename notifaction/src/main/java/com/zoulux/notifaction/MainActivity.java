package com.zoulux.notifaction;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonVibrator;
    private Button mButtonLight;
    private Button mButtonVoce;
    private Button mButtonHandle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonVibrator = (Button) findViewById(R.id.id_bt_vibrator);
        mButtonLight = (Button) findViewById(R.id.id_bt_light);
        mButtonVoce = (Button) findViewById(R.id.id_bt_voice);
        mButtonHandle= (Button) findViewById(R.id.id_bt_handle);
        mButtonVibrator.setOnClickListener(this);
        mButtonLight.setOnClickListener(this);
        mButtonVoce.setOnClickListener(this);
        mButtonHandle.setOnClickListener(this);

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
        switch (v.getId()) {
            case R.id.id_bt_vibrator:
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(5000);
                break;
            case R.id.id_bt_light:
                showNotification();
                break;
            case R.id.id_bt_voice:
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Intent notificationIntent=new Intent(MainActivity.this,MainActivity.class);
                PendingIntent contentPendingIntent = PendingIntent.getActivity(MainActivity.this, 0, notificationIntent, 0);

                Notification notification = new Notification.Builder(MainActivity.this).
                        setAutoCancel(true).setContentTitle("标题").setContentIntent(contentPendingIntent).setSmallIcon(R.mipmap.ic_launcher).build();
                notification.defaults |= Notification.DEFAULT_LIGHTS;
                notification.defaults |= Notification.DEFAULT_VIBRATE;
                notification.flags |= Notification.FLAG_NO_CLEAR;
                notification.flags |= Notification.FLAG_ONGOING_EVENT;
                notification.sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                notification.flags |= Notification.FLAG_INSISTENT;
                nm.notify(0,notification);





                break;
            case R.id.id_bt_handle:
                handle();
            default:
                break;


        }
    }

    private void handle() {
        Message msg=new Message();
         Message.obtain(mHandler).sendToTarget();
        msg.obj="我是1";
      //  mHandler1.handleMessage(msg);
        mHandler1.sendMessage(msg);
        mHandler.sendMessage(msg);
    //    mHandler.handleMessage(msg);



    }

    private NotificationManager mNotificationManager = null;
    private static final int NOTIFICATION_ID = 0x111;



    private void showNotification() {

        if (mNotificationManager == null) {
            mNotificationManager = (NotificationManager) getSystemService(Activity.NOTIFICATION_SERVICE);
        }
        mNotificationManager.cancel(NOTIFICATION_ID);
        Notification notice = new Notification();
        notice.ledARGB = 0xffff00ff;
        notice.ledOnMS = 100;
        notice.ledOffMS = 100;
        notice.flags |= Notification.FLAG_SHOW_LIGHTS;
        Intent intent = new Intent();
        PendingIntent des = PendingIntent.getActivity(this,
                NOTIFICATION_ID, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        //   notice.setLatestEventInfo(this, null, null, des);
        mNotificationManager.notify(NOTIFICATION_ID, notice);
        new Thread(){

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    mNotificationManager.cancel(NOTIFICATION_ID);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();



    }
    Handler mHandler1=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
            return false;
        }
    });

   Handler mHandler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           Toast.makeText(MainActivity.this, msg.obj.toString()+">>>", Toast.LENGTH_SHORT).show();
       }
   };
}
