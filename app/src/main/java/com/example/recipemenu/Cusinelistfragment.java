package com.example.recipemenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Cusinelistfragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cusinelistfragment, container, false);

        GridView gridView = view.findViewById(R.id.cuisine_grid);
        CuisineAdapter adapter = new CuisineAdapter(getContext());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Open RecipeListFragment for selected cuisine
                Fragment recipeFragment = Recipelistfragment.newInstance(position);
                ((MainActivity) getActivity()).loadFragment(recipeFragment);
            }
        });


        return view;
    }

}

