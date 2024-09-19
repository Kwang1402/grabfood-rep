package com.app.java.grabfoodappproject.fragment.intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.activity.AdDetailActivity;
import com.app.java.grabfoodappproject.activity.FoodActivity;
import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.adapter.intro.FoodAdapter;
import com.app.java.grabfoodappproject.adapter.intro.AdIntroAdapter;
import com.app.java.grabfoodappproject.domain.model.intro.IntroAds;
import com.app.java.grabfoodappproject.domain.model.intro.FoodIntro;
import com.app.java.grabfoodappproject.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class IntroFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initFoodRecyclerView(view);
        initAdRecyclerView(view);
    }

    private void initAdRecyclerView(View view) {
        RecyclerView adRecycler = view.findViewById(R.id.ads_recycler1);
        List<IntroAds> introAdsList = createAd1List();
        AdIntroAdapter adAdapter = new AdIntroAdapter(introAdsList,this::createDetailAd);
        adRecycler.setAdapter(adAdapter);
    }

    private void createDetailAd(IntroAds introAds) {
        Intent intent = new Intent(requireActivity(),AdDetailActivity.class);
        intent.putExtra(AdDetailActivity.IMAGE_ID_KEY, Utils.getIntroAdImageId(introAds.getAdName()));
        startActivity(intent);
    }

    private List<IntroAds> createAd1List() {
        List<IntroAds> introAdsList = new ArrayList<>();
        IntroAds introAds = new IntroAds("Đăng ký ngay","lotte","Combo siêu hời chỉ 499K, tiết kiệm đến 180K");
        IntroAds ad2 = new IntroAds("Đặt ngay","pizzahut","Combo tựu trường giá chỉ từ 319K");
        IntroAds ad3 = new IntroAds("Đặt đơn ngay","banh_mi","Mua 2 tặng 1 Burger Gà Giòn");
        IntroAds ad4 = new IntroAds("Đặt ngay","highland","Giòn giã chuyện trăng");
        IntroAds ad5 = new IntroAds("Đặt đơn ngay","highland2","Khuyến mãi nạp thẻ xịn sò");
        IntroAds ad6 = new IntroAds("Đặt ngay","highland3","Quế ấm phin êm, phong vị độc đáo");
        introAdsList.add(introAds);
        introAdsList.add(ad2);
        introAdsList.add(ad3);
        introAdsList.add(ad4);
        introAdsList.add(ad5);
        introAdsList.add(ad6);
        return introAdsList;
    }

    private void initFoodRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.food_recycler);
        List<FoodIntro> foodList = createFoodList();
        FoodAdapter adapter = new FoodAdapter(foodList, this::createDetailFood);
        recyclerView.setAdapter(adapter);
    }

    private void createDetailFood(FoodIntro food) {
        Intent intent = new Intent(requireActivity(), FoodActivity.class);
        intent.putExtra(FoodActivity.FOOD_KEY,food.getFoodName());
        intent.putExtra(FoodActivity.FOOD_KEY_IMAGE,food.getImageId());
        startActivity(intent);
    }

    private List<FoodIntro> createFoodList() {
        List<FoodIntro> foodList = new ArrayList<>();
        FoodIntro noodles = new FoodIntro(getString(R.string.noodle), R.drawable.noodle);
        FoodIntro rice = new FoodIntro(getString(R.string.rice), R.drawable.fa_com_gaolut);
        FoodIntro hotpot = new FoodIntro(getString(R.string.hotpot), R.drawable.fa_lau_thai);
        FoodIntro healthyFood = new FoodIntro(getString(R.string.healthy_food), R.drawable.fa_healthyfood);
        FoodIntro fastFood = new FoodIntro(getString(R.string.fast_food), R.drawable.fa_lau_ech);
        FoodIntro coffee = new FoodIntro(getString(R.string.coffee), R.drawable.ca_phe_muoi_chu_long);
        foodList.add(noodles);
        foodList.add(rice);
        foodList.add(healthyFood);
        foodList.add(hotpot);
        foodList.add(coffee);
        foodList.add(fastFood);
        return foodList;
    }
}
