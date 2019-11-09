package com.example.shopping_list.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shopping_list.R;
import com.example.shopping_list.presenter.MainPagePresenter;
import com.example.shopping_list.сontract.MainPageContract;

public class MainPageFragment extends Fragment implements MainPageContract.View, View.OnClickListener {

    private MainPageContract.Presenter presenter;
    private ProductsListFragment productsListFragment;
    private EditText product;
    private Button add;
    private Button view;
    private Button save;

    public MainPageFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MainPagePresenter(this, getContext());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_page, container, false);

        add = root.findViewById(R.id.button_add_product);
        view = root.findViewById(R.id.button_view_products);
        product = root.findViewById(R.id.edit_text_product);
        save = root.findViewById(R.id.button_save);

        add.setOnClickListener(this);
        view.setOnClickListener(this);
        save.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_add_product) {

                presenter.addButtonClick(getTextProduct());
                Log.d("button_add", "Clicked");
        }
        else if (view.getId() == R.id.button_view_products) {
            productsListFragment = new ProductsListFragment();

            presenter.viewButtonClick(getActivity(), productsListFragment);

            Log.d("button_view", "Clicked");
        }
        else if (view.getId() == R.id.button_save) {
            presenter.saveButtonClick();

            Log.d("button_save", "Clicked");
        }
    }

    public String getTextProduct(){
        return product.getText().toString();
    }

    @Override
    public String getProduct() {
        return null;
    }

    @Override
    public void setProduct() {

    }

    @Override
    public int getLengthProductName() {
        return product.length();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
