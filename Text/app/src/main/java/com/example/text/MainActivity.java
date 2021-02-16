package com.example.text;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private TextView outText;
    private EditText inText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outText = (TextView)findViewById(R.id.outnput);
        inText = (EditText)findViewById(R.id.input);
    }

    public void write(View view) throws IOException {
        FileInputStream fileInput = openFileInput("example.txt");
        InputStreamReader reader = new InputStreamReader(fileInput);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer stringBuffer = new StringBuffer();
        String lines;
        while((lines = bufferedReader.readLine()) != null) {
            stringBuffer.append(lines + "\n");
        }
        outText.setText(stringBuffer);
    }

    public void read(View view) throws IOException {
        String txt = inText.getText().toString();
        FileOutputStream fileOutput = openFileOutput("example.txt",MODE_PRIVATE);
        fileOutput.write(txt.getBytes());
        fileOutput.close();
        inText.setText("");
        Toast.makeText(this,"saved",Toast.LENGTH_LONG).show();

    }
}