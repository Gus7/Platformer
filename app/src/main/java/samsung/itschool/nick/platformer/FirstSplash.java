package samsung.itschool.nick.platformer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class FirstSplash extends AppCompatActivity implements View.OnClickListener {
    static MediaPlayer mPlayer;
    static Boolean playing = false;
    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_splash);
        mPlayer=MediaPlayer.create(this, R.raw.bg);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        dbManager = DBManager.getInstance(this);
        //startService(sp Intent(this, MusicService.class));
        Button b = (Button) findViewById(R.id.button);
        Button men = (Button) findViewById(R.id.butMenu);
        //Button set = (Button) findViewById(R.id.settings);
        Button stat = (Button) findViewById(R.id.statBut);
        b.setOnClickListener( FirstSplash.this);
        men.setOnClickListener(FirstSplash.this);
        //set.setOnClickListener(FirstSplash.this);
        stat.setOnClickListener(FirstSplash.this);
    }/*
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(sp Intent(this, MusicService.class));

    }/*
/*
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(sp Intent(this, MusicService.class));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        }


    }
*/
    private void stopPlay(){
        //stopService(sp Intent(this, MusicService.class));
        mPlayer.stop();
        playing = false;

        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);

        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

            mPlayer.stop();

    }
    @Override
    protected void onStart() {
        super.onStart();
        if (playing) {
            mPlayer.start();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Intent intent = new Intent(FirstSplash.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.butMenu:


                intent = new Intent(FirstSplash.this, MenuActivity.class);
                startActivity(intent);
                break;
            /*case R.id.settings:
                intent = sp Intent(FirstSplash.this, SettinsActivity.class);
                startActivity(intent);
                break;

                <Button
        android:text="Settings"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:layout_alignParentEnd="true"
        android:id="@+id/settings" />

            */case R.id.statBut:
                intent = new Intent(FirstSplash.this, StatActivity.class);
                startActivity(intent);
                break;
        }

    }
}


