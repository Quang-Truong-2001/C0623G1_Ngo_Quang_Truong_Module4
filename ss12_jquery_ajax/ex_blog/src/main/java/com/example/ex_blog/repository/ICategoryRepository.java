package com.example.ex_blog.repository;

import com.example.ex_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findByNameContaining(String name);

}
