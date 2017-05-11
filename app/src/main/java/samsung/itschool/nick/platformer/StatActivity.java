package samsung.itschool.nick.platformer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import static samsung.itschool.nick.platformer.FirstSplash.mPlayer;
import static samsung.itschool.nick.platformer.FirstSplash.playing;

public class StatActivity extends AppCompatActivity {
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        dbManager = DBManager.getInstance(this);

        ListView resList = (ListView) this.findViewById(R.id.results);
        ArrayList<Result> results = dbManager.getAllResults();
        Collections.reverse(results);
        ResultAdapter adapter = new ResultAdapter(this,results);
        resList.setAdapter(adapter);
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
