package com.app.java.grabfoodappproject.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AdList {
    @SerializedName("ads")
    private List<Ad> mAdLists;

    public List<Ad> getAdLists() {
        return mAdLists;
    }
}
