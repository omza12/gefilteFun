package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button weddingBtn, censorBtn, prairBtn, dosAndDontsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weddingBtn = findViewById(R.id.wedding_btn);
        censorBtn = findViewById(R.id.censorship_btn);
        prairBtn = findViewById(R.id.prairs_btn);
        dosAndDontsBtn = findViewById(R.id.dos_and_donts_btn);


        weddingBtn.setOnClickListener(v -> {
                    Intent intent = new Intent(getApplicationContext(), LearningWords.class);
                    intent.putExtra("genre",weddingBtn.getText());
                    startActivity(intent);
                }
        );
        censorBtn.setOnClickListener(v -> {
                    Intent intent = new Intent(getApplicationContext(), LearningWords.class);
                    intent.putExtra("genre",censorBtn.getText());
                    startActivity(intent);
                }
        );
        prairBtn.setOnClickListener(v -> {
                    Intent intent = new Intent(getApplicationContext(), LearningWords.class);
                    intent.putExtra("genre",prairBtn.getText());
                    startActivity(intent);
                }
        );
        dosAndDontsBtn.setOnClickListener(v -> {
                    Intent intent = new Intent(getApplicationContext(), LearningWords.class);
                    intent.putExtra("genre",dosAndDontsBtn.getText());
                    startActivity(intent);
                }
        );
    }
}