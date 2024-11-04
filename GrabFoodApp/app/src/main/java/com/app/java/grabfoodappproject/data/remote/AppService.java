package com.app.java.grabfoodappproject.data.remote;

import com.app.java.grabfoodappproject.data.model.Food;
import com.app.java.grabfoodappproject.data.model.FoodList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface AppService {
    // /api/foods
    @GET("/api/foods")
    Call<FoodList> listFoods(@Header("x-api-key") String key);
   // Call<FoodList> listFoods();

}
