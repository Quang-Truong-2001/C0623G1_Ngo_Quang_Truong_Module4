package com.example.lan2.service;

import com.example.lan2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceBlog {
    Page<Blog> showList(Pageable pageable);
    void delete(Blog blog);
    void save(Blog blog);
    Blog detail(Integer id);
}
