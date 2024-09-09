package com.app.java.grabfoodappproject.models;

public class Ads2 {
    private int imageId;
    private String textTitle;

    public Ads2(int imageId, String textTitle)  {
        this.imageId = imageId;
        this.textTitle = textTitle;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
