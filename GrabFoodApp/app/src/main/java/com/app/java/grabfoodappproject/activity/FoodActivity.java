package com.app.java.grabfoodappproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.app.java.grabfoodappproject.R;

public class FoodActivity extends AppCompatActivity {
    public static final String FOOD_KEY = "FOOD_KEY";
    public static final String FOOD_KEY_IMAGE = "FOOD_KEY_IMAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        TextView textFoodName = findViewById(R.id.text_food_detail);
        ImageView image = findViewById(R.id.imageView9);
        textFoodName.setText(intent.getStringExtra(FOOD_KEY));
        image.setImageResource(intent.getIntExtra(FOOD_KEY_IMAGE, 0));
        ImageButton backButton = findViewById(R.id.icon_back_button);
        backButton.setOnClickListener(v -> {
            finish();
        });
    }
}
