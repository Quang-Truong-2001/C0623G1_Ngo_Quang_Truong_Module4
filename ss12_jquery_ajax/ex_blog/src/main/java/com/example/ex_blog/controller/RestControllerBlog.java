package com.example.ex_blog.controller;

import com.example.ex_blog.dto.BlogDto;
import com.example.ex_blog.model.Blog;
import com.example.ex_blog.model.Category;
import com.example.ex_blog.service.IBlogService;
import com.example.ex_blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class RestControllerBlog {
    @Autowired
    private IBlogService service;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> showList(@RequestParam(name = "page", defaultValue = "0",required = false) int page){
        Pageable pageable=PageRequest.of(page, 2, Sort.by("date").descending());
        Page<Blog> blogs= service.showList(pageable);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("/find/{name}")
    public ResponseEntity<List<Blog>> showListFind(@PathVariable String name){
        List<Blog> blogs=service.findByName(name);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("{id}/detail")
    public ResponseEntity<Blog> showDetailBlog(@PathVariable Long id){
        Blog blog=service.detail(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("{id}/find_category")
    public ResponseEntity<List<Blog>> findBlogCategory(@PathVariable Long id){
        Category category;
        try {
            category=categoryService.findById(id);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Blog> blogs=service.showListCategory(category);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity addBlog(@RequestBody BlogDto blogDto){
        Blog blog=new Blog();
        BeanUtils.copyProperties(blogDto,blog);
        service.create(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@RequestBody BlogDto blogDto, @PathVariable Long id){
        Blog blog=service.detail(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(blogDto,blog);
        service.update(blog);
        return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id){
        Blog blog=service.detail(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }

}
