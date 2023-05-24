package com.example.locationsharing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.locationsharing.adapters.UserInfo;
import com.example.locationsharing.databinding.ActivityRegisterBinding;
import com.example.locationsharing.sharedPreferences.SharedPref;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    FirebaseAuth mAuth;
    SharedPref sharedPref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

        sharedPref = new SharedPref(this);

        binding.loginText.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), LOGINActivity.class));
            finish();
        });

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = String.valueOf(binding.username.getText());
                String email = String.valueOf(binding.email.getText());
                String password = String.valueOf(binding.password.getText());
                String phone = String.valueOf(binding.phone.getText());
                String address = String.valueOf(binding.address.getText());
                if (email.isEmpty()) {
                    binding.username.setError("Email is required");
                    return;
                }
                if (password.isEmpty()) {
                    binding.password.setError("Password is required");
                    return;
                }
                if (phone.length() < 10) {
                    binding.phone.setError("phone is required");
                    return;
                }
                if (username.isEmpty()) {
                    binding.username.setError("Username is required");
                }
                if (password.length() < 6) {
                    binding.password.setError("Password must be >= 6 characters");
                    return;
                }
                if (address.isEmpty()) {
                    binding.address.setError("Address is required");
                    return;
                }


                UserInfo user = new UserInfo(username, email,password,phone,address);
                myRef.child("user").child(username).setValue(user);
                binding.progressBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                binding.progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
                                    sharedPref.saveName(username);
                                    sharedPref.saveEmail(email);
                                    sharedPref.saveNumber(phone);
                                    sharedPref.saveAddress(address);
                                    startActivity(new Intent(getApplicationContext(), IntroActivity.class));
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });
    }
}