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
        void setData(String product);
        void saveProductsList();
        ArrayList getProducts();
        void setContext(Context context);
    }

    interface ModelWrite {
        void createJsonObject();
        String getCurrentDate();
        void createNewRecord();
        void setProductsToList();
        void createFile(Context context);
        void setProduct(String productName);
    }

    interface ModelRead {

    }
}
