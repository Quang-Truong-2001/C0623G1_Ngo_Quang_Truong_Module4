package com.example.ex_product.service.impl;

import com.example.ex_product.model.Product;
import com.example.ex_product.repository.IProductRepository;
import com.example.ex_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository repository;
    @Override
    public List<Product> showList() {
        return repository.showList();
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Product detail(int id) {
        return repository.detail(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }
}
