package com.app.java.grabfoodappproject.ui.adapter.recommended;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.data.model.recommended.RecommendedShop;

import java.util.ArrayList;

/*transport data to recyclerview*/
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder>{
    private ArrayList<RecommendedShop> shoplist;

    public ShopAdapter(ArrayList<RecommendedShop> shoplist) {
        this.shoplist = shoplist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_recycler_view_item, parent, false);
        return new MyViewHolder(itemView);
    }

    public int getItemCount() {
        return shoplist.size();
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecommendedShop currShop = shoplist.get(position);
        holder.shopImage.setImageResource(currShop.getResourceId());
        holder.name.setText(currShop.getName());
        holder.discount.setText(currShop.getDiscount());
        holder.detail.setText(currShop.getDetail());

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView shopImage;
        private TextView name;
        private TextView discount;
        private TextView detail;

        public MyViewHolder (View itemView) {
            super(itemView);
            shopImage = itemView.findViewById(R.id.item_image_recommend);
            name = itemView.findViewById(R.id.name);
            discount = itemView.findViewById(R.id.discount);
            detail = itemView.findViewById(R.id.detail);
        }
    }

}
