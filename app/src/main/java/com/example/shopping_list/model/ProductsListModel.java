package com.example.shopping_list.model;

import android.content.Context;
import android.util.Log;

import com.example.shopping_list.сontract.ProductsListContract;

import java.util.ArrayList;

public class ProductsListModel implements ProductsListContract.Model {

    private Context context;
    private ProductsListWrite productsListWrite;

    public ProductsListModel() {

    }

    public ProductsListModel(Context context) {
        Log.e("ProductsListModel", "Construvtor");
        this.context = context;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void setProduct(String name) {
        if (context != null || productsListWrite == null) {
            productsListWrite = new ProductsListWrite(context);
        }
        productsListWrite.setProduct(name);

    }

    @Override
    public void saveProductsList(){
        if (productsListWrite != null) {
            productsListWrite.saveProductsList();
        }
    }

    @Override
    public ArrayList getProducts() {
        ProductsListRead productsListRead = new ProductsListRead(context);

        return productsListRead.getProducts();
    }
}
