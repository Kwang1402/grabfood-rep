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
import com.app.java.grabfoodappproject.adapter.AdsAdapter;
import com.app.java.grabfoodappproject.domain.model.Ads3;

import java.util.ArrayList;
import java.util.List;


public class AdsFragment extends Fragment {

    public AdsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ads, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycleView(view);
    }

    private void initRecycleView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.ads3_recycleview);
        List<Ads3> ads3List = createListAds();
        AdsAdapter adapter = new AdsAdapter(ads3List);
        recyclerView.setAdapter(adapter);
    }

    private List<Ads3> createListAds() {
        List<Ads3> ads3List = new ArrayList<>();
        Ads3 ad1 = new Ads3(R.drawable.highland, "Highland, High mọi lúc mọi nơi", "Highland");
        Ads3 ad2 = new Ads3(R.drawable.highland2, "Highland, High mọi lúc mọi nơi", "Highland");
        Ads3 ad3 = new Ads3(R.drawable.highland3, "Highland, High mọi lúc mọi nơi", "Highland");
        Ads3 ad4 = new Ads3(R.drawable.lotte, "Tiệc Lotte Tưng Bừng", "Lottery");
        Ads3 ad5 = new Ads3(R.drawable.pizzahut, "Combo Tựu Trường", "Grab Tựu Trường");
        ads3List.add(ad1);
        ads3List.add(ad2);
        ads3List.add(ad3);
        ads3List.add(ad4);
        ads3List.add(ad5);
        return ads3List;
    }

}