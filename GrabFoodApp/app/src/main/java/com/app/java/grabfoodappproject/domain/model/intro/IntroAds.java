package com.app.java.grabfoodappproject.domain.model.intro;

public class IntroAds {
    private String title;
    private String adName;
    private String adTitle;

    public IntroAds(String title, String adName, String adTitle) {
        this.title = title;
        this.adName = adName;
        this.adTitle = adTitle;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
