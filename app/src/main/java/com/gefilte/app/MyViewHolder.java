package com.gefilte.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nameView,infoView;
    ImageView imageView;
    CardView cardView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.recycler_word_title);
        infoView = itemView.findViewById(R.id.recycler_word);
        imageView = itemView.findViewById(R.id.word_sound);
        cardView = itemView.findViewById(R.id.recycler_items);
    }
}
