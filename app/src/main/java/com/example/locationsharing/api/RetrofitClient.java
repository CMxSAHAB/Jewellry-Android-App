package com.example.locationsharing.api;

import static com.example.locationsharing.api.GoldApi.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitClient {

    private static Retrofit retrofit = null;

    private static synchronized Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static GoldApi getGoldApi() {
        return getClient().create(GoldApi.class);
    }
}
