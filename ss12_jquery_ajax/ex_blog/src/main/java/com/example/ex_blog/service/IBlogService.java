package com.example.ex_blog.service;


import com.example.ex_blog.model.Blog;
import com.example.ex_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> showList();
    void create(Blog blog);
    void update(Blog blog);
    void delete(Long id);
    Blog detail(Long id);
    List<Blog> findByName(String name);
    Page<Blog> showList(Pageable pageable);
    List<Blog> showListBlog();

    List<Blog> showListCategory(Category category);
}
