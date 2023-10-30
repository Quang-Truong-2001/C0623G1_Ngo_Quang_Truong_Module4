package com.example.ex_blog.repository;


import com.example.ex_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByTittleContaining(String name);
    @Query(value = "from Blog where tittle like :name", nativeQuery = true)
    ResultSet list(@Param("name") String name);
    @Transactional
    @Modifying
    @Query(value = "update Blog set tittle=:name, content=:content where id =:id", nativeQuery = true)
    void updateBlog(@Param("name") String name, @Param("content") String content, @Param("id") Long id);
}
