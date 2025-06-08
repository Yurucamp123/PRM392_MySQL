package com.example.projectmysql.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectmysql.R;
import com.example.projectmysql.adapter.ProductAdapter;
import com.example.projectmysql.controller.ProductController;
import com.example.projectmysql.model.TelescopeProduct;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProductController controller = new ProductController();
    private ArrayList<TelescopeProduct> products;
    private ProductAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();
        loadProducts();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewProducts);
        findViewById(R.id.btnAdd).setOnClickListener(v -> {
            startActivity(new Intent(this, FormActivity.class));
        });

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("id", products.get(position).id);
            startActivity(intent);
        });
    }

    private void loadProducts() {
        new Thread(() -> {
            products = controller.getAllProducts();
            runOnUiThread(() -> {
                adapter = new ProductAdapter(this, products, this::loadProducts);
                listView.setAdapter(adapter);
            });
        }).start();
    }
}

