package samsung.itschool.nick.platformer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;




public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String[] numbers = new String[3];
        for (int i = 0; i < 3; i++){
            numbers[i] = (int)(i+1) + "";
        }

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new SuperAdapter(this, numbers));
    }
}