package com.example.ex_blog.repository;


import com.example.ex_blog.model.Blog;
import com.example.ex_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByTittleContaining(String name);

    List<Blog> findByCategory(Category category);

}
