package com.example.shopping_list.сontract;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public interface MainPageContract {

    interface View {

        void showMessage(String message);

        String getProduct();
        void setProduct();
    }

    interface Presenter {
        void addButtonClick(String text);
        void viewButtonClick(FragmentActivity activity, Fragment fragment);
        void saveButtonClick();

        void setText(String text);
    }

    interface Model {

    }
}
