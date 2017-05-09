package samsung.itschool.nick.platformer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kolya on 05.05.2017.
 */

public class ResultAdapter extends BaseAdapter {

    ArrayList<Result> results;
    Context context;
    ResultAdapter(Context context, ArrayList results){
        this.context = context;
        this.results = results;
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout, null);
        }
        ((TextView) convertView.findViewById(R.id.level)).setText(results.get(position).l + " ");
        ((TextView) convertView.findViewById(R.id.mob)).setText(results.get(position).m + " ");
        ((TextView) convertView.findViewById(R.id.ruby)).setText(results.get(position).r + " ");
        return convertView;
    }
}
