package com.example.locationsharing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.locationsharing.databinding.ActivityBuyNowBinding;
import com.example.locationsharing.sharedPreferences.SharedPref;

public class BuyNowActivity extends AppCompatActivity {
    ActivityBuyNowBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuyNowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbarSet();
        getIntentAndSetData();
        confirmOrder();
    }

    private void confirmOrder() {
        binding.buttonConfirm.setOnClickListener(view -> {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Are you sure you want to Confirm Transaction?");
                    builder.setTitle("Alert !");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                        Intent intent = new Intent(BuyNowActivity.this, OrderPlacedActivity.class);
                        intent.putExtra("title", getIntent().getStringExtra("title"));
                        intent.putExtra("image", getIntent().getIntExtra("image", 0));
                        intent.putExtra("price", getIntent().getStringExtra("price"));
                        intent.putExtra("description", getIntent().getStringExtra("description"));
                        startActivity(intent);
                    });
                    builder.setNegativeButton("No", (dialogInterface, i) -> {
                        dialogInterface.cancel();
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
        );
    }

    private void getIntentAndSetData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int image = intent.getIntExtra("image", 0);
        String price = intent.getStringExtra("price");
        String description = intent.getStringExtra("description");
        binding.imageView2.setImageResource(image);
        binding.textViewPriceValue.setText(price);
        binding.textViewJewelName.setText(title);
        binding.textViewDescription.setText(description);
        binding.address.setText(new SharedPref(this).getAddress());

    }

    private void toolbarSet() {
        binding.toolbar2.setTitle("Buy Now");
        binding.toolbar2.setNavigationOnClickListener(view -> {
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Cancel Transaction?");
        builder.setTitle("Alert !");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
            super.onBackPressed();
            finish();
        });
        builder.setNegativeButton("No", (dialogInterface, i) -> {
            dialogInterface.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}