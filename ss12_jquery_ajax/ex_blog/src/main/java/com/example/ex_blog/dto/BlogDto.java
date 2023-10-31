package com.example.ex_blog.dto;

import com.example.ex_blog.model.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

public class BlogDto {
    private Long id;
    private String tittle;
    private String content;
    private String date;
    private Category category;

    public BlogDto(Long id, String tittle, String content, String date, Category category) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public BlogDto() {
    }

    public BlogDto(String tittle, String content, String date, Category category) {
        this.tittle = tittle;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
