package com.app.java.grabfoodappproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.models.Ads2;

import java.util.ArrayList;
import java.util.List;

public class Ads2Adapter extends RecyclerView.Adapter<Ads2Adapter.ViewHolder>{
    private final List<Ads2> listAds;

    public Ads2Adapter(List<Ads2> listAds) {
        if (listAds == null)    {
            this.listAds = new ArrayList<>();
        }   else {
            this.listAds = listAds;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_flash_deal, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listAds.get(position));
    }

    @Override
    public int getItemCount() {
        return listAds.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageItem;
        private final TextView textTilte;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageItem = itemView.findViewById(R.id.item_image1);
            textTilte = itemView.findViewById(R.id.text_title);
        }
        public void bind(Ads2 ads2)  {
            textTilte.setText(ads2.getTextTitle());
            int imageId = ads2.getImageId();
            if(imageId != -1){
                imageItem.setImageResource(imageId);
            }else{
                imageItem.setImageResource(R.drawable.noodle);
            }

        }
    }
}
