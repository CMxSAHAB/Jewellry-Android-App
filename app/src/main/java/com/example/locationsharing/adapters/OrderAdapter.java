package com.example.locationsharing.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locationsharing.R;
import com.example.locationsharing.databinding.CustomOrderShowBinding;
import com.example.locationsharing.model.Jewellery;
import com.example.locationsharing.model.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    private List<Order> orderList;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custom_order_show, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Jewellery jewellery = orderList.get(position).getJewellery();
        holder.jname.setText(jewellery.getName());
        holder.price.setText(jewellery.getPrice());
        holder.image.setImageResource(jewellery.getImage());

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
    @SuppressLint("NotifyDataSetChanged")
    public void submitList(List<Order> orderList) {
        this.orderList = orderList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CustomOrderShowBinding binding1;
        ImageView image;
        TextView price, jname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding1 = CustomOrderShowBinding.bind(itemView);
            image = binding1.imageView3;
            price = binding1.textViewPrice;
            jname = binding1.orderNameTextView;


        }
    }
}
