package com.app.java.grabfoodappproject.utils;

import com.app.java.grabfoodappproject.R;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static final Map<String, Integer> idsOfFood = new HashMap<>();

    static {
        idsOfFood.put("Coffee", R.drawable.coffee);
        idsOfFood.put("Fast Food", R.drawable.fastfood);
        idsOfFood.put("Hotpot", R.drawable.hotpot);
        idsOfFood.put("Healthy Food", R.drawable.healthyfood);
        idsOfFood.put("Rice", R.drawable.rice);
        idsOfFood.put("Noodles", R.drawable.hu_tieu);
    }

    public static final Map<String, Integer> idsOfAd = new HashMap<>();

    static {
        idsOfAd.put("banh_mi", R.drawable.banh_mi);
        idsOfAd.put("pizzahut", R.drawable.pizzahut);
        idsOfAd.put("highland", R.drawable.highland);
        idsOfAd.put("highland2", R.drawable.highland2);
        idsOfAd.put("highland3", R.drawable.highland3);
        idsOfAd.put("lotte", R.drawable.lotte);
    }

    public static int getFoodImageId(String foodName) {
        Integer imageId = idsOfFood.get(foodName);
        return imageId == null ? R.drawable.hu_tieu : imageId;
    }

    public static int getIntroAdImageId(String title) {
        Integer id = idsOfAd.get(title);
        return id == null ? R.drawable.lotte : id;
    }
}
