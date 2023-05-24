package com.example.locationsharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.locationsharing.databinding.ActivityUserShowBinding;
import com.example.locationsharing.sharedPreferences.SharedPref;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserShowActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    ActivityUserShowBinding binding;
    SharedPref sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.extendedFloatingActionButton.setOnClickListener(view -> {
            onBackPressed();
        });

            setUpSignout();
            setUsername();

    }

    private void setUsername() {
        sharedPref = new SharedPref(this);
        String username = sharedPref.getName();
        binding.username.setText(username);
        binding.name.setText(username);
        binding.email.setText(sharedPref.getEmail());
        binding.mobile.setText(sharedPref.getNumber());
    }

    private void setUpSignout() {
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        if (currentUser == null){
            startActivity(new Intent(getApplicationContext(), LOGINActivity.class));
            finish();
        }
        binding.logoutButton.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), LOGINActivity.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}