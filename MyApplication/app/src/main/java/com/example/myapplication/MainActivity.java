package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    }
    public void launchSettings(View v) {
        Intent i = new Intent(this,SettingsActivity.class);
        String message = ((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
        i.putExtra("cool",message);
        startActivity(i);
    }


    
}