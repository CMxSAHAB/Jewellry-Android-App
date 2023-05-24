package com.example.locationsharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.locationsharing.databinding.ActivityHomeBinding;

public class IntroActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //code for animation
        Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_down);
        Animation slideup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        Animation slideRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);

        //code for binding animation
        binding.textView3.startAnimation(slideDown);
        binding.textView4.startAnimation(slideDown);
        binding.textView5.startAnimation(slideRight);
        binding.extendedFab.startAnimation(slideup);

        //code for extended fab button
        binding.extendedFab.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), TopNavActivity.class));
        });

    }
}