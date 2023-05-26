package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class word_title extends AppCompatActivity {

    TextView title;
    String stTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_title);
        this.setFinishOnTouchOutside(true);
        title = findViewById(R.id.main_word_info);
        stTitle = getIntent().getExtras().getString("Title");
        title.setText(stTitle);
    }
}