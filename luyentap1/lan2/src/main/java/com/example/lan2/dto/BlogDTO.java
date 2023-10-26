package com.example.lan2.dto;

import com.example.lan2.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class BlogDTO implements Validator{

    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String date;

    private Category category;

    public BlogDTO() {
    }

    public BlogDTO(Integer id, String name, String date, Category category) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.category = category;
    }

    public BlogDTO(String name, String date, Category category) {
        this.name = name;
        this.date = date;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BlogDTO blogDTO=(BlogDTO) target;
    }
}
