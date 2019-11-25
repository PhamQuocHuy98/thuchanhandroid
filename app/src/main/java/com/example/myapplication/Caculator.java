package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Caculator extends AppCompatActivity {

    EditText num1;
    EditText num2;
    Spinner option;
    Button btnCalc;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculator);

        btnCalc = findViewById(R.id.calc);

        num1= findViewById(R.id.num1);

        num2= findViewById(R.id.num2);

        option = findViewById(R.id.spinner1);

        result = findViewById(R.id.result);

        btnCalc.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                int res =0;
                try{
                    int number1 = Integer.parseInt(num1.getText().toString());
                    int number2 = Integer.parseInt(num2.getText().toString());
                    String text = option.getSelectedItem().toString();

                    if(text.equals("Cộng")){
                        res =  Cong(number1,number2);
                    }
                    else if(text.equals("Trừ")){
                        res =  Tru(number1,number2);
                    }
                    else if(text.equals("Nhân")){
                        res =  Nhan(number1,number2);
                    }
                    else if(text.equals("Chia")){
                        res =  Chia(number1,number2);
                    }

                   // Toast.makeText(getApplicationContext(),String.valueOf(res),Toast.LENGTH_LONG).show();
                    result.setText(String.valueOf(res));

                }catch (Exception e){

                }


            }

        });



    }
    int Cong(int a , int b){
        return a+b;
    }
    int Tru(int a , int b){
        return a-b;
    }
    int Nhan(int a , int b){
        return a*b;
    }
    int Chia(int a , int b){
        return a/b;
    }
}
