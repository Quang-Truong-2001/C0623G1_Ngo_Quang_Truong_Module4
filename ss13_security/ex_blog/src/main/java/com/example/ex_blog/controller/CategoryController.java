package com.example.ex_blog.controller;

import com.example.ex_blog.model.Blog;
import com.example.ex_blog.model.Category;
import com.example.ex_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService service;
    @GetMapping("")
    public ModelAndView showCategoryList(){
        return new ModelAndView("category","list",service.showCategory());
    }
    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("category",new Category());
        return "saveCategory";
    }
    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category){
        service.save(category);
        return "redirect:/category";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("category",service.findById(id));
        return "viewCategory";
    }

    @GetMapping("{id}/edit")
    public String showFormEdit(@PathVariable Long id, Model model){
        model.addAttribute("category",service.findById(id));
        return "saveCategory";
    }

    @PostMapping("{id}/edit")
    public String edit(@ModelAttribute Category category){
        service.update(category);
        return "redirect:/category";
    }
    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        Long id= Long.valueOf(request.getParameter("id"));
        try {
            service.delete(service.findById(id));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/category";
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(HttpServletRequest request){
        String nameFind=request.getParameter("nameFind");
        return new ModelAndView("category","list",service.findByName(nameFind));
    }

}
