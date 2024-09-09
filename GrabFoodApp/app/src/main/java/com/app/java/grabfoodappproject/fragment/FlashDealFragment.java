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
import com.app.java.grabfoodappproject.adapter.Ads2Adapter;
import com.app.java.grabfoodappproject.models.Ads2;

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
    }

    private void initRecycleView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.ads2_recycleview);
        List<Ads2> ads2List = createListAds();
        Ads2Adapter adapter = new Ads2Adapter(ads2List);
        recyclerView.setAdapter(adapter);
    }

    private List<Ads2> createListAds() {
        List<Ads2> ads2List = new ArrayList<>();
        Ads2 ad1 = new Ads2(R.drawable.noodle, "Mì Trộn Thập Cẩm");
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