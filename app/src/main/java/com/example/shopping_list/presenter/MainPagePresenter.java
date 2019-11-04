package com.example.shopping_list.presenter;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.shopping_list.R;
import com.example.shopping_list.model.ProductsListModel;
import com.example.shopping_list.сontract.MainPageContract;
import com.example.shopping_list.сontract.ProductsListContract;

public class MainPagePresenter implements MainPageContract.Presenter {

    private MainPageContract.View view;
    private ProductsListContract.Model model;

    public MainPagePresenter(MainPageContract.View view, Context context) {
        this.view = view;
        model = new ProductsListModel(context);
    }

    @Override
    public void addButtonClick(String text) {
        if (view != null) {
            view.showMessage(text);
            model.setData(text);
        }
    }

    @Override
    public void viewButtonClick(FragmentActivity activity, Fragment fragment) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_page_fragment_container, fragment,"ProductsListFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void saveButtonClick() {
        model.saveProductsList();
    }

    @Override
    public void setText(String text) {

    }
}
