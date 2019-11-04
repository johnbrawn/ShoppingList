package com.example.shopping_list.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.shopping_list.model.ProductsListModel;
import com.example.shopping_list.сontract.ProductsListContract;

import java.util.ArrayList;

public class ProductsListPresenter implements ProductsListContract.Presenter {

    private ProductsListContract.View view;
    private ArrayList<String> products;
    private ProductsListContract.Model model;

    public ProductsListPresenter(ProductsListContract.View view) {
        this.view = view;
        model = new ProductsListModel();
    }

    @Override
    public void setProductList(Context context) {
        model.setContext(context);
        products = model.getProducts();

        ArrayAdapter<ArrayList> adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, products);

        view.setList(adapter);
    }
}
