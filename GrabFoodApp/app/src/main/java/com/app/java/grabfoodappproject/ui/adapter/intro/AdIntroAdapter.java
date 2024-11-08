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
import com.app.java.grabfoodappproject.data.model.Ad;
import com.app.java.grabfoodappproject.data.model.intro.IntroAds;
import com.app.java.grabfoodappproject.utils.Utils;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdIntroAdapter extends RecyclerView.Adapter<AdIntroAdapter.ViewHolder> {
//    private final List<IntroAds> mIntroAdsList;
    private final List<Ad> mAds;
    private final onItemClickListener mListener;

    public AdIntroAdapter(List<Ad> mIntroAdsList, onItemClickListener listener) {
        mListener = listener;
        if(mIntroAdsList == null){
            mAds = new ArrayList<>();
        }else{
            mAds = mIntroAdsList;
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateAdList(List<Ad> adList){
        mAds.clear();
        mAds.addAll(adList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.intro_item_ad,parent,false);
        return new ViewHolder(itemView,parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mAds.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mAds.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemAdTitle;
        private final ImageView itemAdImage;
        private final TextView itemAdDescription;
        private final Context mContext;

        public ViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            itemAdTitle = itemView.findViewById(R.id.item_ad_text);
            itemAdImage = itemView.findViewById(R.id.item_ad_image);
            itemAdDescription = itemView.findViewById(R.id.item_ad_title);
            mContext = context;
        }

        public void bind(Ad introAds, onItemClickListener listener) {
//            itemAdText.setText(introAds.getTitle());
//            itemAdTitle.setText(introAds.getAdTitle());
//            itemAdImage.setImageResource(Utils.getIntroAdImageId(introAds.getAdName()));
            itemView.setOnClickListener(v -> listener.onItemClick(introAds));
            itemAdTitle.setText(introAds.getTitle());
            itemAdDescription.setText(introAds.getDescription());
            Glide.with(mContext)
                    .load(introAds.getImage())
                    .error(R.drawable.rice)
                    .into(itemAdImage);
        }
    }

    public interface onItemClickListener {
        void onItemClick(Ad introAds);
    }
}
