package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class UserScreen extends AppCompatActivity {

    Button triviaBtn,vocabBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);

        triviaBtn = findViewById(R.id.trivia_btn);
        vocabBtn = findViewById(R.id.vocabulary);
        triviaBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Trivia.class);
            startActivity(intent);
        });
        vocabBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), VocabularyMain.class);
            startActivity(intent);
        });
    }
}