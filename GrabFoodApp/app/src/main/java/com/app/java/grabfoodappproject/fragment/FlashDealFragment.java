package com.app.java.grabfoodappproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.adapter.FlashDealAdapter;
import com.app.java.grabfoodappproject.adapter.RestaurantAdapterRecycler;
import com.app.java.grabfoodappproject.domain.model.Ads2;
import com.app.java.grabfoodappproject.domain.model.Restaurant;

import java.util.ArrayList;
import java.util.List;


public class FlashDealFragment extends Fragment {

    public FlashDealFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flash_deal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycleView(view);
        // Find the ListView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_flash_deal);
        // Sample data
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Bánh Mì Cô Chun", "4.7 (479) • $$$$ • Bread", "10.000đ 1̶5̶.̶0̶0̶0̶đ̶ • From 40 mins", "20% off", "10.000đ off", R.drawable.banh_mi_co_chun));
        restaurants.add(new Restaurant("Cơm Niêu Hợp Tác Xã", "4.2 (415) • $$$$ • Rice", "Free 1̶5̶.̶0̶0̶0̶đ̶ • From 40 mins", "100% off", "15.000đ off", R.drawable.com_nieu_hop_tac_xa));
        restaurants.add(new Restaurant("Cà Phê Muối Chú Long", "4.2 (94) • $$$$ • Coffee - Tea - Juice", "11.000đ 1̶5̶.̶0̶0̶0̶đ̶ • From 35 mins", "20% off", "10.000đ off", R.drawable.ca_phe_muoi_chu_long));

        // Set the custom adapter
        RestaurantAdapterRecycler adapter = new RestaurantAdapterRecycler(restaurants);
        recyclerView.setAdapter(adapter);
    }

    private void initRecycleView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.ads2_recycleview);
        List<Ads2> ads2List = createListAds();
        FlashDealAdapter adapter = new FlashDealAdapter(ads2List);
        recyclerView.setAdapter(adapter);
    }

    private List<Ads2> createListAds() {
        List<Ads2> ads2List = new ArrayList<>();
        Ads2 ad1 = new Ads2(R.drawable.hu_tieu, "Mì Trộn Thập Cẩm");
        Ads2 ad2 = new Ads2(R.drawable.rec_buntron, "Bún Trộn Hải Phòng");
        Ads2 ad3 = new Ads2(R.drawable.rec_banhmisale, "Bánh Mì Phố Cổ");
        Ads2 ad4 = new Ads2(R.drawable.rec_comga, "Cơm Gà Bắc Kinh");
        Ads2 ad5 = new Ads2(R.drawable.rec_caphe, "Cà Phê Chồn Đen");
        Ads2 ad6 = new Ads2(R.drawable.rec_chao, "Cháo Dinh Dưỡng");
        ads2List.add(ad1);
        ads2List.add(ad2);
        ads2List.add(ad3);
        ads2List.add(ad4);
        ads2List.add(ad5);
        ads2List.add(ad6);
        return ads2List;
    }
}