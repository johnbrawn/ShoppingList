package com.example.shopping_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.shopping_list.view.MainPageFragment;
import com.example.shopping_list.view.ProductsListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MainPageFragment fragment = new MainPageFragment();
        fragment.setArguments(getIntent().getExtras());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_page_fragment_container, fragment, "MainPageFragment")
                .addToBackStack(null)
                .commit();
    }
}
