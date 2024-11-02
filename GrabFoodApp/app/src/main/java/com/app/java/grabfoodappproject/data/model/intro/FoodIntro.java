package com.app.java.grabfoodappproject.data.model.intro;

public class FoodIntro {
    private int imageId;
    private String foodName;

    public FoodIntro() {
    }

    public FoodIntro(String foodName, int imageId) {
        this.foodName = foodName;
        this.imageId = imageId;
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
