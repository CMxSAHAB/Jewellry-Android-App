package com.example.locationsharing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.locationsharing.adapters.OrderAdapter;
import com.example.locationsharing.databinding.ActivityOrderShowBinding;
import com.example.locationsharing.model.Constants;

public class OrderShowActivity extends AppCompatActivity {
    ActivityOrderShowBinding binding;
    private final boolean isEmpty = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        navbarSet();
        SetRecyclerView();
        Log.d("AAA", "onCreate: " + Constants.ordersList.size());
    }

    private void SetRecyclerView() {
        if (Constants.ordersList.size() == 0) {
            binding.orderShowRecyclerView.setVisibility(View.GONE);
            binding.noOrder.setVisibility(View.VISIBLE);
        } else {
            binding.orderShowRecyclerView.setVisibility(View.VISIBLE);
            binding.noOrder.setVisibility(View.GONE);
        }
        OrderAdapter adapter = new OrderAdapter();
        binding.orderShowRecyclerView.setAdapter(adapter);
        binding.orderShowRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.submitList(Constants.ordersList);
    }

    private void navbarSet() {
        binding.toolbar.setTitle("Order History");
        binding.toolbar.setNavigationOnClickListener(view -> {
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}