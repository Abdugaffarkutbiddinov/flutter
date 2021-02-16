package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private String[] names = new String[] {"Joshua","Matthew","Hebrew"};
    private SeekBar seek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list();
    }

    public void list() {
        list = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.names,names);
        list.setAdapter(adapter);
        seek = (SeekBar)findViewById(R.id.seekBar);
        list.setOnItemClickListener(
                (parent, view, position, id) -> {
                    String value = (String) list.getItemAtPosition(position);
                    Toast.makeText(
                            MainActivity.this, position + value + seek.getProgress(),
                            Toast.LENGTH_LONG
                    ).show();
                }
        );
    }
}