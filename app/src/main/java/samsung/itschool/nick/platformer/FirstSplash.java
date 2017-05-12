package samsung.itschool.nick.platformer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import static samsung.itschool.nick.platformer.SettingsActivity.mPlayer;


public class FirstSplash extends AppCompatActivity implements View.OnClickListener {


    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_splash);

        dbManager = DBManager.getInstance(this);

        Button b = (Button) findViewById(R.id.button);
        Button men = (Button) findViewById(R.id.butMenu);
        Button set = (Button) findViewById(R.id.settings);
        Button stat = (Button) findViewById(R.id.statBut);
        b.setOnClickListener( FirstSplash.this);
        men.setOnClickListener(FirstSplash.this);
        set.setOnClickListener(FirstSplash.this);
        stat.setOnClickListener(FirstSplash.this);
    }/*
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(sp Intent(this, MusicService.class));

    }/*
/*

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        }


    }
*/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mPlayer.isPlaying()) {
            mPlayer.stop();
            try {
                mPlayer.prepare();
                mPlayer.seekTo(0);
            } catch (IOException e) {
                e.printStackTrace();
            }

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
            case R.id.settings:
                intent =  new Intent(FirstSplash.this, SettingsActivity.class);
                startActivity(intent);
                break;


            case R.id.statBut:
                intent = new Intent(FirstSplash.this, StatActivity.class);
                startActivity(intent);
                break;
        }

    }
}


