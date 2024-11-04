package com.app.java.grabfoodappproject.ui.adapter.intro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.data.model.Food;
import com.app.java.grabfoodappproject.data.model.intro.FoodIntro;
import com.app.java.grabfoodappproject.utils.Utils;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
  //  private final List<FoodIntro> mFoodLists;
    private final List<Food> mFoodLists;
    private final onItemClickListener mListener;

    public FoodAdapter(List<Food> foodLists, onItemClickListener listener) {
        mListener = listener;
        if(foodLists == null){
            mFoodLists = new ArrayList<>();
        }else{
            mFoodLists = foodLists;
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateFoods(List<Food> foods){
        mFoodLists.clear();
        mFoodLists.addAll(foods);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_intro_food,parent,false);
        return new ViewHolder(itemView,parent.getContext());
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
        private final Context mContext;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            imageItem = itemView.findViewById(R.id.item_food_image);
            textItem = itemView.findViewById(R.id.item_food_text);
            mContext = context;
        }
        public void bind(Food food, onItemClickListener listener){
            textItem.setText(food.getName());
         //   imageItem.setImageResource(Utils.getFoodImageId(food.getFoodName()));
            itemView.setOnClickListener(v -> listener.onItemClick(food));
            Glide.with(mContext)
                    .load(food.getImage())
                    .error(R.drawable.rice)
                    .into(imageItem);
        }
    }

    public interface onItemClickListener{
        void onItemClick(Food food);
    }
}
