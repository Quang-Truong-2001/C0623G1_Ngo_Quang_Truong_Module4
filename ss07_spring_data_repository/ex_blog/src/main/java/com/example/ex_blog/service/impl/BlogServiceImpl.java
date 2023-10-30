package com.example.ex_blog.service.impl;


import com.example.ex_blog.model.Blog;
import com.example.ex_blog.repository.IBlogRepository;
import com.example.ex_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
        repository.updateBlog(blog.getTittle(), blog.getContent(), blog.getId());
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
    public List<Blog> findByName(String name) {
        return repository.findByTittleContaining(name);
    }
}
