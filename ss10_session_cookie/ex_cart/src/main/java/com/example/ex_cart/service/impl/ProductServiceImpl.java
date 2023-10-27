package com.example.ex_cart.service.impl;

import com.example.ex_cart.model.Product;
import com.example.ex_cart.repository.IRepositoryProduct;
import com.example.ex_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IRepositoryProduct repository;
    @Override
    public List<Product> showList() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }
}
