package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class PrairInfo extends AppCompatActivity {

    TextView details;
    String stDetails, videoPath;

    VideoView videoView;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_prair_info);
        this.setFinishOnTouchOutside(true);

        details = findViewById(R.id.word_details);
        videoView = findViewById(R.id.bua_vid);
        videoPath = "android.resource://" + getPackageName() + "/" + R.raw.bua;
        uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause();
            }
            else{
                videoView.start();
            }
        });

        stDetails = getIntent().getExtras().getString("Title");

        details.setText(stDetails);
        details.setMovementMethod(new ScrollingMovementMethod());
    }
}