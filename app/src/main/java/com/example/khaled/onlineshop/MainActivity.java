package com.example.khaled.onlineshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.khaled.onlineshop.Adapters.ProductAdapter;
import com.example.khaled.onlineshop.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    List<Product> productList = new ArrayList();

    String[] fakeData = {"product1","product2","product3","product4","product5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i = 0;
        while (i < fakeData.length) {
            Product obj = new Product();

            obj.setProductName(fakeData[i]);
            productList.add(obj);
            i++;
        }
        Log.e("Main productList size ", String.valueOf(productList.size()));

        recyclerView = (RecyclerView) findViewById(R.id.product_list_recycler_view);

        productAdapter = new ProductAdapter(productList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(productAdapter);

        productAdapter.notifyDataSetChanged();
    }
}