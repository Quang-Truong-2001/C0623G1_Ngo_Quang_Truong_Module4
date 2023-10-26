package com.example.lan2.repository;

import com.example.lan2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCategory extends JpaRepository<Category,Integer> {
}
