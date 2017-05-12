package samsung.itschool.nick.platformer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static samsung.itschool.nick.platformer.FirstSplashDraw.height;
import static samsung.itschool.nick.platformer.FirstSplashDraw.width;
import static samsung.itschool.nick.platformer.Hero.pos;
import static samsung.itschool.nick.platformer.MyDraw.bullet;
import static samsung.itschool.nick.platformer.MyDraw.bulletpic;
import static samsung.itschool.nick.platformer.MyDraw.side;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    static TextView mobs;
    static TextView rubies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Up = (Button) findViewById(R.id.up);
        Button Down = (Button) findViewById(R.id.down);
        Button Left = (Button) findViewById(R.id.left);
        Button Right = (Button) findViewById(R.id.right);
        Button Fire = (Button) findViewById(R.id.fire);

        mobs = (TextView) findViewById(R.id.mobs);
        rubies = (TextView) findViewById(R.id.rubies);


        Up.setOnTouchListener(new UpListener());
        Down.setOnTouchListener(new DownListener());
        Left.setOnTouchListener(new LeftListener());
        Right.setOnTouchListener(new RightListener());
        Fire.setOnClickListener((View.OnClickListener) this);



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        bullet.clear();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a.txt title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    static int fire = 0;
    @Override
    public void onClick(View v) {

        if (side == 4){
            fire = -1;
            bullet.add(new Bullet(pos.x-20*width/1920, pos.y-50*height/1080, -1, bulletpic));
        }
        else {
            fire = 1;
            bullet.add(new Bullet(pos.x+40*width/1920, pos.y-50*height/1080, 1, bulletpic));
        }

    }
}
