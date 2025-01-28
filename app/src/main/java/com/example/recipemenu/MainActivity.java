package com.example.recipemenu;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        // Load initial fragment
        if (savedInstanceState == null) {
            loadFragment(new Cusinelistfragment(), "f1",new Recipelistfragment());
        }

    }

    public void loadFragment(Fragment fragment, String tag,Fragment remove) {

        Log.d("-----------", "loadFragment: pressed");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment, tag);
        transaction.remove(remove);
        transaction.addToBackStack(null);
        transaction.commit();

    }



}