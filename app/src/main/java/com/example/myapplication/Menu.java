package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         switch (item.getItemId()){
             case R.id.clear:
                 handleClear();

             break;
             case R.id.exit:
                 handleExit();
             break;
             case R.id.setting:
                 handleSetting();
             break;
         }
         return true;
    }
    void handleClear(){
        AlertDialog.Builder message = new AlertDialog.Builder(this);
        message.setTitle("Message_caption");
        message.setMessage("Message_content");
        message.setNeutralButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText et = findViewById(R.id.editText1);
                et.setText("");
            }
        }).show();
    }
    void handleExit(){
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Thoat ung dung?")
                .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return ;
            }
        }).show();
    }

    void handleSetting(){
        Intent intent = new Intent(this,Option.class);
        final int result=1;
        startActivityForResult(intent,result);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();
        int index1= bundle.getInt("ForeColor");
        int index2= bundle.getInt("BackColor");
        int index3 =bundle.getInt("FontSize");
        String fontSize =bundle.getString("TxtFontSize");
        String colorArray[]= getResources().getStringArray(R.array.color_array);
        String sizeArray[]= getResources().getStringArray(R.array.size_array);
        EditText et = findViewById(R.id.editText1);

        et.setTextColor(Color.parseColor(colorArray[index1]));
        et.setBackgroundColor(Color.parseColor(colorArray[index2]));
        et.setTextSize(Integer.valueOf(sizeArray[index3]));
        et.setTextSize(Integer.valueOf(fontSize));

    }

}
