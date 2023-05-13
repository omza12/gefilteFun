package com.gefilte.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<WeddingItem> items;
    SelectListener listener;

    public MyAdapter(Context context, List<WeddingItem> items, SelectListener listener) {
        this.context = context;
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder((LayoutInflater.from(context).inflate(R.layout.vocabulary_recycler_view_row,parent,false)));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.cardView.setOnClickListener(v->{
            listener.onItemClicked(items.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
