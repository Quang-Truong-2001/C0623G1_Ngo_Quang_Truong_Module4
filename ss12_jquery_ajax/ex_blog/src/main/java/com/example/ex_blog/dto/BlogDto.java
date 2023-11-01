package com.example.ex_blog.dto;

import com.example.ex_blog.model.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

public class BlogDto {
    private Long id;
    private String tittle;
    private String content;
    private String date;
    private String idCategory;


    public BlogDto() {
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

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }
}
