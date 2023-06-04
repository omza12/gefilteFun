package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import android.widget.TextView;

public class word_info extends AppCompatActivity {

    TextView details;
    String stDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.word_info_popup);
        this.setFinishOnTouchOutside(true);
        details = findViewById(R.id.word_details);

        stDetails = getIntent().getExtras().getString("Title");

        details.setText(stDetails);
        details.setMovementMethod(new ScrollingMovementMethod());
    }
}