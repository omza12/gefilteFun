package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FillInTheBlank extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, back;
    TextView blankText;
    FillInTheBlankItems fillItems;
    int totalQuestions;
    int currentAnswerIndex = 0;
    String selectedAnswer = "", text, finalText;

    SpannableString ss1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in_the_blank);

        fillItems = new FillInTheBlankItems();
        btn1 = findViewById(R.id.word_1);
        btn2 = findViewById(R.id.word_2);
        btn3 = findViewById(R.id.word_3);
        btn4 = findViewById(R.id.word_4);
        btn5 = findViewById(R.id.word_5);
        btn6 = findViewById(R.id.word_6);
        btn7 = findViewById(R.id.word_7);
        btn8 = findViewById(R.id.word_8);
        btn9 = findViewById(R.id.word_9);
        btn10 = findViewById(R.id.word_10);
        back = findViewById(R.id.back);
        blankText = findViewById(R.id.blank_text);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        back.setOnClickListener(this);

        if (getIntent().getExtras().getInt("genre") == 1) {
            blankText.setText(getString(R.string.workplace_blank_text));
            setWorkplaceWords();
        } else {
            blankText.setText(getString(R.string.prairs_blank_text));
            setPrairsWords();
        }

        loadWords();
    }

    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;
        selectedAnswer = clickedButton.getText().toString();
        if (clickedButton.getId() != R.id.back) {
            if (selectedAnswer.equals(fillItems.getAnswers()[currentAnswerIndex])) {
                clickedButton.setClickable(false);
                clickedButton.setBackgroundColor(Color.GREEN);
                clickedButton.setTextColor(Color.BLACK);
                text = blankText.getText().toString();
                finalText = text.replaceFirst("__________", selectedAnswer);

                ss1 = new SpannableString(finalText);

                int answerPosition = finalText.indexOf(selectedAnswer);

                ss1.setSpan(new ForegroundColorSpan(Color.GREEN), answerPosition, answerPosition + selectedAnswer.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                blankText.setText(ss1);
                currentAnswerIndex++;

                if (currentAnswerIndex < totalQuestions) {
                    colorizeLines();
                } else {
                    finishGame();
                }
            } else {
                Toast.makeText(this, "גוועלד! נסו שוב", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Intent back = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(back);
        }
    }

    private void loadWords() {
        btn1.setText(fillItems.getChoices()[0]);
        btn2.setText(fillItems.getChoices()[1]);
        btn3.setText(fillItems.getChoices()[2]);
        btn4.setText(fillItems.getChoices()[3]);
        btn5.setText(fillItems.getChoices()[4]);
        btn6.setText(fillItems.getChoices()[5]);
        btn7.setText(fillItems.getChoices()[6]);
        btn8.setText(fillItems.getChoices()[7]);
        btn9.setText(fillItems.getChoices()[8]);
        btn10.setText(fillItems.getChoices()[9]);

        colorizeLines();
    }

    private void colorizeLines() {
        String text = blankText.getText().toString();
        SpannableString ss = new SpannableString(text);

        ForegroundColorSpan fcsRed = new ForegroundColorSpan(getResources().getColor(R.color.highlight));

        int charPosition = text.indexOf('_');
        ss.setSpan(fcsRed, charPosition, charPosition + 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        blankText.setText(ss);
    }


    private void setWorkplaceWords() {
        String[] answers = {getString(R.string.goi_title), getString(R.string.fastnisht_title), getString(R.string.achmal_title),
                getString(R.string.vadal_title), "ציוייני", getString(R.string.angry_title)};

        String[] choices = {getString(R.string.goi_title), getString(R.string.fastnisht_title), getString(R.string.achmal_title),
                getString(R.string.vadal_title), "ציוייני", getString(R.string.angry_title),
                getString(R.string.zatzal_title), getString(R.string.hold_title), getString(R.string.news_title), getString(R.string.modest_title)};

        fillItems.setAnswers(answers);
        fillItems.setChoices(shuffleWords(choices));
        totalQuestions = fillItems.getAnswers().length;
    }

    private void setPrairsWords() {
        String[] answers = {getString(R.string.zatzal_title), getString(R.string.water_title), getString(R.string.food_title),
                getString(R.string.last_title), getString(R.string.shahrit_title), getString(R.string.arvit_title)};

        String[] choices = {getString(R.string.zatzal_title), getString(R.string.water_title), getString(R.string.food_title),
                getString(R.string.last_title), getString(R.string.shahrit_title), getString(R.string.arvit_title),
                getString(R.string.eastern_title), getString(R.string.queen_title), getString(R.string.hundred_title), getString(R.string.minha_title)};

        fillItems.setAnswers(answers);
        fillItems.setChoices(shuffleWords(choices));
        totalQuestions = fillItems.getAnswers().length;
    }

    private void finishGame() {
        btn1.setClickable(false);
        btn2.setClickable(false);
        btn3.setClickable(false);
        btn4.setClickable(false);
        btn5.setClickable(false);
        btn6.setClickable(false);
        btn7.setClickable(false);
        btn8.setClickable(false);
        btn9.setClickable(false);
        btn10.setClickable(false);
        Intent intent = new Intent(getApplicationContext(), FillResult.class);
        String result, details;
        result = "אשרייך!";
        details = "סיימת את המשחק בהצלחה!";
        intent.putExtra("result", result);
        intent.putExtra("details", details);
        startActivity(intent);
        back.setVisibility(View.VISIBLE);
        back.setClickable(true);
    }

    private String[] shuffleWords(String[] choices) {
        List<String> choicesList = Arrays.asList(choices);
        Collections.shuffle(choicesList);
        choicesList.toArray(choices);

        return choices;
    }
}