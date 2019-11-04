package com.example.shopping_list.model;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ProductsListRead {

    private static final String filename = "products_list.json";
    private Object obj;
    private ArrayList<String> products;
    private JSONObject jo;

    public ProductsListRead(Context context) {

        products = new ArrayList<>();
        getFile(context);
        setProducts();
    }

    private void getFile(Context context) {
        File directory = context.getFilesDir();
        String filePath = directory.getPath();

        try {
            obj = new JSONParser().parse(new FileReader(filePath + "/" + filename));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        if (obj != null)
            jo = (JSONObject) obj;
    }

    private void setProducts() {

        if (jo != null){
            JSONArray productsList = (JSONArray) jo.get("list");

            Iterator iterator = productsList.iterator();

            while (iterator.hasNext())
            {
                Iterator<Map.Entry> entryIterator = ((Map) iterator.next()).entrySet().iterator();
                while (entryIterator.hasNext()) {
                    Map.Entry pair = entryIterator.next();

                    String value = (String) pair.getValue();
                    products.add(value);
                }
            }
        }
    }

    public ArrayList getProducts() {
        return products;
    }
}
