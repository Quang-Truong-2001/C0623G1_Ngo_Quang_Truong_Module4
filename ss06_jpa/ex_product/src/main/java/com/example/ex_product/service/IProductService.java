package com.example.ex_product.service;

import com.example.ex_product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showList();
    void create(Product product);
    void update(Product product);
    void delete(int id);
    Product detail(int id);
    List<Product> findByName(String name);
}
