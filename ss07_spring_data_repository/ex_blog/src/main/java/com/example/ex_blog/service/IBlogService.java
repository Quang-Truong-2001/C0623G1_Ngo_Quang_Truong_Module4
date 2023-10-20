package com.example.ex_blog.service;


import com.example.ex_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> showList();
    void create(Blog blog);
    void update(Blog blog);
    void delete(Long id);
    Blog detail(Long id);
    List<Blog> findByName(String name);
}
