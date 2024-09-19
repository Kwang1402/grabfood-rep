
package com.app.java.grabfoodappproject.domain.mock_data;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.domain.model.recommended.RecommendedShop;

import java.util.ArrayList;

/*Shop and their respective discount data*/
public class ShopData {

    public static ArrayList<RecommendedShop> getShopData() {
        ArrayList<RecommendedShop> shopList = new ArrayList<RecommendedShop>();

        RecommendedShop shop1 = new RecommendedShop(R.drawable.rec_banhmi,"Bánh Mì Việt", "20% off", "Ad");
        shopList.add(shop1);

        RecommendedShop shop2 = new RecommendedShop(R.drawable.rec_xoi, "Xôi Gà", "9.000đ off · 50% off", "35 mins · 1.7 km");
        shopList.add(shop2);

        RecommendedShop shop3 = new RecommendedShop(R.drawable.rec_pizza, "Pizza 4P", "18.000đ · 80% off", "20 mins · 5 km");
        shopList.add(shop3);

        RecommendedShop shop4 = new RecommendedShop(R.drawable.rec_chao, "Cháo Sườn", "18.000đ · 20% off", "1 hr · 20 km");
        shopList.add(shop4);

        RecommendedShop shop5 = new RecommendedShop(R.drawable.rec_caphe, "Cà Phê Muối", "15.000đ · 10% off", "10 mins · 3 km");
        shopList.add(shop5);

        RecommendedShop shop6 = new RecommendedShop(R.drawable.rec_bundau,"Bún Đậu Mắm Tôm", "30.000đ", "40 mins · 13 km");
        shopList.add(shop6);

        return shopList;
    }
}


