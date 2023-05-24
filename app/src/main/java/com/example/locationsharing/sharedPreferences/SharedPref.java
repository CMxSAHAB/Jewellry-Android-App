package com.example.locationsharing.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    //create a shared preference object
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPref(Context context) {
        this.sharedPreferences = context.getSharedPreferences("RaviJewel", Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public void saveName(String name) {
        editor.putString("name", name);
        editor.apply();
    }

    public void saveEmail(String email) {
        editor.putString("email", email);
        editor.apply();
    }

    public void saveNumber(String number) {
        editor.putString("number", number);
        editor.apply();
    }

    public void saveAddress(String address) {
        editor.putString("address", address);
        editor.apply();
    }


    public String getName() {
        return sharedPreferences.getString("name", "");
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "");
    }

    public String getNumber() {
        return sharedPreferences.getString("number", "");
    }

    public String getAddress() {
        return sharedPreferences.getString("address", "");
    }


}
