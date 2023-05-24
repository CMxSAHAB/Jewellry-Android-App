package com.example.locationsharing.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GoldApi {

    String BASE_URL = "https://www.goldapi.io/api/";

    @Headers("x-access-token: goldapi-9jx0zrlhpyuxq2-io")
    @GET("XAU/INR")
    Call<GoldModel> getGoldPrice();
}
