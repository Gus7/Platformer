package samsung.itschool.nick.platformer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import static samsung.itschool.nick.platformer.FirstSplash.mPlayer;
import static samsung.itschool.nick.platformer.FirstSplash.playing;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String[] numbers = new String[5];
        for (int i = 0; i < 5; i++){
            numbers[i] = (int)(i+1) + "";
        }

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new SuperAdapter(this, numbers));
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        }

    }
    @Override
    protected void onStart() {
        super.onStart();
        if (playing) {
            mPlayer.start();
        }
    }
}