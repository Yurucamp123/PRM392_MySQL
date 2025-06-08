package com.example.projectmysql.controller;

import com.example.projectmysql.model.TelescopeProduct;
import com.example.projectmysql.model.TelescopeProductDAO;

import java.util.ArrayList;

public class ProductController {
    private TelescopeProductDAO dao = new TelescopeProductDAO();

    public ArrayList<TelescopeProduct> getAllProducts() {
        return dao.getAll();
    }

    public void addProduct(TelescopeProduct product) {
        dao.insert(product);
    }

    public void updateProduct(TelescopeProduct product) {
        dao.update(product);
    }

    public void deleteProduct(int id) {
        dao.delete(id);
    }
    public TelescopeProduct getDetail(int id) {
        return dao.getById(id);
    }
}