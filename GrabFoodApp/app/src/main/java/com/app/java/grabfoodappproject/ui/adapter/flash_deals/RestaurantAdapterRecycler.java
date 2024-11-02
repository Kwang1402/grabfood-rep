package com.app.java.grabfoodappproject.ui.adapter.flash_deals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.data.model.flash_deals.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapterRecycler extends RecyclerView
        .Adapter<RestaurantAdapterRecycler.ViewHolder> {

    private final List<Restaurant> mRestaurants;

    public RestaurantAdapterRecycler(List<Restaurant> restaurants) {
        if(restaurants == null){
            mRestaurants = new ArrayList<>();
        }else{
            mRestaurants = restaurants;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flashdeal_item_restaurant,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView textName;
        private final TextView textReview;
        private final TextView textPrice;
        private final TextView textDiscountPercent;
        private final TextView textDiscount;
        private final ImageView itemImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.restaurantName);
            textReview = itemView.findViewById(R.id.restaurantReview);
            textPrice = itemView.findViewById(R.id.restaurantPrice);
            textDiscountPercent = itemView.findViewById(R.id.restaurantPercentageDiscount);
            textDiscount = itemView.findViewById(R.id.restaurantPriceDiscount);
            itemImage = itemView.findViewById(R.id.restaurantImage);
        }
        public void bind(Restaurant restaurant){
            textName.setText(restaurant.getName());
            textReview.setText(restaurant.getReview());
            textPrice.setText(restaurant.getPrice());
            textDiscountPercent.setText(restaurant.getPercentageDiscount());
            textDiscount.setText(restaurant.getPriceDiscount());
            itemImage.setImageResource(restaurant.getImageResId());
        }
    }
}
