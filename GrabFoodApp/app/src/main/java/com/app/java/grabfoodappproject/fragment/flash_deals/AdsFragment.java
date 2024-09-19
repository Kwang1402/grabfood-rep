package com.app.java.grabfoodappproject.fragment.flash_deals;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.activity.AdDetailActivity;
import com.app.java.grabfoodappproject.adapter.intro.AdIntroAdapter;
import com.app.java.grabfoodappproject.domain.model.intro.IntroAds;
import com.app.java.grabfoodappproject.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AdsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flash_deals_ads, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAds(view);
    }

    private void initAds(View view) {
        RecyclerView adRecycler = view.findViewById(R.id.ads_recycler);
        List<IntroAds> adsList = new ArrayList<>();
        IntroAds introAds = new IntroAds("Đăng ký ngay","lotte","Combo siêu hời chỉ 499K,tiết kiệm đến 180K");
        IntroAds ad2 = new IntroAds("Đặt ngay","pizzahut","Combo tựu trường giá chỉ từ 319K");
        IntroAds ad3 = new IntroAds("Đặt đơn ngay","banh_mi","Mua 2 tặng 1 Burger Gà Giòn");
        IntroAds ad4 = new IntroAds("Đặt ngay","highland","Giòn giã chuyện trăng");
        IntroAds ad5 = new IntroAds("Đặt đơn ngay","highland2","Khuyến mãi nạp thẻ xịn sò");
        IntroAds ad6 = new IntroAds("Đặt ngay","highland3","Quế ấm phin êm, phong vị độc đáo");
        adsList.add(introAds);
        adsList.add(ad2);
        adsList.add(ad3);
        adsList.add(ad4);
        adsList.add(ad5);
        adsList.add(ad6);
        AdIntroAdapter adsAdapter = new AdIntroAdapter(adsList, this::createDetailAd);
        adRecycler.setAdapter(adsAdapter);
    }

    private void createDetailAd(IntroAds introAds) {
        Intent intent = new Intent(requireActivity(), AdDetailActivity.class);
        intent.putExtra(AdDetailActivity.IMAGE_ID_KEY, Utils.getIntroAdImageId(introAds.getAdName()));
        startActivity(intent);
    }
}