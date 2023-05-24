package com.example.locationsharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.locationsharing.databinding.ActivityMapsBinding;

public class MapsActivity extends AppCompatActivity {

    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.extendedFab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmnIntentUri = Uri.parse("geo:0,0?q=28.622768054041472, 77.08480908465644(Vishal Jewellers)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmnIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        binding.extendedFab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmnIntentUri = Uri.parse("geo:0,0?q=28.620951904471355, 77.0675048958539(Ravi Jewellers)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmnIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}