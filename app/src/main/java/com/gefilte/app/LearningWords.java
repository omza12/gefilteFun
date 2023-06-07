package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class LearningWords extends AppCompatActivity implements SelectListener{

    String genre;
    Button gameBtn, infoBtn;
    MediaPlayer player;
    private SoundPool soundPool;
    int yedish,anger,eastern,queen,minha, niece,gossip,zionist,goi,shckoiech;
    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_words);
        RecyclerView recyclerView = findViewById(R.id.main_recycle_view);
        infoBtn = findViewById(R.id.info_button);
        gameBtn = findViewById(R.id.game_btn);
        List<WordItem> items = new ArrayList<>();
        genre = getIntent().getExtras().getString("genre");
        Intent intent = new Intent(LearningWords.this,word_info.class);
        if (genre.equals("חתונות")){
            setWeddingWords(items);
        }
        if (genre.equals("צנזורה")){
            setCensorWords(items);
        }
        if (genre.equals("עבודה")){
            setWorkplaceWords(items);
        }
        if (genre.equals("תפילות")){
            setPrairsWords(items);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items, this));

        infoBtn.setOnClickListener(v -> {
            if (genre.equals("חתונות")){
                intent.putExtra("Title",getString(R.string.wedding_info));
                startActivity(intent);
            }
            if (genre.equals("צנזורה")){
                intent.putExtra("Title",getString(R.string.censor_info));
                startActivity(intent);
            }
            if (genre.equals("עבודה")){
                intent.putExtra("Title",getString(R.string.workplace_info));
                startActivity(intent);
            }
            if (genre.equals("תפילות")){
                intent.putExtra("Title",getString(R.string.prairs_info));
                startActivity(intent);
            }
        });

        gameBtn.setOnClickListener(v -> {
            if (genre.equals("צנזורה")) {
                Intent intent2 = new Intent(getApplicationContext(), TriviaNew.class);
                intent2.putExtra("genre", 2);
                startActivity(intent2);
            }
            if (genre.equals("חתונות")) {
                Intent intent2 = new Intent(getApplicationContext(), TriviaNew.class);
                intent2.putExtra("genre", 1);
                startActivity(intent2);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }
        else {
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        }
        shckoiech = soundPool.load(this, R.raw.shckoiech, 1);
        yedish = soundPool.load(this, R.raw.yedishkeit, 1);
        anger = soundPool.load(this, R.raw.anger, 1);
        eastern = soundPool.load(this, R.raw.eastern, 1);
        queen = soundPool.load(this, R.raw.queen, 1);
        minha = soundPool.load(this, R.raw.minha_2, 1);
        niece = soundPool.load(this, R.raw.niece, 1);
        gossip = soundPool.load(this, R.raw.chount, 1);
        zionist = soundPool.load(this, R.raw.zionist, 1);
        goi = soundPool.load(this, R.raw.shigetz, 1);
    }

    private void setWeddingWords(List<WordItem> items){
        items.add(new WordItem(getString(R.string.young_couple_title),getString(R.string.young_couple_details),0));
        items.add(new WordItem(getString(R.string.pkak_title), getString(R.string.pkak_details),0));
        items.add(new WordItem(getString(R.string.listener_title),getString(R.string.listener_details),0));
        items.add(new WordItem(getString(R.string.sidur_title),getString(R.string.sidur_details),0));
        items.add(new WordItem(getString(R.string.vert_title),getString(R.string.vert_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.wedding_title),getString(R.string.wedding_details),0));
        items.add(new WordItem(getString(R.string.private_title),getString(R.string.private_details),0));
        items.add(new WordItem(getString(R.string.cheer_title),getString(R.string.cheer_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.bride_title),getString(R.string.bride_details),0));
    }

    private void setCensorWords(List<WordItem> items){
        items.add(new WordItem(getString(R.string.vadal_title),getString(R.string.vadal_details),0));
        items.add(new WordItem(getString(R.string.achmal_title),getString(R.string.achmal_details),0));
        items.add(new WordItem(getString(R.string.modest_title),getString(R.string.modest_details),0));
        items.add(new WordItem(getString(R.string.fastnisht_title),getString(R.string.fastnisht_details),0));
        items.add(new WordItem(getString(R.string.nisht_title),getString(R.string.nisht_details),0));
    }

    private void setWorkplaceWords(List<WordItem> items){
        items.add(new WordItem(getString(R.string.woman_title),getString(R.string.woman_details),0));
        items.add(new WordItem(getString(R.string.hold_title),getString(R.string.hold_details),0));
        items.add(new WordItem(getString(R.string.basad_title),getString(R.string.basad_details),0));
        items.add(new WordItem(getString(R.string.hashem_title),getString(R.string.hashem_details),0));
        items.add(new WordItem(getString(R.string.go_prair_title),getString(R.string.go_prair_details),0));
        items.add(new WordItem(getString(R.string.hiloni_title),getString(R.string.hiloni_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.shcoiech_title),getString(R.string.shcoiech_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.babies_title),getString(R.string.babies_details),0));
        items.add(new WordItem(getString(R.string.goi_title),getString(R.string.goi_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.gossip_title),getString(R.string.gossip_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.news_title),getString(R.string.news_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.angry_title),getString(R.string.angry_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.yedish_title),getString(R.string.yedish_details),R.drawable.speaker));
    }

    private void setPrairsWords(List<WordItem> items) {
        items.add(new WordItem(getString(R.string.zatzal_title),getString(R.string.zatzal_details),0));
        items.add(new WordItem(getString(R.string.hundred_title),getString(R.string.hungred_details),0));
        items.add(new WordItem(getString(R.string.water_title),getString(R.string.water_details),0));
        items.add(new WordItem(getString(R.string.food_title),getString(R.string.food_details),0));
        items.add(new WordItem(getString(R.string.last_title),getString(R.string.last_details),0));
        items.add(new WordItem(getString(R.string.queen_title),getString(R.string.queen_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.eastern_title),getString(R.string.eastern_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.shahrit_title),getString(R.string.shahrit_details),0));
        items.add(new WordItem(getString(R.string.minha_title),getString(R.string.minha_details),R.drawable.speaker));
        items.add(new WordItem(getString(R.string.arvit_title),getString(R.string.arvit_details),0));
    }

    @Override
    public void onItemClicked(WordItem wordItem) {
        stopPlayer();
        switch (wordItem.getName()){
            case "משמחים":
                play(R.raw.happy_explanation);
                break;
            case "להכעיס":
                soundPool.play(anger,1,1,0,0,1);
                break;
            case "צ'ונט":
                soundPool.play(gossip,1,1,0,0,1);
                break;
            case "מיזרוחניק":
                soundPool.play(eastern,1,1,0,0,1);
                break;
            case "מנחה":
                soundPool.play(minha,1,1,0,0,1);
                break;
            case "נייעס":
                soundPool.play(niece,1,1,0,0,1);
                break;
            case "מלווה מלכה":
                soundPool.play(queen,1,1,0,0,1);
                break;
            case "שכוייח":
                soundPool.play(shckoiech,1,1,0,0,1);
                break;
            case "שייגעצ":
                soundPool.play(goi,1,1,0,0,1);
                break;
            case "ווארט":
                play(R.raw.vert_explenation);
                break;
            case "יידישקייט":
                soundPool.play(yedish,1,1,0,0,1);
                break;
            case "ציויינים":
                soundPool.play(zionist,1,1,0,0,1);
                break;
        }
    }

    public void play(int sound){
        if (player == null){
            player = MediaPlayer.create(this,sound);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
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