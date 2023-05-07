package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.gefilte.app.R;

public class VocabularyMain extends AppCompatActivity {

    Button weddingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        weddingBtn = findViewById(R.id.wedding_btn);
        weddingBtn.setOnClickListener(v -> {
                    Intent intent = new Intent(getApplicationContext(), WeddingWords.class);
                    startActivity(intent);
                }
        );
    }
}