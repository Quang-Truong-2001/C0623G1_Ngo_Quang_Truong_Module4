package com.example.lan2.service.impl;

import com.example.lan2.model.Blog;
import com.example.lan2.repository.IRepositoryBlog;
import com.example.lan2.service.IServiceBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceBlogImpl implements IServiceBlog {

    @Autowired
    private IRepositoryBlog repository;


    @Override
    public Page<Blog> showList(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(Blog blog) {
        repository.delete(blog);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Blog detail(Integer id) {
        return repository.findById(id).get();
    }
}
