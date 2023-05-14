package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class LearningWords extends AppCompatActivity implements SelectListener{

    String genre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_words);

        RecyclerView recyclerView = findViewById(R.id.main_recycle_view);
        List<WordItem> items = new ArrayList<>();
        genre = getIntent().getExtras().getString("genre");
        if (genre.equals("חתונות")){
            items = setWeddingWords(items);
        }
        if (genre.equals("צנזורה")){
            items = setCensorWords(items);
        }
        if (genre.equals("עבודה")){
            items = setWorkplaceWords(items);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items,this));
    }

    private List<WordItem> setWeddingWords(List<WordItem> items){
        items.add(new WordItem(getString(R.string.young_couple_title)));
        items.add(new WordItem(getString(R.string.pkak_title)));
        items.add(new WordItem(getString(R.string.listener_title)));
        items.add(new WordItem(getString(R.string.sidur_title)));
        items.add(new WordItem(getString(R.string.vert_title)));
        items.add(new WordItem(getString(R.string.wedding_title)));
        items.add(new WordItem(getString(R.string.private_title)));
        items.add(new WordItem(getString(R.string.cheer_title)));
        items.add(new WordItem(getString(R.string.bride_title)));
//        mDialog = new Dialog(this);
//        mDialog.setContentView(R.layout.wedding_info_popup);
//        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        mDialog.show();

        return items;
    }

    private List<WordItem> setCensorWords(List<WordItem> items){
        items.add(new WordItem(getString(R.string.vadal_title)));
        items.add(new WordItem(getString(R.string.achmal_title)));
        items.add(new WordItem(getString(R.string.modest_title)));
        items.add(new WordItem(getString(R.string.fastnisht_title)));
        items.add(new WordItem(getString(R.string.nisht_title)));
//        mDialog = new Dialog(this);
//        mDialog.setContentView(R.layout.wedding_info_popup);
//        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        mDialog.show();

        return items;
    }

    private List<WordItem> setWorkplaceWords(List<WordItem> items){
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
//        mDialog = new Dialog(this);
//        mDialog.setContentView(R.layout.wedding_info_popup);
//        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        mDialog.show();

        return items;
    }

    @Override
    public void onItemClicked(WordItem WordItem) {
        Intent intent = new Intent(LearningWords.this,word_info.class);
        if (genre.equals("חתונות")){
            setWeddingButtons(WordItem);
        }
        if (genre.equals("צנזורה")){
            setCensorButtons(WordItem);
        }
        if (genre.equals("עבודה")){
            setWorkplaceButtons(WordItem);
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
}