package samsung.itschool.nick.platformer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

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

}
