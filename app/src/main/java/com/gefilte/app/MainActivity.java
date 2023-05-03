package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button register_btn,login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        login_btn = findViewById(R.id.login);
        register_btn = findViewById(R.id.register);
        login_btn.setOnClickListener(v -> {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        );

        register_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
            }
        );
    }
}