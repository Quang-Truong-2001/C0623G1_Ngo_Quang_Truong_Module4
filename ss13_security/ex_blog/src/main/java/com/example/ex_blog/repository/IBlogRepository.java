package com.example.ex_blog.repository;


import com.example.ex_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByTittleContaining(String name);
}
