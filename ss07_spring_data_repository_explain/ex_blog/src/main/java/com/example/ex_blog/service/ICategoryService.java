package com.example.ex_blog.service;

import com.example.ex_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> showCategory();

    void save(Category category);

    void delete(Category category);

    void update(Category category);

    Category findById(Long id);

    List<Category> findByName(String name);
}
