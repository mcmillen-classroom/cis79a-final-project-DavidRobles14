package davidrobles.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ActivityArrayAdapter extends ArrayAdapter<ActivityModel>
{

    public ActivityArrayAdapter(Context context, List<ActivityModel> objects)
    {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ActivityModel currentItem = getItem(position);

        if(convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_layout,parent,false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.row_title);
        TextView subtitle = (TextView) convertView.findViewById(R.id.row_sub_title);

        title.setText(currentItem.getName());
        subtitle.setText(currentItem.getProgress());

        return convertView;
    }

}
