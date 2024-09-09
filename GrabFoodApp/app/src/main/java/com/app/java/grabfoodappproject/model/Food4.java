package com.app.java.grabfoodappproject.model;

public class Food4 {
    private int imageId;
    private String sale;
    private String foodName;
    private String time;
    private String distance;

    public Food4(int imageId,String sale, String foodName, String time, String distance) {
        this.imageId = imageId;
        this.foodName = foodName;
        this.time = time;
        this.distance = distance;
        this.sale =sale;
    }

    public int getImageId() {
        return imageId;
    }

    public String getSale() {
        return sale;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getTime() {
        return time;
    }

    public String getDistance() {
        return distance;
    }
}
