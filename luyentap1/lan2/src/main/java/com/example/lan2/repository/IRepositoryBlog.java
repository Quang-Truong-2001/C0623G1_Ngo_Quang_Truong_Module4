package com.example.lan2.repository;

import com.example.lan2.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryBlog extends JpaRepository<Blog,Integer> {

}
