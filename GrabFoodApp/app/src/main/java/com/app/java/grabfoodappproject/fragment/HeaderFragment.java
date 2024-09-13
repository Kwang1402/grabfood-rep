package com.app.java.grabfoodappproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.java.grabfoodappproject.R;
import com.app.java.grabfoodappproject.RestaurantActivity;

public class HeaderFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_header, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner spinnerLocation = view.findViewById(R.id.spinner_location);
        // create adapter
        ArrayAdapter<CharSequence> locationAdapter = ArrayAdapter.
                createFromResource(
                        requireContext(),
                        R.array.spinner_location,
                        R.layout.text_spinner
                );
        // create dropdown
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set adapter
        spinnerLocation.setAdapter(locationAdapter);

        ImageView imageFavourite = view.findViewById(R.id.ic_favourite);
       // ImageView imageOrder = view.findViewById(R.id.ic_order);

        imageFavourite.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), RestaurantActivity.class);
            startActivity(intent);
        });
    }
}
