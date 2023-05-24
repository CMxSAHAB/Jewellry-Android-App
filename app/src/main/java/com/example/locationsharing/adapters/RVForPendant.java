package com.example.locationsharing.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locationsharing.DetailedViewActivity;
import com.example.locationsharing.R;
import com.example.locationsharing.databinding.CustomGridItemShowBinding;
import com.example.locationsharing.model.PendantList;

import java.util.ArrayList;
import java.util.List;

public class RVForPendant extends RecyclerView.Adapter<RVForPendant.ViewHolder> {

    static List<PendantList> pendantLists;
    LayoutInflater inflater;
    private final String type;

    public RVForPendant(List<PendantList> pendantLists, Context context,String type) {
        this.pendantLists = pendantLists;
        this.inflater = LayoutInflater.from(context);
        this.type = type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.custom_grid_item_show, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PendantList pendantList = pendantLists.get(position);
        holder.price.setText(pendantList.getPrice());
        holder.image.setImageResource(pendantList.getImage());


    }

    @Override
    public int getItemCount() {
        return pendantLists.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void submitList(ArrayList<PendantList> pendents) {
        this.pendantLists = pendents;
        notifyDataSetChanged();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        CustomGridItemShowBinding binding1;
        ImageView image;
        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding1 = CustomGridItemShowBinding.bind(itemView);
            image = binding1.imageViewRecyclerItem;
            price = binding1.textViewRecyclerItem;
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), DetailedViewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("title", type);
                intent.putExtra("image", pendantLists.get(getAdapterPosition()).getImage());
                intent.putExtra("price", pendantLists.get(getAdapterPosition()).getPrice());
                intent.putExtra("description", pendantLists.get(getAdapterPosition()).getDescription());
                view.getContext().startActivity(intent);
            });

        }
    }
}
