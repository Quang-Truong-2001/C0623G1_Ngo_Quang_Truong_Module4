package com.example.ex_blog.controller;


import com.example.ex_blog.model.Blog;
import com.example.ex_blog.service.IBlogService;
import com.example.ex_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService service;

    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 4, sort="date", direction = Sort.Direction.DESC) Pageable pageable){
        return new ModelAndView("home","list",service.showList(pageable));
    }

    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("category",categoryService.showCategory());
        model.addAttribute("blog",new Blog());
        return "save";
    }
    @PostMapping("/add")
    public String addBlog(@ModelAttribute Blog blog){
        service.create(blog);
        return "redirect:/";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("blog",service.detail(id));
        return "view";
    }

    @GetMapping("{id}/edit")
    public String showFormEdit(@PathVariable Long id, Model model){
        model.addAttribute("category",categoryService.showCategory());
        model.addAttribute("blog",service.detail(id));
        return "save";
    }

    @PostMapping("{id}/edit")
    public String edit(@ModelAttribute Blog blog){
        service.update(blog);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        Long id= Long.valueOf(request.getParameter("id"));
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(HttpServletRequest request){
        String nameFind=request.getParameter("nameFind");
        return new ModelAndView("home","list",service.findByName(nameFind));
    }
}
