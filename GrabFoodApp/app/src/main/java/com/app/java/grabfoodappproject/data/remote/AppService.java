package com.app.java.grabfoodappproject.data.remote;

import com.app.java.grabfoodappproject.data.model.AdList;
import com.app.java.grabfoodappproject.data.model.FoodList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface AppService {
    @GET("/api/foods")
    Call<FoodList> listFoods(@Header("x-api-key") String key);

    @GET("/api/ads")
    Call<AdList> getAdList(@Header("x-api-key") String key);
}
