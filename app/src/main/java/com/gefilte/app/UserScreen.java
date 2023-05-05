package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class UserScreen extends AppCompatActivity {

    Button triviaBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);

        triviaBtn = findViewById(R.id.trivia_btn);
        triviaBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Trivia.class);
            startActivity(intent);
        });
    }
}