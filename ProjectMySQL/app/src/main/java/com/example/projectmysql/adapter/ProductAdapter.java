package com.example.projectmysql.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.*;
import android.widget.*;

import com.example.projectmysql.R;
import com.example.projectmysql.controller.ProductController;
import com.example.projectmysql.model.TelescopeProduct;
import com.example.projectmysql.view.FormActivity;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<TelescopeProduct> {
    private Context context;
    private List<TelescopeProduct> products;
    private ProductController controller;
    private Runnable refreshCallback;

    public ProductAdapter(Context context, List<TelescopeProduct> products, Runnable refreshCallback) {
        super(context, 0, products);
        this.context = context;
        this.products = products;
        this.controller = new ProductController();
        this.refreshCallback = refreshCallback;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TelescopeProduct p = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product, parent, false);

        ((TextView) convertView.findViewById(R.id.txtProductName)).setText(p.productName);
        ((TextView) convertView.findViewById(R.id.txtModel)).setText("Model: " + p.model);
        ((TextView) convertView.findViewById(R.id.txtPrice)).setText("Giá: " + p.discountedPrice + " VND");

        convertView.findViewById(R.id.btnEdit).setOnClickListener(v -> {
            Intent intent = new Intent(context, FormActivity.class);
            intent.putExtra("edit_id", p.id);
            context.startActivity(intent);
        });

        convertView.findViewById(R.id.btnDelete).setOnClickListener(v -> {
            new Thread(() -> {
                controller.deleteProduct(p.id);
                ((Activity) context).runOnUiThread(refreshCallback);
            }).start();
        });

        return convertView;
    }
}
