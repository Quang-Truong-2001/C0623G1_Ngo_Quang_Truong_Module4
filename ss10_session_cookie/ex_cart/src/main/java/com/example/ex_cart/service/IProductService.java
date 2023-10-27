package com.example.ex_cart.service;

import com.example.ex_cart.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> showList();

    Optional<Product> findById(Integer id);
}
