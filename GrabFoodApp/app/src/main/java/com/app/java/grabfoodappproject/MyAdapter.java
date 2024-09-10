package com.app.java.grabfoodappproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    protected Context context;
    private ArrayList<DishData> dish;

    public MyAdapter(Context context){
        this.context = context;
        this.dish = new ArrayList<>();

        dish.add(new DishData(R.drawable.rec_bundau,R.drawable.ad_material,"Bún Đậu Võ Hồng Quang","4.1 (317) · $$$$ · Noodles","5.000₫ · 20 mins or more", "100% off"));
        dish.add(new DishData(R.drawable.rec_banhmi,0,"Bánh Mì Gà Teriyaki","4.5 (361) · $$$$ · Bread", "29.000₫ · 15 mins or more", "20% off"));
        dish.add(new DishData(R.drawable.rec_caphe,0,"Cà Phê Chú Long","4.7 (376)· $$$$ · Coffee","30.000₫ · 10 mins or more","7.000₫ off"));
        dish.add(new DishData(R.drawable.rec_comga,R.drawable.ad_material,"Cơm Gà Hợp Tác Xã","4.5 (25) · $$$$ · Rice","50.000₫ · 26 mins or more","Free 1 Pepsi"));
        dish.add(new DishData(R.drawable.rec_buntron,0,"Bún Trộn Đức Tâm","3.5 (210)· $$$$ · Noodles","35.000₫ · 32 mins or more","Buy 2 get 1"));
        dish.add(new DishData(R.drawable.rec_chao,R.drawable.ad_material,"Cháo Sườn Ngon Ngon","4.1 (145)· $$$$ · Porrige","25.000₫ · 9 mins or more","Free ship"));
        dish.add(new DishData(R.drawable.rec_comxiu,0,"Cơm Thố Bách Khoa","4.9 (512)· $$$$ · Rice","40.000₫ · 23 mins or more","10.000₫ off"));



    }

    @Override
    public int getCount() {
        return dish.size();
    }

    @Override
    public Object getItem(int position) {
        return dish.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.specific_item, parent, false);
        }

        // Find the views in the custom layout
        //MainImage
        ImageView main_image = convertView.findViewById(R.id.mainImage);
        //First row
        ImageView title_image = convertView.findViewById(R.id.title_image);
        TextView title = convertView.findViewById(R.id.title);
        //Second row
        ImageView star = convertView.findViewById(R.id.star);
        TextView information = convertView.findViewById(R.id.information);
        //Third row
        ImageView infinity = convertView.findViewById(R.id.infinity);
        TextView price = convertView.findViewById(R.id.price);
        //Fourth row
        ImageView price_tag = convertView.findViewById(R.id.pricetag);
        TextView discount = convertView.findViewById(R.id.discount);



        //get current position
        DishData dishData = dish.get(position);



        //Set the data for each view
        main_image.setImageResource(dishData.getMainImage());
        //condition for AD to appear, if there is null, title_image invisible
        if (dishData.getTitleImage() != 0) {
            title_image.setVisibility(View.VISIBLE);
            title_image.setImageResource(dishData.getTitleImage());
        } else {
            title_image.setVisibility(View.GONE);
        }
        title.setText(dishData.getTitle());

        star.setImageResource(R.drawable.star);
        information.setText(dishData.getInformation());

        infinity.setImageResource(R.drawable.infinity);
        price.setText(dishData.getPrice());

        price_tag.setImageResource(R.drawable.price_tag);
        discount.setText(dishData.getDiscount());

        return convertView;
    }
}