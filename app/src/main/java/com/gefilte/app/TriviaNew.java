package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class TriviaNew extends AppCompatActivity implements View.OnClickListener {

    TextView questionTextView;
    Button ansA,ansB,ansC,ansD,submit;

    Dialog mDialog;
    int score =0, totalQuestions = Quiz.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_new);

        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        ansC = findViewById(R.id.ans_c);
        ansD = findViewById(R.id.ans_d);
        submit = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submit.setOnClickListener(this);

        loadNewQuestion();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onClick(View v) {
        ansA.setBackground(ansA.getContext().getDrawable(R.drawable.answer_button));
        ansB.setBackground(ansB.getContext().getDrawable(R.drawable.answer_button));
        ansC.setBackground(ansC.getContext().getDrawable(R.drawable.answer_button));
        ansD.setBackground(ansD.getContext().getDrawable(R.drawable.answer_button));
        mDialog = new Dialog(this);
        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn){
            if (selectedAnswer.equals(Quiz.correctAnswers[currentQuestionIndex])){
                score++;
                mDialog.setContentView(R.layout.correctpopup);
            }
            else{
                mDialog.setContentView(R.layout.wrongpopup);

            }
            mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            showDialog(mDialog);
            currentQuestionIndex++;
            if (currentQuestionIndex < totalQuestions){
                loadNewQuestion();
            }
            else{
                finishQuiz();
            }
        }
        else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackground(clickedButton.getContext().getDrawable(R.drawable.selected_answer_button));
            submit.setBackground(clickedButton.getContext().getDrawable(R.drawable.default_button));
        }
    }

    void loadNewQuestion(){
        if (currentQuestionIndex == totalQuestions){
            finishQuiz();
            return;
        }
        questionTextView.setText(Quiz.question[currentQuestionIndex]);
        ansA.setText(Quiz.choices[currentQuestionIndex][0]);
        ansB.setText(Quiz.choices[currentQuestionIndex][1]);
        ansC.setText(Quiz.choices[currentQuestionIndex][2]);
        ansD.setText(Quiz.choices[currentQuestionIndex][3]);
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

    void finishQuiz(){
        String passStatus;
        if (score > totalQuestions*0.6){
            passStatus = "כל הכבוד!";
        }
        else {
            passStatus = "לא נורא...";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                //.setMessage("Score is " + score + " out of " + totalQuestions)
                .setMessage("צדקת ב - " + score + " מתוך " + totalQuestions + " שאלות")
                .setPositiveButton("חזרה",(dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show()
                .getWindow()
                .getDecorView()
                .setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}