package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeccondActivity extends AppCompatActivity {


    Button btnShowMe;
    EditText textControllerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccond);

        btnShowMe = findViewById(R.id.btnShowMe);
        textControllerName= findViewById(R.id.textControllerName);

        btnShowMe.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),textControllerName.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
