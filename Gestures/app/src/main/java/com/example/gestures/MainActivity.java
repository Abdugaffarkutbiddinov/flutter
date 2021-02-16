package com.example.gestures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {
    private ImageView kitty, doggy, cow;
    private MediaPlayer kittyTune, doggyTune,cowTune;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kitty = (ImageView)findViewById(R.id.kitty);
        doggy = (ImageView)findViewById(R.id.doggy);
        cow = (ImageView)findViewById(R.id.cow);

        kittyTune = MediaPlayer.create(this,R.raw.lion);
        doggyTune = MediaPlayer.create(this,R.raw.camel);
        cowTune = MediaPlayer.create(this,R.raw.cow);
        onClick();
    }

    public void onClick() {
        kitty.setOnClickListener(
                v -> {
                    Sound(kittyTune);
                }
        );

        doggy.setOnClickListener(
                v -> {
                    Sound(doggyTune);
                }
        );

        cow.setOnClickListener(
                v -> {
                        Sound(cowTune);
                }
        );
    }

    public void Sound(MediaPlayer sound) {
        sound.start();
    }

}