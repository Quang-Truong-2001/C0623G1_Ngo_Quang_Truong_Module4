package com.example.ex_blog.service.impl;


import com.example.ex_blog.model.Blog;
import com.example.ex_blog.model.Category;
import com.example.ex_blog.repository.IBlogRepository;
import com.example.ex_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> showList() {
        return repository.findAll();
    }

    @Override
    public void create(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void delete(Long id) {
        repository.delete(detail(id));
    }

    @Override
    public Blog detail(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Page<Blog> findByName(String name, Pageable pageable) {
        return repository.findByTittleContaining(name, pageable);
    }

    @Override
    public Page<Blog> showList(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Blog> showListBlog() {
        return repository.findAll();
    }

    @Override
    public List<Blog> showListCategory(Category category) {
        return repository.findByCategory(category);
    }


}
