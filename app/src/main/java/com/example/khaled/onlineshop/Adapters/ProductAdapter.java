package com.example.khaled.onlineshop.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khaled.onlineshop.R;
import com.example.khaled.onlineshop.models.Product;

import java.util.List;

/**
 * Created by Khaled on 2017-09-14.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<Product> productList;
    private int currentId;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productNameTxt;

        public ViewHolder(View view) {
            super(view);
            productNameTxt = (TextView) view.findViewById(R.id.list_product_name);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show();
        }
    }

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.porduct_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {

        Log.e("productList size ", String.valueOf(productList.size()));
        Product product = productList.get(position);
        holder.productNameTxt.setText(product.getProductName());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
