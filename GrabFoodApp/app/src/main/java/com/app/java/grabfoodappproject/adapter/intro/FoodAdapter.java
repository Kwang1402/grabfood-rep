package com.app.java.grabfoodappproject.adapter.intro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.domain.model.intro.FoodIntro;
import com.app.java.grabfoodappproject.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private final List<FoodIntro> mFoodLists;
    private final onItemClickListener mListener;

    public FoodAdapter(List<FoodIntro> foodLists, onItemClickListener listener) {
        mListener = listener;
        if(foodLists == null){
            mFoodLists = new ArrayList<>();
        }else{
            mFoodLists = foodLists;
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.intro_item_food,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mFoodLists.get(position),mListener);
    }

    @Override
    public int getItemCount() {
        return mFoodLists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imageItem;
        private final TextView textItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageItem = itemView.findViewById(R.id.item_food_image);
            textItem = itemView.findViewById(R.id.item_food_text);
        }
        public void bind(FoodIntro food, onItemClickListener listener){
            textItem.setText(food.getFoodName());
            imageItem.setImageResource(Utils.getFoodImageId(food.getFoodName()));
            itemView.setOnClickListener(v -> listener.onItemClick(food));
        }
    }

    public interface onItemClickListener{
        void onItemClick(FoodIntro food);
    }
}
