package com.example.ex_product.repository;

import com.example.ex_product.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> showList();
    void create(Product product);
    void update(Product product);
    void delete(int id);
    Product detail(int id);
    List<Product> findByName(String name);
}
