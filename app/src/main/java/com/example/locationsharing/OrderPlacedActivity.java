package com.example.locationsharing;

import static com.example.locationsharing.model.Constants.ordersList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.locationsharing.model.Jewellery;
import com.example.locationsharing.model.Order;

public class OrderPlacedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);
        Handler handler = new Handler();
        handler.postDelayed(this::setandgetIntent, 3000);
    }

    private void setandgetIntent() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int image = intent.getIntExtra("image", 0);
        String price = intent.getStringExtra("price");
        String description = intent.getStringExtra("description");
        ordersList.add(new Order(new Jewellery(title,price,image, description)));
        intent = new Intent(OrderPlacedActivity.this, TopNavActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}