package com.app.java.grabfoodappproject.data.model.flash_deals;

public class FlashDealAds {
    private int imageId;
    private String textTitle;

    public FlashDealAds(int imageId, String textTitle)  {
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
