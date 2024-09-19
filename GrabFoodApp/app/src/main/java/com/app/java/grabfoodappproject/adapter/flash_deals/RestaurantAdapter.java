package com.app.java.grabfoodappproject.adapter.flash_deals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.domain.model.flash_deals.Restaurant;

import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {
//    private int layoutResource;
    private Context context;
    private List<Restaurant> restaurants;

    public RestaurantAdapter(Context context, List<Restaurant> restaurants) {
        super(context, 0, restaurants);
        this.context = context;
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Inflate the view if it doesn't exist yet
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.flashdeal_item_restaurant, parent, false);
        }

        // Get the current restaurant item
        Restaurant currentItem = getItem(position);

        // Find the views and populate with data
        TextView nameTextView = view.findViewById(R.id.restaurantName);
        TextView reviewTextView = view.findViewById(R.id.restaurantReview);
        TextView priceTextView = view.findViewById(R.id.restaurantPrice);
        TextView percentageDiscountTextView = view.findViewById(R.id.restaurantPercentageDiscount);
        TextView priceDiscountTextView = view.findViewById(R.id.restaurantPriceDiscount);
        ImageView restaurantImageView = view.findViewById(R.id.restaurantImage);

        // Set data to the views
        assert currentItem != null;
        nameTextView.setText(currentItem.getName());
        reviewTextView.setText(currentItem.getReview());
        priceTextView.setText(currentItem.getPrice());
        percentageDiscountTextView.setText(currentItem.getPercentageDiscount());
        priceDiscountTextView.setText(currentItem.getPriceDiscount());
        restaurantImageView.setImageResource(currentItem.getImageResId());

        return view;
    }
}
