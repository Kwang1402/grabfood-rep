package com.app.java.grabfoodappproject.data.model.recommended;

public class RecommendedDish {
    private int mainImage;
    private int titleImage;
    private String title;
    private String information;
    private String price;
    private String discount;

    public RecommendedDish(int mainImage, int titleImage, String title, String information,
                           String price, String discount){
        this.mainImage = mainImage;
        this.titleImage = titleImage;
        this.title = title;
        this.information = information;
        this.price = price;
        this.discount = discount;
    }

    public String getTitle() {
        return title;
    }

    public int getTitleImage() {
        return titleImage;
    }

    public String getInformation() {
        return information;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public int getMainImage() {
        return mainImage;
    }
}
