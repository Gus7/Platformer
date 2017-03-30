package samsung.itschool.nick.platformer;

/**
 * Created by kolya on 21.02.2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by student2 on 07.02.17.
 */
public class SuperAdapter extends ArrayAdapter<String> {
    static int levelId;
    SuperAdapter(Context context, String[] array){
        super(context, R.layout.myitem, array);
        this.context = context;
    }
    Context context;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.myitem, null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.list_item);
        textView.setText(getItem(position));

        final int pos = position;
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity host = (Activity) context;
                host.finish();
                Intent intent = new Intent(host, MainActivity.class);
                host.startActivity(intent);
                levelId = (pos);
            }
        });
        return convertView;
    }
}