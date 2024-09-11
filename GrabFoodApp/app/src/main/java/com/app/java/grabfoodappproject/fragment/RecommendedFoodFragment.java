package com.app.java.grabfoodappproject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.adapter.DishAdapter;
import com.app.java.grabfoodappproject.adapter.ShopAdapter;
import com.app.java.grabfoodappproject.domain.model.Shop;
import com.app.java.grabfoodappproject.domain.model.ShopData;

import java.util.ArrayList;

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

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Shop> shopList = ShopData.getShopData();

        ShopAdapter itemShopAdapter = new ShopAdapter(shopList);

        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView.setAdapter(itemShopAdapter);

        //Nguyen's part
        ListView listView = view.findViewById(R.id.list_view);
        DishAdapter adapter = new DishAdapter(getActivity());
        listView.setAdapter(adapter);
    }
}