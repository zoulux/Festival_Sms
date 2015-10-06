package com.zoulux.servicemp3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by zoulux on 2015-10-04 16:35.
 */
public class MusicService extends Service {
    private static final String TAG = "MusicService";

    private MediaPlayer mPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(MusicService.this, "MusicService onBind", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"MusicService onBind");
        mPlayer.start();

        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(MusicService.this, "MusicService onUnbind", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MusicService onUnbind");
        mPlayer.stop();

        return false;
    }

    @Override
    public void onCreate() {
        Toast.makeText(MusicService.this, "MusicService onCreate", Toast.LENGTH_SHORT).show();
        mPlayer=MediaPlayer.create(getApplicationContext(),R.raw.babayetu );
        mPlayer.setLooping(true);
        Log.i(TAG, "MusicService onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(MusicService.this, "MusicService onStartCommand", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MusicService onStartCommand");
        mPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(MusicService.this, "MusicService onDestroy", Toast.LENGTH_SHORT).show();
        mPlayer.stop();
        Log.i(TAG, "MusicService onDestroy");
    }
}
