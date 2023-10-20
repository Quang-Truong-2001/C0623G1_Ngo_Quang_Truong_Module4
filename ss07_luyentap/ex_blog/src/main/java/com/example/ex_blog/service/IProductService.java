package com.example.ex_blog.service;


import com.example.ex_blog.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showList();
    void create(Product product);
    void update(Product product);
    void delete(Integer id);
    Product detail(Integer id);
    List<Product> findByName(String name);
}
