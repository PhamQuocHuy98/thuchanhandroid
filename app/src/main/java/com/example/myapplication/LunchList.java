package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LunchList extends AppCompatActivity {

    private Restaurant restaurant = new Restaurant();
    private List<Restaurant> listResaurant =new ArrayList<>();
    private RestaurantAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_list);

        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(onSave);


    }
    void updateListView(){
        ListView list = findViewById(R.id.restaurants);
        adapter = new RestaurantAdapter();
        //adapter = new ArrayAdapter<Restaurant>(this,android.R.layout.simple_list_item_1,listResaurant);
        list.setAdapter(adapter);
    }
    private View.OnClickListener onSave = new View.OnClickListener() {

        public void onClick(View v) {
            EditText name = (EditText)findViewById(R.id.name);
            EditText address = (EditText)findViewById(R.id.addr);
            restaurant = new Restaurant();
            restaurant.setName(name.getText().toString());
            restaurant.setAddress(address.getText().toString());
            RadioGroup type = (RadioGroup)findViewById(R.id.type);
            switch (type.getCheckedRadioButtonId())
            {
                case R.id.take_out:
                    restaurant.setType("Take out");
                    break;
                case R.id.sit_down:
                    restaurant.setType("Sit down");
                    break;
                case R.id.delivery:
                    restaurant.setType("Delivery");
                    break;

            }

            Toast.makeText(v.getContext(),String.valueOf( listResaurant.size()), Toast.LENGTH_LONG).show();
            listResaurant.add(restaurant);

            updateListView();
        }
    };
    class RestaurantAdapter extends ArrayAdapter<Restaurant>{

        public RestaurantAdapter(@NonNull Context context, int resource) {
            super(context, resource);
        }

        public RestaurantAdapter(){
            super(LunchList.this,android.R.layout.simple_list_item_1,listResaurant);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row =convertView;
            if (row==null){
                LayoutInflater inflater =getLayoutInflater();
                row =inflater.inflate(R.layout.custom_listview_item,null);
            }
            Restaurant r = listResaurant.get(position);

            TextView textView1 =(TextView) row.findViewById(R.id.title);
            TextView textView2=(TextView) row.findViewById(R.id.address);
            ImageView icon =(ImageView) row.findViewById(R.id.icon);

            textView1.setText(r.getName());
            textView2.setText(r.getAddress());
            String type = r.getType();
            if(type.equals("Take out")){
                icon.setImageResource(R.drawable.hinh1);
            }else if(type.equals("Sit down")){
                icon.setImageResource(R.drawable.hinh2);
            }else icon.setImageResource(R.drawable.hinh3);
            return  row;
        }
    }
}
