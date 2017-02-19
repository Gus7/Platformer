package samsung.itschool.nick.platformer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstSplash extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_splash);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener( FirstSplash.this);
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(FirstSplash.this, MainActivity.class);
        startActivity(intent);
    }
}
