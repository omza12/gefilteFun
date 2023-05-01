package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    Button correctButton,wrongButton1, wrongButton2, wrongButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        correctButton = findViewById(R.id.secondAnswer);
        correctButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"אוי ויי!",Toast.LENGTH_SHORT).show();
            }
        });
        wrongButton1 = findViewById(R.id.firstAnswer);
        wrongButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"שכוייח!",Toast.LENGTH_SHORT).show();
            }
        });
        wrongButton2 = findViewById(R.id.thirdAnswer);
        wrongButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"אוי ויי!",Toast.LENGTH_SHORT).show();
            }
        });
        wrongButton3 = findViewById(R.id.fourthAnswer);
        wrongButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"אוי ויי!",Toast.LENGTH_LONG).show();
            }
        });
    }
}