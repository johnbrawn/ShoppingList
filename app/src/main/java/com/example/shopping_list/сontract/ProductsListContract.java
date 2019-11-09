package com.example.shopping_list.сontract;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public interface ProductsListContract {
    interface View {
        void setList(ArrayAdapter adapter);
    }

    interface Presenter {
        void setProductList(Context context);
    }

    interface Model {
        ArrayList getProducts();
        void setContext(Context context);
        void setProduct(String name);
        void saveProductsList();
    }

    interface ModelWrite {
        void createJsonObject();
        String getCurrentDate();
        void createNewRecord();
        void setProductsToList();
        void createFile(Context context);
        void setProduct(String productName);
        void setData(String product);
        void saveProductsList();
    }

    interface ModelRead {

    }
}
