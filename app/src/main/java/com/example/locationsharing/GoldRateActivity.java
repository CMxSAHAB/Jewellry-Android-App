package com.example.locationsharing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.locationsharing.api.GoldModel;
import com.example.locationsharing.api.RetrofitClient;
import com.example.locationsharing.databinding.ActivityGoldRateBinding;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoldRateActivity extends AppCompatActivity {
    ActivityGoldRateBinding binding;
    private static final String TAG = "TopNavActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoldRateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbar.setTitle("Gold Rate");

        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
        binding.refreshButton.setOnClickListener(v -> {


            Handler handler = new Handler();
            handler.postDelayed(() -> {
                binding.refreshButton.setEnabled(true);
            }, 5000);
            apiCalls();
            binding.dateView.setText(new Date().toString());
        });

    }
    private void apiCalls() {
        try {
            RetrofitClient.getGoldApi().getGoldPrice().enqueue(
                    new Callback<GoldModel>() {
                        @Override
                        public void onResponse(@NonNull Call<GoldModel> call, @NonNull Response<GoldModel> response) {
                            if (response.isSuccessful()) {
                                GoldModel prices = response.body();
                                if (prices != null) {
                                    binding.textViewRates.setText(prices.toString());
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<GoldModel> call, @NonNull Throwable t) {
                            Log.d(TAG, "onFailure: "+t.getMessage());
                        }
                    }
            );
        } catch (Exception e) {
            Log.d(TAG, "apiCalls: "+e.getMessage());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}