package samsung.itschool.nick.platformer;

/**
 * Created by kolya on 21.02.2017.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by student2 on 07.02.17.
 */
public class SuperAdapter extends ArrayAdapter<String> {
    SuperAdapter(Context context, String[] array){
        super(context, R.layout.activity_menu, array);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_menu, null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.list_item);
        textView.setText(getItem(position));
        textView.setBackgroundColor(Color.rgb(3,3,3));
        final int pos = position;
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(),getItem(pos),Toast.LENGTH_LONG);
                toast.show();
            }
        });
        return convertView;
    }
}