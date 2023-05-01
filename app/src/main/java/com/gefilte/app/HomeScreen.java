package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class HomeScreen extends AppCompatActivity {

    Button correctButton,wrongButton1, wrongButton2, wrongButton3;
    Dialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        correctButton = (Button)findViewById(R.id.firstAnswer);
        wrongButton1 = (Button)findViewById(R.id.secondAnswer);
        wrongButton2 = (Button)findViewById(R.id.thirdAnswer);
        wrongButton3 = (Button)findViewById(R.id.fourthAnswer);
        mDialog = new Dialog(this);

        correctButton.setOnClickListener(v -> {
                mDialog.setContentView(R.layout.correctpopup);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                showDialog(mDialog);
        });

        wrongButton1.setOnClickListener(v -> {
                mDialog.setContentView(R.layout.wrongpopup);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                showDialog(mDialog);
        });

        wrongButton2.setOnClickListener(v -> {
                mDialog.setContentView(R.layout.wrongpopup);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                showDialog(mDialog);
        });
        wrongButton3.setOnClickListener(v -> {
                mDialog.setContentView(R.layout.wrongpopup);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                showDialog(mDialog);
        });
    }

    protected void showDialog(Dialog dlg){
        dlg.show();
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                dlg.dismiss(); // when the task active then close the dialog
                t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
            }
        }, 1300);
    }
}