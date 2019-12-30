package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LunchList extends TabActivity {


    RestaurantHelper helper;
    RestaurantAdapter adapter=null;
    Cursor curRestaurant =null;

    private Restaurant restaurant = new Restaurant();
    private List<Restaurant> listResaurant =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_list);

        helper = new RestaurantHelper(this);


        Button save = (Button)findViewById(R.id.save);
        //
        save.setOnClickListener(onSave);
        ListView list = (ListView)findViewById(R.id.restaurants);
        list.setOnItemClickListener(onListClick);


        curRestaurant = helper.getAll();
        startManagingCursor(curRestaurant);
        adapter = new RestaurantAdapter(this,curRestaurant,helper);
        list.setAdapter(adapter);

        //
        TabHost.TabSpec spec =getTabHost().newTabSpec("tag1");
        spec.setContent(R.id.restaurants);
        spec.setIndicator("List",getResources().getDrawable(R.drawable.hinh1));
        getTabHost().addTab(spec);
        spec = getTabHost().newTabSpec("tag2");
        spec.setContent(R.id.details);
        spec.setIndicator("Details",
                getResources().getDrawable(R.drawable.hinh2));
        getTabHost().addTab(spec);
        getTabHost().setCurrentTab(0);

       


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.close();
    }



    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           // Restaurant r = listResaurant.get(position); // lấy item được chọn

            curRestaurant.moveToPosition(position);
            EditText name;
            EditText address;
            RadioGroup types;
            // Tham chiếu đến các view trong details
            name = findViewById(R.id.name);
            address = findViewById(R.id.addr);
            types = findViewById(R.id.type);

           /* thiết lập thông tin tương ứng
            name.setText(r.getName());
            address.setText(r.getAddress());
            if (r.getType().equals("Sit down"))
                types.check(R.id.sit_down);
            else if (r.getType().equals("Take out"))
                types.check(R.id.take_out);
            else
                types.check(R.id.delivery);
                // sinh viên có thể bổ sung lệnh sau để chuyển view về tab details
                getTabHost().setCurrentTab(1);*/

           name.setText(helper.getName(curRestaurant));
            address.setText(helper.getAddress(curRestaurant));
            if (helper.getType(curRestaurant).equals("Sit down"))
                types.check(R.id.sit_down);
            else if (helper.getType(curRestaurant).equals("Take out"))
                types.check(R.id.take_out);
            else
                types.check(R.id.delivery);
            // chuyen qua tab detail
            getTabHost().setCurrentTab(1);
        }
    };

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

            listResaurant.add(restaurant);
            helper.insert(restaurant.getName(),restaurant.getAddress(),restaurant.getType());

            curRestaurant.requery();

        }
    };
   /* class RestaurantAdapter extends ArrayAdapter<Restaurant>{

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
    }*/

}
