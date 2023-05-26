package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class word_info extends AppCompatActivity {

    TextView title, details;
    String stTitle, stDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_word_details);
        this.setFinishOnTouchOutside(true);
        title = findViewById(R.id.word_title);
        details = findViewById(R.id.word_details);

        stTitle = getIntent().getExtras().getString("Title");
        stDetails = getIntent().getExtras().getString("Details");

        title.setText(stTitle);
        details.setText(stDetails);
    }
}