package com.app.java.grabfoodappproject.ui.fragment.intro;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Spinner;
import com.app.java.grabfoodappproject.BuildConfig;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.ui.activity.FoodOrdersActivity;
import com.app.java.grabfoodappproject.ui.activity.RestaurantActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HeaderFragment extends Fragment {
    private static final String MAPTILER_API_KEY = BuildConfig.MAPTILER_API_KEY;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro_header, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AutoCompleteTextView autoCompleteLocation = view.findViewById(R.id.auto_complete_location);
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, new ArrayList<>());
        autoCompleteLocation.setAdapter(locationAdapter);

        Handler handler = new Handler(Looper.getMainLooper());
        Runnable queryRunnable = new Runnable() {
            @Override
            public void run() {
                String query = autoCompleteLocation.getText().toString();
                if (!query.isEmpty()) {
                    fetchLocationSuggestions(query, locationAdapter);
                }
            }
        };

        autoCompleteLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                handler.removeCallbacks(queryRunnable);
                handler.postDelayed(queryRunnable, 500);
            }
        });

        ImageView imageFavourite = view.findViewById(R.id.ic_favourite);
        ImageView imageOrders = view.findViewById(R.id.ic_order);

        imageFavourite.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), RestaurantActivity.class);
            startActivity(intent);
        });

        imageOrders.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), FoodOrdersActivity.class);
            startActivity(intent);
        });
    }

    private void fetchLocationSuggestions(String query, ArrayAdapter<String> locationAdapter) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            List<String> result = getLocationSuggestions(query);
            getActivity().runOnUiThread(() -> {
                locationAdapter.clear();
                locationAdapter.addAll(result);
                locationAdapter.notifyDataSetChanged();
            });
        });
    }

    private List<String> getLocationSuggestions(String query) {
        List<String> suggestions = new ArrayList<>();
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
            String urlString = "https://api.maptiler.com/geocoding/" + encodedQuery + ".json?key=" + MAPTILER_API_KEY;

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray features = jsonResponse.getJSONArray("features");

            for (int i = 0; i < features.length(); i++) {
                JSONObject feature = features.getJSONObject(i);
                String placeName = new String(feature.getString("place_name").getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
                suggestions.add(placeName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suggestions;
    }
}
