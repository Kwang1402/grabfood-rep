package com.app.java.grabfoodappproject.model;

public class Food {
    private String foodName;

    public Food() {
    }

    public Food( String foodName) {
        this.foodName = foodName;
    }


    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
