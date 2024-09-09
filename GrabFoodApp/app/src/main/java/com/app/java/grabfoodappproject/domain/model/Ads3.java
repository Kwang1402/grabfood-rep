package com.app.java.grabfoodappproject.domain.model;

public class Ads3 {
    private int imageId;
    private String adsTitle;
    private String adsDes;

    public Ads3(int imageId, String adsTitle, String adsDes)  {
        this.imageId = imageId;
        this.adsTitle = adsTitle;
        this.adsDes = adsDes;
    }

    public void setAdsTitle(String adsTitle) {
        this.adsTitle = adsTitle;
    }

    public void setAdsDes(String adsDes) {
        this.adsDes = adsDes;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getAdsTitle() {
        return adsTitle;
    }

    public String getAdsDes() {
        return adsDes;
    }
}
