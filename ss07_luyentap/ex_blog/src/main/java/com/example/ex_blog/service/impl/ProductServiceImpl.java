package com.example.ex_blog.service.impl;


import com.example.ex_blog.model.Product;
import com.example.ex_blog.repository.IProductRepository;
import com.example.ex_blog.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> showList() {
        return repository.findAll();
    }

    @Override
    public void create(Product product) {
        repository.save(product);
    }

    @Override
    public void update(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(detail(id));
    }

    @Override
    public Product detail(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Product> findByName(String name) {
        return repository.findByNameContaining(name);
    }
}
