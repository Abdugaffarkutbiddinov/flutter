package com.example.lesson5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText password;
    private Button button;
    private Button button2;
    private RatingBar rating;
    private Button activity;
    private TextView view;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void addListenerOnButton() {
        password = (EditText)findViewById(R.id.password);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.alert);
        activity = (Button)findViewById(R.id.activity);
        button.setOnClickListener(
                v -> {
                    button.setText("BUldi");
                    button.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    Toast.makeText(
                            MainActivity.this,password.getText(),Toast.LENGTH_LONG).show();
                }
        );

        activity.setOnClickListener(
                v -> {
                    Intent intent = new Intent(".newActivity");
                    startActivity(intent);
                }
        );

        rating = (RatingBar)findViewById(R.id.ratingBar);
        view  = (TextView)findViewById(R.id.textView);

        rating.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> view.setText(String.valueOf(rating)));

        button2.setOnClickListener(
                v -> {

                    button.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                    Toast.makeText(
                            MainActivity.this,"Honaba raftem",Toast.LENGTH_LONG).show();
                    AlertDialog.Builder  builder = new AlertDialog.Builder(this);
                    builder.setMessage("You wan to close your app?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialog, which) -> finish())
                      .setNegativeButton("No", (dialog, which) -> dialog.cancel());
                    AlertDialog alert = builder.create();
                    alert.setTitle("closing the app");
                    alert.show();
                }
        );
    }

}