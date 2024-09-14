package com.app.java.grabfoodappproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.domain.model.Food4;

import java.util.ArrayList;
import java.util.List;

public class CrowdPickAdapter extends RecyclerView.Adapter<CrowdPickAdapter.ViewHolder>{
    private final List<Food4> mFood4List;

    public CrowdPickAdapter(List<Food4> food4List) {
        if(food4List == null){
            mFood4List = new ArrayList<>();
        }else{
            mFood4List = food4List;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_recycler_horizontal4,parent,false
        );
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mFood4List.get(position));
    }

    @Override
    public int getItemCount() {
        return mFood4List.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView itemImage;
        private final TextView itemSale;
        private final TextView itemFood;
        private final TextView itemTime;
        private final TextView itemDistance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image_4);
            itemSale = itemView.findViewById(R.id.item_sale4);
            itemFood = itemView.findViewById(R.id.item_food_4);
            itemTime = itemView.findViewById(R.id.item_time_4);
            itemDistance = itemView.findViewById(R.id.item_distance_4);
        }
        public void bind(Food4 food4){
            itemImage.setImageResource(food4.getImageId());
            itemSale.setText(food4.getSale());
            itemFood.setText(food4.getFoodName());
            itemTime.setText(food4.getTime());
            itemDistance.setText(food4.getDistance());
        }
    }
}
