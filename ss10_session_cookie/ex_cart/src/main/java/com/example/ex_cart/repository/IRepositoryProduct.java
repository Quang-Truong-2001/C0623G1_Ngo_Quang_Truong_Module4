package com.example.ex_cart.repository;

import com.example.ex_cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryProduct extends JpaRepository<Product, Integer> {

}
