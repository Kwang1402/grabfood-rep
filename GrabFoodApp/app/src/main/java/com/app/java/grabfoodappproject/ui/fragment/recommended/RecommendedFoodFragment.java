package com.app.java.grabfoodappproject.ui.fragment.recommended;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.data.model.flash_deals.Restaurant;
import com.app.java.grabfoodappproject.data.model.recommended.RecommendedShop;
import com.app.java.grabfoodappproject.ui.adapter.flash_deals.RestaurantAdapterRecycler;
import com.app.java.grabfoodappproject.ui.adapter.recommended.ShopAdapter;
import com.app.java.grabfoodappproject.domain.mock_data.ShopData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecommendedFoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecommendedFoodFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecommendedFoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecommendedFood.
     */
    // TODO: Rename and change types and number of parameters
    public static RecommendedFoodFragment newInstance(String param1, String param2) {
        RecommendedFoodFragment fragment = new RecommendedFoodFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_recommended_food, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<RecommendedShop> shopList = ShopData.getShopData();

        ShopAdapter itemShopAdapter = new ShopAdapter(shopList);

        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView.setAdapter(itemShopAdapter);

        RecyclerView recyclerRestaurant = view.findViewById(R.id.rc_recycler_vertical);
        List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant("Bún Đậu Hà Thành", "4.1 (317) • $$$$ • Noodles", "10.000đ 1̶5̶.̶0̶0̶0̶đ̶ • From 40 mins","50% off","15.000đ", R.drawable.rec_bundau));
        restaurants.add(new Restaurant("Bún Trộn Gánh Phố Cổ", "3.9 (200) • $$$$ • Noodles", "Free 1̶5̶.̶0̶0̶0̶đ̶ • From 40 mins", "5% off", "10.000đ", R.drawable.rec_buntron));
        restaurants.add(new Restaurant("Pizza Hut", "4.8 (789) • $$$$ • Pizza", "100.000đ 1̶2̶0̶.̶0̶0̶0̶đ̶ • From 35 mins", "20% off", "12.000đ", R.drawable.rec_pizza));
        restaurants.add(new Restaurant("Cháo Quẩy Trung Tự","5.0 (650) • $$$$ • Porrige","35.000đ • From 20 mins","10% off","Free Pepsi",R.drawable.rec_chao));

        // Set the custom adapter
        RestaurantAdapterRecycler adapter = new RestaurantAdapterRecycler(restaurants);
        recyclerRestaurant.setAdapter(adapter);

        /*ListView listView = view.findViewById(R.id.list_view);
        DishAdapter adapter = new DishAdapter(getActivity());
        listView.setAdapter(adapter);   */
    }
}