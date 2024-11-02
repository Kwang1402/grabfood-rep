package com.app.java.grabfoodappproject.ui.adapter.intro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.data.model.intro.IntroAds;
import com.app.java.grabfoodappproject.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AdIntroAdapter extends RecyclerView.Adapter<AdIntroAdapter.ViewHolder> {
    private final List<IntroAds> mIntroAdsList;
    private final onItemClickListener mListener;

    public AdIntroAdapter(List<IntroAds> introAdsList, onItemClickListener listener) {
        mListener = listener;
        if (introAdsList == null) {
            mIntroAdsList = new ArrayList<>();
        } else {
            mIntroAdsList = introAdsList;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.intro_item_ad, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mIntroAdsList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mIntroAdsList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemAdText;
        private final ImageView itemAdImage;
        private final TextView itemAdTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemAdText = itemView.findViewById(R.id.item_ad_text);
            itemAdImage = itemView.findViewById(R.id.item_ad_image);
            itemAdTitle = itemView.findViewById(R.id.item_ad_title);
        }

        public void bind(IntroAds introAds, onItemClickListener listener) {
            itemAdText.setText(introAds.getTitle());
            itemAdTitle.setText(introAds.getAdTitle());
            itemAdImage.setImageResource(Utils.getIntroAdImageId(introAds.getAdName()));
            itemView.setOnClickListener(v -> listener.onItemClick(introAds));
        }
    }

    public interface onItemClickListener {
        void onItemClick(IntroAds introAds);
    }
}
