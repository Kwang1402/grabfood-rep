package com.app.java.grabfoodappproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.domain.model.Ad1;
import com.app.java.grabfoodappproject.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Frag1Adapter extends RecyclerView.Adapter<Frag1Adapter.ViewHolder> {
    private final List<Ad1> mAd1List;

    public Frag1Adapter(List<Ad1> ad1List) {
        if(ad1List == null){
            mAd1List = new ArrayList<>();
        }else{
            mAd1List = ad1List;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_frag1,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mAd1List.get(position));
    }

    @Override
    public int getItemCount() {
        return mAd1List.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView itemAdText;
        private final ImageView itemAdImage;
        private final TextView itemAdTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemAdText = itemView.findViewById(R.id.item_ad_text);
            itemAdImage = itemView.findViewById(R.id.item_ad_image);
            itemAdTitle = itemView.findViewById(R.id.item_ad_title);
        }
        public void bind(Ad1 ad1){
            itemAdText.setText(ad1.getTitle());
            itemAdTitle.setText(ad1.getAdTitle());
            itemAdImage.setImageResource(Utils.getAd1ImageId(ad1.getAdName()));
        }
    }
}
