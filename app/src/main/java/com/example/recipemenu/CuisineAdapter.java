package com.example.recipemenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CuisineAdapter extends BaseAdapter {

    private final Context context;
    private final int[] cuisineImages = {R.drawable.italian, R.drawable.indian, R.drawable.chinese, R.drawable.mexican, R.drawable.japanese,
            R.drawable.thai, R.drawable.french, R.drawable.greek, R.drawable.mediterranean, R.drawable.korean};
    private final String[] cuisineNames = {"Italian", "Indian", "Chinese", "Mexican", "Japanese", "Thai", "French", "Greek", "Mediterranean", "Korean"};

    public CuisineAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return cuisineNames.length;
    }

    @Override
    public Object getItem(int position) {
        return cuisineNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cuisine, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.cuisine_image);
        TextView textView = convertView.findViewById(R.id.cuisine_name);

        imageView.setImageResource(cuisineImages[position]);
        textView.setText(cuisineNames[position]);

        return convertView;
    }

}
