package com.example.locationsharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.locationsharing.databinding.ActivityDetailedViewBinding;

public class DetailedViewActivity extends AppCompatActivity {
    ActivityDetailedViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getIntentAndSetData();
        toolbarSet();
        gotoBuyNowActivity();

    }

    private void gotoBuyNowActivity() {
        binding.buttonBuyNow.setOnClickListener(view -> {
            Intent intent = new Intent(DetailedViewActivity.this, BuyNowActivity.class);

            intent.putExtra("price", binding.textViewPrice.getText().toString());
            intent.putExtra("image", getIntent().getIntExtra("image", 0));
            intent.putExtra("title", getIntent().getStringExtra("title"));
            intent.putExtra("description", getIntent().getStringExtra("description"));
            startActivity(intent);
        });
    }

    private void toolbarSet() {
        binding.toolbar.setNavigationOnClickListener(view -> {
            onBackPressed();
        });
    }

    private void getIntentAndSetData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int image = intent.getIntExtra("image", 0);
        String price = intent.getStringExtra("price");
        String description = intent.getStringExtra("description");

        binding.imageView.setImageResource(image);
        binding.textViewPrice.setText(price);
        binding.textViewDescription.setText(description);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}