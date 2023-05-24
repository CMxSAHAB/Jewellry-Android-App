package com.example.locationsharing.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locationsharing.databinding.CustomGridLayoutBinding;
import com.example.locationsharing.model.Jewellery;

import java.util.List;

public class RecyclerViewAdapterAyaan extends RecyclerView.Adapter<RecyclerViewAdapterAyaan.ViewHolder>{

    private OnItemClickListener listener;

    public RecyclerViewAdapterAyaan(OnItemClickListener listener) {
        this.listener = listener;
    }

    private List<Jewellery> jewelleryList;

    @SuppressLint("NotifyDataSetChanged")
    public void submitList(List<Jewellery> jewelleryList) {
        this.jewelleryList = jewelleryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CustomGridLayoutBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(jewelleryList.get(position));
    }

    @Override
    public int getItemCount() {
        return jewelleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CustomGridLayoutBinding binding;
        public ViewHolder( CustomGridLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(view -> {
                listener.onItemClick(jewelleryList.get(getAdapterPosition()));
            });
        }
        public void bind(Jewellery model) {
            binding.imageViewRecyclerItem.setImageResource(model.getImg());
            binding.textViewRecyclerItem.setText(model.getName());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Jewellery jewellery);
    }

}
