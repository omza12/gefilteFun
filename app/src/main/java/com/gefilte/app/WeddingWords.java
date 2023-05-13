package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WeddingWords extends AppCompatActivity implements SelectListener{

    Dialog mDialog;
    TextView title, details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding_words);
        mDialog = new Dialog(this);
        mDialog.setContentView(R.layout.wedding_info_popup);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();

        RecyclerView recyclerView = findViewById(R.id.wedding_recycle_view);
        List<WeddingItem> items = new ArrayList<>();
        items.add(new WeddingItem("זו\"צ - זוג צעיר"));
        items.add(new WeddingItem("פקק"));
        items.add(new WeddingItem("שומע/ת"));
        items.add(new WeddingItem("סידור מלא"));
        items.add(new WeddingItem("ווארט"));
        items.add(new WeddingItem("חתונה"));
        items.add(new WeddingItem("ייחוד?"));
        items.add(new WeddingItem("משמחים"));
        items.add(new WeddingItem("ברוכה הכלה"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items,this));
    }

    @Override
    public void onItemClicked(WeddingItem weddingItem) {
        Dialog wordDialog = new Dialog(this);
        String wordTitle = getString(R.string.young_couple_title);
        String wordDetails = getString(R.string.young_couple_details);
        if (weddingItem.getName()=="זו\"צ - זוג צעיר"){
            title = findViewById(R.id.word_title);
            details = findViewById(R.id.word_details);
            title.setText(wordTitle);
            wordDialog.setContentView(R.layout.word_info_popup);
            wordDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            wordDialog.show();
        }
    }
}