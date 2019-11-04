package com.example.shopping_list.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shopping_list.R;
import com.example.shopping_list.presenter.ProductsListPresenter;
import com.example.shopping_list.сontract.ProductsListContract;

public class ProductsListFragment extends Fragment implements ProductsListContract.View {

    private ListView productsList;
    private ProductsListContract.Presenter presenter;

    public ProductsListFragment() {
        presenter = new ProductsListPresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_products_list_fargment, container, false);

        productsList = root.findViewById(R.id.list_view_products_list);


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter.setProductList(getContext());
    }

    @Override
    public void setList(ArrayAdapter adapter) {
        productsList.setAdapter(adapter);
    }
}
