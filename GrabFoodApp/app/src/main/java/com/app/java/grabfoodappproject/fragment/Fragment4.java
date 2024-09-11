package com.app.java.grabfoodappproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.adapter.Food4Adapter;
import com.app.java.grabfoodappproject.domain.model.Food4;

import java.util.ArrayList;
import java.util.List;

public class Fragment4 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment4,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerFood = view.findViewById(R.id.recycler_horizontal4);
        List<Food4> food4List = createFood4List();
        Food4Adapter food4Adapter = new Food4Adapter(food4List);
        recyclerFood.setAdapter(food4Adapter);
    }

    private List<Food4> createFood4List() {
        List<Food4> list = new ArrayList<>();
        Food4 bunDau = new Food4(R.drawable.rec_bundau,"20% off",
                "Bún đậu siu ngon","30 mins","3.3km");
        Food4 bunTron = new Food4(R.drawable.rec_buntron,"10.000đ off · 20000đ off",
                "Bún trộn bà Gia","20 mins","2.8km");
        Food4 chao = new Food4(R.drawable.rec_chao,"10.000đ off · 15000đ off",
                "Cháo thơm từ thịt ","10 mins","1.1km");
        Food4 comGa = new Food4(R.drawable.rec_comga,"30% off",
                "Cơm gà Bento Delichi","15 mins","0.8km");
        Food4 comXiu = new Food4(R.drawable.rec_comxiu,"20% off · 20000đ off",
                "Cơm thố Anh Nguyễn","10 mins","2.8km");
        Food4 pizza = new Food4(R.drawable.rec_pizza,"10.000đ off · 20000đ off",
                "The Pizza Company","20 mins","2.8km");

        list.add(bunDau);
        list.add(bunTron);
        list.add(chao);
        list.add(comGa);
        list.add(comXiu);
        list.add(pizza);
        return list;
    }
}
