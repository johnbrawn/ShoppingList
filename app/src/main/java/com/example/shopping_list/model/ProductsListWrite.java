package com.example.shopping_list.model;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.shopping_list.сontract.ProductsListContract;

public class ProductsListWrite implements ProductsListContract.ModelWrite {

    private static final String filename = "products_list.json";
    private JSONObject productListJson;
    private JSONArray ja;
    private String filePath;
    private Context context;

    public ProductsListWrite(Context context) {
        this.context = context;
        isFileCreated();
        createJsonObject();
        ja = new JSONArray();
        createNewRecord();
    }

    public boolean isFileCreated() {

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

        return file.exists();
    }

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
        Map m = new LinkedHashMap();
        m.put("name", productName);

        ja.add(m);
    }

    @Override
    public void setData(String product) {
        setProduct(product);
    }

    @Override
    public void saveProductsList() {

        setProductsToList();

        PrintWriter pw = null;
        try {
            Log.e("ProductsListModel", "PrintWriter");
            pw = new PrintWriter(filePath + "/" + filename);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (pw != null) {
            Log.e("ProductsListModel", "PrintWriterNotNull");
            pw.write(productListJson.toJSONString());
            pw.flush();
            pw.close();
        }
    }
}
