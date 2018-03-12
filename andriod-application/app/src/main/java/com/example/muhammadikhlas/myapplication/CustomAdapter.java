package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Muhammad IKHLAS on 12/24/2017.
 */
public class CustomAdapter extends BaseAdapter {

    public Context context;
    public  List<MoviePojo> rowItems;

    public CustomAdapter(Context context, List<MoviePojo> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    /* private view holder class */
    private class ViewHolder {
        TextView names;
        TextView tags;
        TextView ratings;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.names = (TextView) convertView
                    .findViewById(R.id.moviename);
            holder.tags = (TextView) convertView.findViewById(R.id.tagline);
            holder.ratings = (TextView) convertView
                    .findViewById(R.id.rating);
            MoviePojo row_pos = rowItems.get(position);
            holder.names.setText(row_pos.getname());
            holder.tags.setText(row_pos.gettagline());
            holder.ratings.setText(row_pos.getrating());
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
