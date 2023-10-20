package com.example.ex_blog.repository;


import com.example.ex_blog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContaining(String name);
}
