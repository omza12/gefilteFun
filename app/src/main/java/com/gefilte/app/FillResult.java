package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class FillResult extends AppCompatActivity {

    TextView result, details;
    String stResult,stDetails,stBtn;
    int genre;
    GifImageView gefilteGif;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_result);
        this.setFinishOnTouchOutside(true);

        result = findViewById(R.id.trivia_result_title);
        details = findViewById(R.id.trivia_result_details);
        gefilteGif = findViewById(R.id.gif);

        stResult = getIntent().getExtras().getString("result");
        stDetails = getIntent().getExtras().getString("details");
        stBtn = getIntent().getExtras().getString("button");
        genre = getIntent().getExtras().getInt("genre");

        result.setText(stResult);
        details.setText(stDetails);

        if (stResult.equals("אשרייך!")){
            if (player == null){
                player = MediaPlayer.create(this,R.raw.chiribim);
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopPlayer();
                    }
                });
            }
            player.start();
        }

        else {
            gefilteGif.setImageResource(R.drawable.wrong);
        }
    }


    private void stopPlayer(){
        if (player != null){
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}