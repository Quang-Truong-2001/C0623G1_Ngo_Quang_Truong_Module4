package com.example.ex_blog.controller;

import com.example.ex_blog.model.Category;
import com.example.ex_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class RestControllerCategory {
    @Autowired
    private ICategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> showList(){
        List<Category> list=service.showCategory();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
