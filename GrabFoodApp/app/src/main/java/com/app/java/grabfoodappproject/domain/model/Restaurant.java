package com.app.java.grabfoodappproject.domain.model;

public class Restaurant {
    private String name;
    private String review;
    private String price;
    private String percentageDiscount;
    private String priceDiscount;
    private int imageResId;

    public Restaurant(String name, String review, String price, String percentageDiscount, String priceDiscount, int imageResId) {
        this.name = name;
        this.review = review;
        this.price = price;
        this.percentageDiscount = percentageDiscount;
        this.priceDiscount = priceDiscount;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getReview() {
        return review;
    }

    public String getPrice() {
        return price;
    }

    public String getPercentageDiscount() {
        return percentageDiscount;
    }

    public String getPriceDiscount() {
        return priceDiscount;
    }

    public int getImageResId() {
        return imageResId;
    }
}
