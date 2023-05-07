package com.gefilte.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.WindowManager;

import com.gefilte.app.R;

import java.util.ArrayList;
import java.util.List;

public class WeddingWords extends AppCompatActivity {

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
        List<WeddingItem> items = new ArrayList<WeddingItem>();
        items.add(new WeddingItem("חתונה אחת"));
        items.add(new WeddingItem("חתונה שתיים"));
        items.add(new WeddingItem("חתונה שלוש"));
        items.add(new WeddingItem("חתונה ארבע"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));
    }
}