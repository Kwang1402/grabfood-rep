package com.app.java.grabfoodappproject.fragment;

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
import com.app.java.grabfoodappproject.adapter.FoodAdapter;
import com.app.java.grabfoodappproject.adapter.AdIntroAdapter;
import com.app.java.grabfoodappproject.domain.model.Ad1;
import com.app.java.grabfoodappproject.domain.model.Food;
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
        List<Ad1> ad1List = createAd1List();
        AdIntroAdapter adAdapter = new AdIntroAdapter(ad1List,this::createDetailAd);
        adRecycler.setAdapter(adAdapter);
    }

    private void createDetailAd(Ad1 ad1) {
        Intent intent = new Intent(requireActivity(),AdDetailActivity.class);
        intent.putExtra(AdDetailActivity.IMAGE_ID_KEY, Utils.getAd1ImageId(ad1.getAdName()));
        startActivity(intent);
    }

    private List<Ad1> createAd1List() {
        List<Ad1> ad1List = new ArrayList<>();
        Ad1 ad1 = new Ad1("Đăng ký ngay","lotte","Combo siêu hời chỉ 499K,tiết kiệm đến 180K");
        Ad1 ad2 = new Ad1("Đặt ngay","pizzahut","Combo tựu trường giá chỉ từ 319K");
        Ad1 ad3 = new Ad1("Đặt đơn ngay","banh_mi","Mua 2 tặng 1 Burger Gà Giòn");
        Ad1 ad4 = new Ad1("Đặt ngay","highland","Giòn giã chuyện trăng");
        Ad1 ad5 = new Ad1("Đặt đơn ngay","highland2","Khuyến mãi nạp thẻ xịn sò");
        Ad1 ad6 = new Ad1("Đặt ngay","highland3","Quế ấm phin êm, phong vị độc đáo");
        ad1List.add(ad1);
        ad1List.add(ad2);
        ad1List.add(ad3);
        ad1List.add(ad4);
        ad1List.add(ad5);
        ad1List.add(ad6);
        return ad1List;
    }

    private void initFoodRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.food_recycler);
        List<Food> foodList = createFoodList();
        FoodAdapter adapter = new FoodAdapter(foodList, this::createDetailFood);
        recyclerView.setAdapter(adapter);
    }

    private void createDetailFood(Food food) {
        Intent intent = new Intent(requireActivity(), FoodActivity.class);
        intent.putExtra(FoodActivity.FOOD_KEY,food.getFoodName());
        intent.putExtra(FoodActivity.FOOD_KEY_IMAGE,food.getImageId());
        startActivity(intent);
    }

    private List<Food> createFoodList() {
        List<Food> foodList = new ArrayList<>();
        Food noodles = new Food(getString(R.string.noodle));
        Food rice = new Food(getString(R.string.rice));
        Food hotpot = new Food(getString(R.string.hotpot));
        Food healthyFood = new Food(getString(R.string.healthy_food));
        Food fastFood = new Food(getString(R.string.fast_food));
        Food coffee = new Food(getString(R.string.coffee));
        foodList.add(noodles);
        foodList.add(rice);
        foodList.add(healthyFood);
        foodList.add(hotpot);
        foodList.add(coffee);
        foodList.add(fastFood);
        return foodList;
    }
}
