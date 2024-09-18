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
import com.app.java.grabfoodappproject.domain.model.FlashDealAds;
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
        List<FlashDealAds> flashDealAdsList = createListAds();
        FlashDealAdapter adapter = new FlashDealAdapter(flashDealAdsList);
        recyclerView.setAdapter(adapter);
    }

    private List<FlashDealAds> createListAds() {
        List<FlashDealAds> flashDealAdsList = new ArrayList<>();
        FlashDealAds ad1 = new FlashDealAds(R.drawable.hu_tieu, "Mì Trộn Thập Cẩm");
        FlashDealAds ad2 = new FlashDealAds(R.drawable.rec_buntron, "Bún Trộn Hải Phòng");
        FlashDealAds ad3 = new FlashDealAds(R.drawable.rec_banhmisale, "Bánh Mì Phố Cổ");
        FlashDealAds ad4 = new FlashDealAds(R.drawable.rec_comga, "Cơm Gà Bắc Kinh");
        FlashDealAds ad5 = new FlashDealAds(R.drawable.rec_caphe, "Cà Phê Chồn Đen");
        FlashDealAds ad6 = new FlashDealAds(R.drawable.rec_chao, "Cháo Dinh Dưỡng");
        flashDealAdsList.add(ad1);
        flashDealAdsList.add(ad2);
        flashDealAdsList.add(ad3);
        flashDealAdsList.add(ad4);
        flashDealAdsList.add(ad5);
        flashDealAdsList.add(ad6);
        return flashDealAdsList;
    }
}