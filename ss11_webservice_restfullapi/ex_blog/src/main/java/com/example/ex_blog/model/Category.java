package com.example.ex_blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonBackReference
    private Set<Blog> blogs;


    public Category() {
    }

    public Category(Long id, String name, Set<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public Category(String name, Set<Blog> blogs) {
        this.name = name;
        this.blogs = blogs;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
