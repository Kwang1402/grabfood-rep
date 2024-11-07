package com.app.java.grabfoodappproject.ui.fragment.intro;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.BuildConfig;
import com.app.java.grabfoodappproject.data.model.Food;
import com.app.java.grabfoodappproject.data.model.intro.FoodIntro;
import com.app.java.grabfoodappproject.data.model.intro.IntroAds;
import com.app.java.grabfoodappproject.data.repository.RemoteRepository;
import com.app.java.grabfoodappproject.data.repository.Repository;
import com.app.java.grabfoodappproject.ui.activity.AdDetailActivity;
import com.app.java.grabfoodappproject.ui.activity.FoodActivity;
import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.ui.adapter.intro.FoodAdapter;
import com.app.java.grabfoodappproject.ui.adapter.intro.AdIntroAdapter;
import com.app.java.grabfoodappproject.ui.viewmodel.FoodListViewModel;
import com.app.java.grabfoodappproject.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class IntroFragment extends Fragment {
    private FoodAdapter mFoodListAdapter;
    private FoodListViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro, container, false);
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
        AdIntroAdapter adAdapter = new AdIntroAdapter(introAdsList, this::createDetailAd);
        adRecycler.setAdapter(adAdapter);
    }

    private void createDetailAd(IntroAds introAds) {
        Intent intent = new Intent(requireActivity(), AdDetailActivity.class);
        intent.putExtra(AdDetailActivity.IMAGE_ID_KEY, Utils.getIntroAdImageId(introAds.getAdName()));
        startActivity(intent);
    }

    private List<IntroAds> createAd1List() {
        List<IntroAds> introAdsList = new ArrayList<>();
        IntroAds introAds = new IntroAds("Đăng ký ngay", "lotte", "Combo siêu hời chỉ 499K, tiết kiệm đến 180K");
        IntroAds ad2 = new IntroAds("Đặt ngay", "pizzahut", "Combo tựu trường giá chỉ từ 319K");
        IntroAds ad3 = new IntroAds("Đặt đơn ngay", "banh_mi", "Mua 2 tặng 1 Burger Gà Giòn");
        IntroAds ad4 = new IntroAds("Đặt ngay", "highland", "Giòn giã chuyện trăng");
        IntroAds ad5 = new IntroAds("Đặt đơn ngay", "highland2", "Khuyến mãi nạp thẻ xịn sò");
        IntroAds ad6 = new IntroAds("Đặt ngay", "highland3", "Quế ấm phin êm, phong vị độc đáo");
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
        mFoodListAdapter = new FoodAdapter(new ArrayList<>(), this::createDetailFood);
        Repository repository = new RemoteRepository();
        mViewModel = new FoodListViewModel(repository);
        recyclerView.setAdapter(mFoodListAdapter);
        registerObserver();
    }

    private void registerObserver() {
        mViewModel.foods.observe(getViewLifecycleOwner(), foods -> {
            if(foods == null){
                Toast.makeText(requireContext(),"Call API fail",Toast.LENGTH_SHORT).show();
            }else{
                mFoodListAdapter.updateFoods(foods);
                Toast.makeText(requireContext(),"Call API success",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createDetailFood(Food food) {
        Intent intent = new Intent(requireActivity(), FoodActivity.class);
//        intent.putExtra(FoodActivity.FOOD_KEY,food.getFoodName());
//        intent.putExtra(FoodActivity.FOOD_KEY_IMAGE,food.getImageId());
        startActivity(intent);
    }
}
