package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Option extends AppCompatActivity {

    private  int index1=0,index2=0,index3=0;
    String fontSize;
    Button btn;
    EditText txtFontSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        btn = findViewById(R.id.button1);
        Spinner spinner1 =(Spinner) findViewById(R.id.spinner1);
       spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               index1=position;
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        Spinner spinner2 =(Spinner)findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                index2=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner3 =(Spinner)findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                index3=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void onOk(View view){
        txtFontSize=findViewById(R.id.txtFontsize);
        fontSize=txtFontSize.getText().toString();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        bundle.putInt("ForeColor",index1);
        bundle.putInt("BackColor",index2);
        bundle.putInt("FontSize",index3);
        bundle.putString("TxtFontSize",fontSize);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }



}
