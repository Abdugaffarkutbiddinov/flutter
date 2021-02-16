package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClick();
    }

    public void onButtonClick() {
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView result = (TextView) findViewById(R.id.result);


        Button button1 = (Button) findViewById(R.id.sum);
        Button button2 = (Button) findViewById(R.id.subtract);

        button1.setOnClickListener(
                v -> {
                    int number1 = Integer.parseInt(num1.getText().toString());
                    int number2 = Integer.parseInt(num2.getText().toString());
                    int resultText = number1 + number2;
                    result.setText(Integer.toString(resultText));
                    Toast.makeText(this, "sum", Toast.LENGTH_SHORT).show();
                }
        );
        button2.setOnClickListener(
                v -> {
                    Toast.makeText(this, "subtract", Toast.LENGTH_SHORT).show();
                    int number1 = Integer.parseInt(num1.getText().toString());
                    int number2 = Integer.parseInt(num2.getText().toString());
                    int resultText = number1 - number2;
                    result.setText(Integer.toString(resultText));
                }
        );


    }




}