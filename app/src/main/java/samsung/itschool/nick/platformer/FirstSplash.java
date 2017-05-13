package samsung.itschool.nick.platformer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


public class FirstSplash extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    MediaPlayer mPlayer;
    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_splash);

        dbManager = DBManager.getInstance(this);
        mPlayer=MediaPlayer.create(this, R.raw.bg);
        Button b = (Button) findViewById(R.id.button);
        Button men = (Button) findViewById(R.id.butMenu);
        //Button set = (Button) findViewById(R.id.settings);
        Button stat = (Button) findViewById(R.id.statBut);
        Switch mus = (Switch)findViewById(R.id.switch1);
        b.setOnClickListener( FirstSplash.this);
        men.setOnClickListener(FirstSplash.this);
        //set.setOnClickListener(FirstSplash.this);
        stat.setOnClickListener(FirstSplash.this);
        mus.setOnCheckedChangeListener(FirstSplash.this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.stop();
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);

        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(music){
        mPlayer.start();
        mPlayer.setLooping(true);}
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
                break;/*
            case R.id.settings:
                intent =  new Intent(FirstSplash.this, SettingsActivity.class);
                startActivity(intent);
                break;
            <Button
        android:text="Settings"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:layout_alignParentEnd="true"
        android:id="@+id/settings" />*/

            case R.id.statBut:
                intent = new Intent(FirstSplash.this, StatActivity.class);
                startActivity(intent);
                break;
        }

    }
    static Boolean music = false;
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){

            music =true;
            mPlayer.start();
            mPlayer.setLooping(true);
        }else{
            music =false;
            mPlayer.stop();
            try {
                mPlayer.prepare();
                mPlayer.seekTo(0);

            }
            catch (Throwable t) {
                Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}


