package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class LearningWords extends AppCompatActivity implements SelectListener{

    String genre;
    SharedPreferences weddingPref, censorPref, prairPref, workplacePref;
    Button infoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_words);
        RecyclerView recyclerView = findViewById(R.id.main_recycle_view);
        infoBtn = findViewById(R.id.info_button);
        List<WordItem> items = new ArrayList<>();
        genre = getIntent().getExtras().getString("genre");
        Intent intent = new Intent(LearningWords.this,word_title.class);
        if (genre.equals("חתונות")){
            weddingPref = PreferenceManager.getDefaultSharedPreferences(this);
            if (weddingPref.getBoolean("weddingInfo",true)){
                intent.putExtra("Title",getString(R.string.wedding_info));
                startActivity(intent);
                SharedPreferences.Editor editor = weddingPref.edit();
                editor.putBoolean("weddingInfo",false);
                editor.apply();
            }
            setWeddingWords(items);
        }
        if (genre.equals("צנזורה")){
            censorPref = PreferenceManager.getDefaultSharedPreferences(this);
            if (censorPref.getBoolean("censorInfo",true)){
                intent.putExtra("Title",getString(R.string.censor_info));
                startActivity(intent);
                SharedPreferences.Editor editor = censorPref.edit();
                editor.putBoolean("censor",false);
                editor.apply();
            }
            setCensorWords(items);
        }
        if (genre.equals("עבודה")){
            workplacePref = PreferenceManager.getDefaultSharedPreferences(this);
            if (workplacePref.getBoolean("workplaceInfo",true)){
                intent.putExtra("Title",getString(R.string.workplace_info));
                startActivity(intent);
                SharedPreferences.Editor editor = workplacePref.edit();
                editor.putBoolean("workplaceInfo",false);
                editor.apply();
            }
            setWorkplaceWords(items);
        }
        if (genre.equals("תפילות")){
            prairPref = PreferenceManager.getDefaultSharedPreferences(this);
            if (prairPref.getBoolean("prairsInfo",true)){
                intent.putExtra("Title",getString(R.string.prairs_info));
                startActivity(intent);
                SharedPreferences.Editor editor = prairPref.edit();
                editor.putBoolean("prairsInfo",false);
                editor.apply();
            }
            setPrairsWords(items);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items,this));

        infoBtn.setOnClickListener(v -> {
            if (genre.equals("חתונות")){
                intent.putExtra("Title",getString(R.string.wedding_info));
                startActivity(intent);
                SharedPreferences.Editor editor = weddingPref.edit();
                editor.putBoolean("weddingInfo",false);
                editor.apply();
            }
            if (genre.equals("צנזורה")){
                intent.putExtra("Title",getString(R.string.censor_info));
                startActivity(intent);
                SharedPreferences.Editor editor = censorPref.edit();
                editor.putBoolean("censor",false);
                editor.apply();
            }
            if (genre.equals("עבודה")){
                intent.putExtra("Title",getString(R.string.workplace_info));
                startActivity(intent);
                SharedPreferences.Editor editor = workplacePref.edit();
                editor.putBoolean("workplaceInfo",false);
                editor.apply();
            }
            if (genre.equals("תפילות")){
                intent.putExtra("Title",getString(R.string.prairs_info));
                startActivity(intent);
                SharedPreferences.Editor editor = prairPref.edit();
                editor.putBoolean("prairsInfo",false);
                editor.apply();
            }
        });
    }

    private void setWeddingWords(List<WordItem> items){
        items.add(new WordItem(getString(R.string.young_couple_title)));
        items.add(new WordItem(getString(R.string.pkak_title)));
        items.add(new WordItem(getString(R.string.listener_title)));
        items.add(new WordItem(getString(R.string.sidur_title)));
        items.add(new WordItem(getString(R.string.vert_title)));
        items.add(new WordItem(getString(R.string.wedding_title)));
        items.add(new WordItem(getString(R.string.private_title)));
        items.add(new WordItem(getString(R.string.cheer_title)));
        items.add(new WordItem(getString(R.string.bride_title)));
    }

    private void setCensorWords(List<WordItem> items){
        items.add(new WordItem(getString(R.string.vadal_title)));
        items.add(new WordItem(getString(R.string.achmal_title)));
        items.add(new WordItem(getString(R.string.modest_title)));
        items.add(new WordItem(getString(R.string.fastnisht_title)));
        items.add(new WordItem(getString(R.string.nisht_title)));
    }

    private void setWorkplaceWords(List<WordItem> items){
        items.add(new WordItem(getString(R.string.woman_title)));
        items.add(new WordItem(getString(R.string.hold_title)));
        items.add(new WordItem(getString(R.string.basad_title)));
        items.add(new WordItem(getString(R.string.go_prair_title)));
        items.add(new WordItem(getString(R.string.hiloni_title)));
        items.add(new WordItem(getString(R.string.shcoiech_title)));
        items.add(new WordItem(getString(R.string.babies_title)));
        items.add(new WordItem(getString(R.string.goi_title)));
        items.add(new WordItem(getString(R.string.dos_and_donts_title)));
        items.add(new WordItem(getString(R.string.gossip_title)));
        items.add(new WordItem(getString(R.string.news_title)));
        items.add(new WordItem(getString(R.string.angry_title)));
        items.add(new WordItem(getString(R.string.yedish_title)));
    }

    private void setPrairsWords(List<WordItem> items) {
        items.add(new WordItem(getString(R.string.zatzal_title)));
        items.add(new WordItem(getString(R.string.hundred_title)));
        items.add(new WordItem(getString(R.string.water_title)));
        items.add(new WordItem(getString(R.string.food_title)));
        items.add(new WordItem(getString(R.string.last_title)));
        items.add(new WordItem(getString(R.string.queen_title)));
        items.add(new WordItem(getString(R.string.eastern_title)));
        items.add(new WordItem(getString(R.string.shahrit_title)));
        items.add(new WordItem(getString(R.string.minha_title)));
        items.add(new WordItem(getString(R.string.arvit_title)));
    }

    @Override
    public void onItemClicked(WordItem WordItem) {
        if (genre.equals("חתונות")){
            setWeddingButtons(WordItem);
        }
        if (genre.equals("צנזורה")){
            setCensorButtons(WordItem);
        }
        if (genre.equals("עבודה")){
            setWorkplaceButtons(WordItem);
        }
        if (genre.equals("תפילות")){
            setPrairsButtons(WordItem);
        }
    }

    private void setWeddingButtons(WordItem WordItem){
        Intent intent = new Intent(LearningWords.this,word_info.class);
        if (WordItem.getName().equals(getString(R.string.young_couple_title))){
            intent.putExtra("Title",getString(R.string.young_couple_title));
            intent.putExtra("Details",getString(R.string.young_couple_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.pkak_title))){
            intent.putExtra("Title",getString(R.string.pkak_title));
            intent.putExtra("Details",getString(R.string.pkak_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.listener_title))){
            intent.putExtra("Title",getString(R.string.listener_title));
            intent.putExtra("Details",getString(R.string.listener_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.sidur_title))){
            intent.putExtra("Title",getString(R.string.sidur_title));
            intent.putExtra("Details",getString(R.string.sidur_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.vert_title))){
            intent.putExtra("Title",getString(R.string.vert_title));
            intent.putExtra("Details",getString(R.string.vert_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.wedding_title))){
            intent.putExtra("Title",getString(R.string.wedding_title));
            intent.putExtra("Details",getString(R.string.wedding_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.private_title))){
            intent.putExtra("Title",getString(R.string.private_title));
            intent.putExtra("Details",getString(R.string.private_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.cheer_title))){
            intent.putExtra("Title",getString(R.string.cheer_title));
            intent.putExtra("Details",getString(R.string.cheer_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.bride_title))){
            intent.putExtra("Title",getString(R.string.bride_title));
            intent.putExtra("Details",getString(R.string.bride_details));
            startActivity(intent);
        }
    }

    private void setCensorButtons(WordItem WordItem) {
        Intent intent = new Intent(LearningWords.this, word_info.class);
        if (WordItem.getName().equals(getString(R.string.vadal_title))) {
            intent.putExtra("Title", getString(R.string.vadal_title));
            intent.putExtra("Details", getString(R.string.vadal_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.achmal_title))) {
            intent.putExtra("Title", getString(R.string.achmal_title));
            intent.putExtra("Details", getString(R.string.achmal_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.modest_title))) {
            intent.putExtra("Title", getString(R.string.modest_title));
            intent.putExtra("Details", getString(R.string.modest_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.fastnisht_title))) {
            intent.putExtra("Title", getString(R.string.fastnisht_title));
            intent.putExtra("Details", getString(R.string.fastnisht_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.nisht_title))) {
            intent.putExtra("Title", getString(R.string.nisht_title));
            intent.putExtra("Details", getString(R.string.nisht_details));
            startActivity(intent);
        }
    }

    private void setWorkplaceButtons(WordItem WordItem) {
        Intent intent = new Intent(LearningWords.this, word_info.class);
        if (WordItem.getName().equals(getString(R.string.woman_title))) {
            intent.putExtra("Title", getString(R.string.woman_title));
            intent.putExtra("Details", getString(R.string.woman_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.hold_title))) {
            intent.putExtra("Title", getString(R.string.hold_title));
            intent.putExtra("Details", getString(R.string.hold_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.basad_title))) {
            intent.putExtra("Title", getString(R.string.basad_title));
            intent.putExtra("Details", getString(R.string.basad_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.go_prair_title))) {
            intent.putExtra("Title", getString(R.string.go_prair_title));
            intent.putExtra("Details", getString(R.string.go_prair_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.hiloni_title))) {
            intent.putExtra("Title", getString(R.string.hiloni_title));
            intent.putExtra("Details", getString(R.string.hiloni_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.shcoiech_title))) {
            intent.putExtra("Title", getString(R.string.shcoiech_title));
            intent.putExtra("Details", getString(R.string.shcoiech_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.babies_title))) {
            intent.putExtra("Title", getString(R.string.babies_title));
            intent.putExtra("Details", getString(R.string.babies_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.goi_title))) {
            intent.putExtra("Title", getString(R.string.goi_title));
            intent.putExtra("Details", getString(R.string.goi_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.dos_and_donts_title))) {
            intent.putExtra("Title", getString(R.string.dos_and_donts_title));
            intent.putExtra("Details", getString(R.string.dos_and_donts_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.gossip_title))) {
            intent.putExtra("Title", getString(R.string.gossip_title));
            intent.putExtra("Details", getString(R.string.gossip_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.news_title))) {
            intent.putExtra("Title", getString(R.string.news_title));
            intent.putExtra("Details", getString(R.string.news_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.angry_title))) {
            intent.putExtra("Title", getString(R.string.angry_title));
            intent.putExtra("Details", getString(R.string.angry_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.yedish_title))) {
            intent.putExtra("Title", getString(R.string.yedish_title));
            intent.putExtra("Details", getString(R.string.yedish_details));
            startActivity(intent);
        }
    }

    private void setPrairsButtons(WordItem WordItem) {
        Intent intent = new Intent(LearningWords.this, word_info.class);
        if (WordItem.getName().equals(getString(R.string.zatzal_title))) {
            intent.putExtra("Title", getString(R.string.zatzal_title));
            intent.putExtra("Details", getString(R.string.zatzal_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.hundred_title))) {
            intent.putExtra("Title", getString(R.string.hundred_title));
            intent.putExtra("Details", getString(R.string.hungred_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.water_title))) {
            intent.putExtra("Title", getString(R.string.water_title));
            intent.putExtra("Details", getString(R.string.water_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.food_title))) {
            intent.putExtra("Title", getString(R.string.food_title));
            intent.putExtra("Details", getString(R.string.food_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.last_title))) {
            intent.putExtra("Title", getString(R.string.last_title));
            intent.putExtra("Details", getString(R.string.last_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.queen_title))) {
            intent.putExtra("Title", getString(R.string.queen_details));
            intent.putExtra("Details", getString(R.string.queen_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.eastern_title))) {
            intent.putExtra("Title", getString(R.string.eastern_title));
            intent.putExtra("Details", getString(R.string.eastern_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.shahrit_title))) {
            intent.putExtra("Title", getString(R.string.shahrit_title));
            intent.putExtra("Details", getString(R.string.shahrit_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.minha_title))) {
            intent.putExtra("Title", getString(R.string.minha_title));
            intent.putExtra("Details", getString(R.string.minha_details));
            startActivity(intent);
        }
        if (WordItem.getName().equals(getString(R.string.arvit_title))) {
            intent.putExtra("Title", getString(R.string.arvit_title));
            intent.putExtra("Details", getString(R.string.arvit_details));
            startActivity(intent);
        }
    }
}