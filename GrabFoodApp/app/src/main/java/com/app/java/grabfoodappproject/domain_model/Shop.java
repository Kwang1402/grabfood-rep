package com.app.java.grabfoodappproject.domain_model;

import java.io.Serializable;

public class Shop implements Serializable{
    private final int resourceId;
    private final String name;
    private final String discount;
    private final String detail;

    public Shop(int resourceId, String name, String discount, String detail) {
        this.resourceId = resourceId;
        this.name = name;
        this.discount = discount;
        this.detail = detail;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getName() {
        return name;
    }

    public String getDiscount() {
        return discount;
    }

    public String getDetail() {
        return detail;
    }

}
