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

public class WeddingWords extends AppCompatActivity implements SelectListener{

    Dialog mDialog;
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
        items.add(new WeddingItem(getString(R.string.young_couple_title)));
        items.add(new WeddingItem(getString(R.string.pkak_title)));
        items.add(new WeddingItem(getString(R.string.listener_title)));
        items.add(new WeddingItem(getString(R.string.sidur_title)));
        items.add(new WeddingItem(getString(R.string.vert_title)));
        items.add(new WeddingItem(getString(R.string.wedding_title)));
        items.add(new WeddingItem(getString(R.string.private_title)));
        items.add(new WeddingItem(getString(R.string.cheer_title)));
        items.add(new WeddingItem(getString(R.string.bride_title)));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items,this));
    }

    @Override
    public void onItemClicked(WeddingItem weddingItem) {
        Intent intent = new Intent(WeddingWords.this,word_info.class);
        if (weddingItem.getName().equals(getString(R.string.young_couple_title))){
            intent.putExtra("Title",getString(R.string.young_couple_title));
            intent.putExtra("Details",getString(R.string.young_couple_details));
            startActivity(intent);
        }
        if (weddingItem.getName().equals(getString(R.string.pkak_title))){
            intent.putExtra("Title",getString(R.string.pkak_title));
            intent.putExtra("Details",getString(R.string.pkak_details));
            startActivity(intent);
        }
        if (weddingItem.getName().equals(getString(R.string.listener_title))){
            intent.putExtra("Title",getString(R.string.listener_title));
            intent.putExtra("Details",getString(R.string.listener_details));
            startActivity(intent);
        }
        if (weddingItem.getName().equals(getString(R.string.sidur_title))){
            intent.putExtra("Title",getString(R.string.sidur_title));
            intent.putExtra("Details",getString(R.string.sidur_details));
            startActivity(intent);
        }
        if (weddingItem.getName().equals(getString(R.string.vert_title))){
            intent.putExtra("Title",getString(R.string.vert_title));
            intent.putExtra("Details",getString(R.string.vert_details));
            startActivity(intent);
        }
        if (weddingItem.getName().equals(getString(R.string.wedding_title))){
            intent.putExtra("Title",getString(R.string.wedding_title));
            intent.putExtra("Details",getString(R.string.wedding_details));
            startActivity(intent);
        }
        if (weddingItem.getName().equals(getString(R.string.private_title))){
            intent.putExtra("Title",getString(R.string.private_title));
            intent.putExtra("Details",getString(R.string.private_details));
            startActivity(intent);
        }
        if (weddingItem.getName().equals(getString(R.string.cheer_title))){
            intent.putExtra("Title",getString(R.string.cheer_title));
            intent.putExtra("Details",getString(R.string.cheer_details));
            startActivity(intent);
        }
        if (weddingItem.getName().equals(getString(R.string.bride_title))){
            intent.putExtra("Title",getString(R.string.bride_title));
            intent.putExtra("Details",getString(R.string.bride_details));
            startActivity(intent);
        }
    }
}