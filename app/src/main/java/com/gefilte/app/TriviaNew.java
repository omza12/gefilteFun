package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
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
    int score = 0, totalQuestions;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    Quiz quiz;

    private SoundPool soundPool;
    int shckoiech, oiVei, playSound;

    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_new);
        quiz = new Quiz();
        if (getIntent().getExtras().getInt("genre") == 1){
            setWeddingQuiz();
        }
        else
        {
            setCensorQuiz();
        }
        totalQuestions = quiz.getQuestions().length;
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(2)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }
        else {
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        }
        shckoiech = soundPool.load(this, R.raw.shckoiech, 1);
        oiVei = soundPool.load(this,R.raw.oi_vei, 1);

        loadNewQuestion();
    }

    private void setWeddingQuiz(){
        String[] weddingQuestions ={
                "מה פירוש המושג 'שומעת'?",
                "מה פירוש המושג 'משמחים'?",
                "מה פירוש המושג 'זו\"צ'",
                "מה פירוש המושג 'פקק'?",
                "מה פירוש המושג 'ווארט'?"
        };
        String[][] weddingChoices ={
                {"כינוי לפסיכולוגית חרדית","ג.מאזינה לרכילות לשון הרע","שומעת שירים כשרים","פתוחה להצעות שידוכין"},
                {"מגיעים רק לריקודים בחתונה","קהל בהילולת ל\"ג בעומר","רוקדי נח נחמן בצמתים","אחראים להשקות את כולם בשושן פורים"},
                {"זוג צעיר","זמיר צנוע","זכות לצניעות","זיכרון וצניעות"},
                {"כינוי צנוע לטמפון","אטמי אוזניים למניעת שמיעת שמירת נשים","הבכור/ה טרם התחתנ/ה לכן כל האחים לא יכולים עדיין להתחתן","יין המתאים לקידוש בשלושת הרגלים"},
                {"סט כלים לפסח","טקס אירוסין וחלוקת תשלומים","כינוי לחרדי שגר בחו\"ל","יישומן שליחויות למסעדות כשרות בלבד"}
        };
        String[] weddingCorrectAnswers ={
                "פתוחה להצעות שידוכין",
                "מגיעים רק לריקודים בחתונה",
                "זוג צעיר",
                "הבכור/ה טרם התחתנ/ה לכן כל האחים לא יכולים עדיין להתחתן",
                "טקס אירוסין וחלוקת תשלומים"
        };

        quiz.setQuestions(weddingQuestions);
        quiz.setChoices(weddingChoices);
        quiz.setCorrectAnswers(weddingCorrectAnswers);
    }

    private void setCensorQuiz() {
        String[] censorQuestions ={
                "מה פירוש המושג 'אישה במצב'?",
                "מה פירוש המילה 'אוחז'?",
                "מה פירוש המושג 'צ'ונט'?",
                "מה פירוש המושג 'נייעס'?",
                "מה פירוש המושג 'שייגעצ'?"
        };


        String[][] censorChoices = {
                {"אישה בהריון", "אישה בנידה", "מתפללת מחוץ לעזרת נשים", "נערה שסיימה את לימודיה ב'אולפנה'"},
                {"מבין/קולט", "כינוי למטלטל לולב בסוכות", "סוחב ספר התורה בבית הכנסת", "משלם החתונה (האוחז בכספים)"},
                {"מאכל שקרוי גם חמין", "מברכים", "מרכלים", "הכשר למסעדות בחו\"ל"},
                {"אדם נחמד (Nice)", "נראה יהודי אך יהדותו עומדת בספק", "אדם שמאזין ומעביר חדשות", "תשע-עשרה (מספר טיפולוגי)"},
                {"איש מבולבל","גוי, עובר עבירה","צורת זכר של 'שיקסע'","שלא ידע געגוע וצער"}
        };

        String[] censorCorrectAnswers ={
                "אישה בהריון",
                "מבין/קולט",
                "מרכלים",
                "אדם שמאזין ומעביר חדשות",
                "גוי, עובר עבירה",
        };

        quiz.setQuestions(censorQuestions);
        quiz.setChoices(censorChoices);
        quiz.setCorrectAnswers(censorCorrectAnswers);
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
            if (selectedAnswer.equals(quiz.getCorrectAnswers()[currentQuestionIndex])){
                score++;
                mDialog.setContentView(R.layout.correctpopup);
                playSound = shckoiech;
            }
            else{
                mDialog.setContentView(R.layout.wrongpopup);
                playSound = oiVei;
            }
            mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            showDialog(mDialog);
            currentQuestionIndex++;
            if (currentQuestionIndex < totalQuestions){
                soundPool.play(playSound,1,1,0,0,1);
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
        questionTextView.setText(quiz.getQuestions()[currentQuestionIndex]);
        ansA.setText(quiz.getChoices()[currentQuestionIndex][0]);
        ansB.setText(quiz.getChoices()[currentQuestionIndex][1]);
        ansC.setText(quiz.getChoices()[currentQuestionIndex][2]);
        ansD.setText(quiz.getChoices()[currentQuestionIndex][3]);
    }

    protected void showDialog(Dialog dlg){
        dlg.show();
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                dlg.dismiss(); // when the task active then close the dialog
                t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
            }
        }, 1600);
    }

    void finishQuiz(){
        String passStatus;
        if (score >= totalQuestions*0.6){
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}