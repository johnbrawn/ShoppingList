package com.example.shopping_list.model;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.shopping_list.сontract.ProductsListContract;

public class ProductsListWrire implements ProductsListContract.ModelWrite {

    private static final String filename = "products_list.json";
    private JSONObject productListJson;
    private JSONArray ja;
    private String filePath;

    @Override
    public void createJsonObject() {
        Log.e("ProductsListModel", "productListJson");
        productListJson = new JSONObject();
    }

    @Override
    public String getCurrentDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return date.format(formatter);
    }

    @Override
    public void createNewRecord() {
        String currentDay = getCurrentDate();

        productListJson.put("day", currentDay);
    }

    @Override
    public void setProductsToList() {
        productListJson.put("list", ja);
    }

    @Override
    public void createFile(Context context) {
        File directory = context.getFilesDir();
        filePath = directory.getPath();
        File file = new File(directory, filename);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setProduct(String productName) {

    }
}
