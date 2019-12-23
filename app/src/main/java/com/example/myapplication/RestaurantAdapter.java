package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class RestaurantAdapter extends CursorAdapter {

    private Context context;
    private  RestaurantHelper helper;
    RestaurantAdapter(Context context,Cursor c,RestaurantHelper helper) {
        super(context,c);
        this.context=context;
        this.helper=helper;
    }

      /* public RestaurantAdapter(Context context, Cursor c) {
           super(context, c);
       }*/


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.custom_listview_item, parent, false);
        return row;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        View row = view;
        ((TextView)row.findViewById(R.id.title)).setText(helper.getName(cursor));
        ((TextView)row.findViewById(R.id.address)).setText(helper.getAddress(cursor));
        ImageView icon = (ImageView)row.findViewById(R.id.icon);
        String type = helper.getType(cursor);
        if (type.equals("Take out"))
            icon.setImageResource(R.drawable.hinh1);
        else if (type.equals("Sit down"))
            icon.setImageResource(R.drawable.hinh2);
        else
            icon.setImageResource(R.drawable.hinh3);
    }

}
