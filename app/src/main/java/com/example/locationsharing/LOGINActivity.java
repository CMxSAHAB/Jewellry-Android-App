package com.example.locationsharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.locationsharing.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LOGINActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FirebaseAuth mAuth;



    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            startActivity(new Intent(getApplicationContext(), IntroActivity.class));
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //code to remove the action bar

        mAuth = FirebaseAuth.getInstance();


        binding.textView2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
        });

        binding.loginButton.setOnClickListener(view -> {


            String email = String.valueOf(binding.username.getText());
            String password = String.valueOf(binding.password.getText());

            if (TextUtils.isEmpty(email)){
                binding.username.setError("Email is required");
                return;
            }
            if (TextUtils.isEmpty(password)){
                binding.password.setError("Password is required");
                return;
            }
            binding.progressBar.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(task -> {
                        binding.progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Welcome Back", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), IntroActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Error!"+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();

                        }
                    });
        });


    }
}