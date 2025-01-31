package com.example.recipemenu;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class Cusinelistfragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cusinelistfragment, container, false);

        GridView gridView = view.findViewById(R.id.cuisine_grid);
        TextView txt = view.findViewById(R.id.textView2);

//        animation view set karva mate
        Animation animati = AnimationUtils.loadAnimation(getContext(), R.anim.blink);
        txt.startAnimation(animati);

//        adapter set karva mate
        CuisineAdapter adapter = new CuisineAdapter(getContext());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Open RecipeListFragment for selected cuisine
//                gridview ma selected recipe fragment ni position ma java mate
                Fragment recipeFragment = Recipelistfragment.newInstance(position);

                ((MainActivity) requireActivity()).loadFragment(recipeFragment);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return false;
                }
                return false;
            }
        });
    }
}

