package com.zoulux.surfaceviewplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button mButtonPlaye;
    private SurfaceView mSurfaceView;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonPlaye= (Button) findViewById(R.id.id_bt_play);
        mSurfaceView= (SurfaceView) findViewById(R.id.id_sv_player);
        mButtonPlaye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayer==null){
                    mPlayer=new MediaPlayer();
                }
                if (mPlayer.isPlaying()){

                    mPlayer.stop();
                    return;
                }



               mPlayer.reset();
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wql);
                try {
                    mPlayer.setDataSource(MainActivity.this,uri);
                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mPlayer.setDisplay(mSurfaceView.getHolder());
                    mPlayer.prepare();

                    mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mPlayer.start();
                        }
                    });


                } catch (IOException e) {
                    e.printStackTrace();
                }



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
}
