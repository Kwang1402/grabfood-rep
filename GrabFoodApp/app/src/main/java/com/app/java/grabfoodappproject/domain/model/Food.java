package com.app.java.grabfoodappproject.domain.model;

public class Food {
    private int imageId;
    private String foodName;

    public Food() {
    }

    public Food( String foodName) {
        this.foodName = foodName;
    }

    public int getImageId() {
        return imageId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
