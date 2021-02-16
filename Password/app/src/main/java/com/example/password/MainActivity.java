package com.example.password;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private Button button;
    private EditText password;
    private EditText email;

    private static final String EMAIL_TXT = "abdugaffarkutbiddinov@gmail.com";
    private static final String PASSWORD_TXT = "bobojon";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create();
    }

    public void create() {
        image  = (ImageView)findViewById(R.id.imageView2);
        button = (Button)findViewById(R.id.button);
        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);

        button.setOnClickListener(
                v -> {
                    if(EMAIL_TXT.equals(String.valueOf(email.getText())) && PASSWORD_TXT.equals(String.valueOf(password.getText()))) {
                        image.setImageResource(R.drawable.unnamed);
                    }
                    else
                        image.setImageResource(R.drawable.top);
                }
        );

    }
}