package com.example.locationsharing.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locationsharing.AllContentShowActivity;
import com.example.locationsharing.R;

import java.util.List;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {

    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;
    int [] data_position;

    public RecyclerViewAdapter1(List<String> titles, List<Integer> images, Context context) {
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.image.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewRecyclerItem);
            image = itemView.findViewById(R.id.imageViewRecyclerItem);

            itemView.setOnClickListener(view -> {

                  Intent intent = new Intent(view.getContext(), AllContentShowActivity.class);
                  intent.putExtra("title", String.valueOf(titles.get(getAdapterPosition())));

                    view.getContext().startActivity(intent);

            });
        }
    }
}

