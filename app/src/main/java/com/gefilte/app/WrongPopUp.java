package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class WrongPopUp extends AppCompatActivity {

    TextView correctAnswer;
    String stCorrectAnswer;
    MediaPlayer player;

    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_pop_up);
        this.setFinishOnTouchOutside(true);

        correctAnswer = findViewById(R.id.correct_answer);

        stCorrectAnswer = getIntent().getExtras().getString("answer");

        correctAnswer.setText(stCorrectAnswer);

        if (player == null) {
            player = MediaPlayer.create(this, R.raw.oi_vei);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 3000);
    }

    private void stopPlayer() {
        if (player != null) {
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