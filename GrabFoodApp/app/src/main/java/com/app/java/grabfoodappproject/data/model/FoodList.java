package com.app.java.grabfoodappproject.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodList {
    @SerializedName("foods")
    private List<Food> mFoods;

    public FoodList(){
    }

    public FoodList(List<Food> foods) {
        mFoods = foods;
    }

    public List<Food> getFoods() {
        return mFoods;
    }

    public void setFoods(List<Food> foods) {
        mFoods = foods;
    }
}
