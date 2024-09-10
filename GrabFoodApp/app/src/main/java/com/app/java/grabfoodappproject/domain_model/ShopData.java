
package com.app.java.grabfoodappproject.domain_model;

import com.app.java.grabfoodappproject.R;

import java.util.ArrayList;

/*Shop and their respective discount data*/
public class ShopData {

    public static ArrayList<Shop> getShopData() {
        ArrayList<Shop> shopList = new ArrayList<Shop>();

        Shop shop1 = new Shop(R.drawable.rec_banhmi,"Bánh Mì Việt", "20% off", "Ad");
        shopList.add(shop1);

        Shop shop2 = new Shop(R.drawable.rec_xoi, "Xôi Gà", "9.000đ off · 50% off", "35 mins · 1.7 km");
        shopList.add(shop2);

        Shop shop3 = new Shop(R.drawable.rec_pizza, "Pizza 4P", "18.000đ · 80% off", "20 mins · 5 km");
        shopList.add(shop3);

        Shop shop4 = new Shop(R.drawable.rec_chao, "Cháo Sườn", "18.000đ · 20% off", "1 hr · 20 km");
        shopList.add(shop4);

        Shop shop5 = new Shop(R.drawable.rec_caphe, "Cà Phê Muối", "15.000đ · 10% off", "10 mins · 3 km");
        shopList.add(shop5);

        Shop shop6 = new Shop(R.drawable.rec_bundau,"Bún Đậu Mắm Tôm", "30.000đ", "40 mins · 13 km");
        shopList.add(shop6);

        return shopList;
    }
}


