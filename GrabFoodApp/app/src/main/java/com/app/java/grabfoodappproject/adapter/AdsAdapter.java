package com.app.java.grabfoodappproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.domain.model.Ads3;

import java.util.ArrayList;
import java.util.List;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.ViewHolder>{
    private final List<Ads3> listAds;

    public AdsAdapter(List<Ads3> listAds) {
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
                inflate(R.layout.item_ads, parent, false);
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
        private final TextView adsTitle;
        private final TextView adsDes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageItem = itemView.findViewById(R.id.ad_image);
            adsTitle = itemView.findViewById(R.id.ads_title);
            adsDes = itemView.findViewById(R.id.ads_des);
        }
        public void bind(Ads3 ads3)  {
            adsTitle.setText(ads3.getAdsTitle());
            adsDes.setText(ads3.getAdsDes());
            int imageId = ads3.getImageId();
            if(imageId != -1){
                imageItem.setImageResource(imageId);
            }else{
                imageItem.setImageResource(R.drawable.hu_tieu);
            }

        }
    }
}
