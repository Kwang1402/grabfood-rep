package com.app.java.grabfoodappproject.data.repository;

import androidx.annotation.NonNull;

import com.app.java.grabfoodappproject.BuildConfig;
import com.app.java.grabfoodappproject.data.model.FoodList;
import com.app.java.grabfoodappproject.data.remote.AppService;
import com.app.java.grabfoodappproject.data.remote.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteRepository implements Repository {
// https://grabfood-api.vercel.app
    @Override
    public void makeGetFoodRequest(RepositoryCallBack<FoodList> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://grabfood-api.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AppService appService = retrofit.create(AppService.class);
        String apiKey = BuildConfig.API_KEY;

        Call<FoodList> foodListCall = appService.listFoods(apiKey); // call api
        foodListCall.enqueue(new Callback<FoodList>() {
            @Override
            public void onResponse(@NonNull Call<FoodList> call,
                                   @NonNull Response<FoodList> response) {
                callBack.onCompleted(new Result.Success<>(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<FoodList> call,
                                  @NonNull Throwable throwable) {
                callBack.onCompleted(new Result.Error<>(new Exception(throwable.getMessage())));
            }
        });
    }
}
