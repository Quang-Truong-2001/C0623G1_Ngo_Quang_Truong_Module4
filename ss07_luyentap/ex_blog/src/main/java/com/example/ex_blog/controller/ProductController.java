package com.example.ex_blog.controller;


import com.example.ex_blog.model.Product;
import com.example.ex_blog.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping("")
    public ModelAndView showList(){
        return new ModelAndView("home","list",service.showList());
    }

    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("product",new Product());
        return "save";
    }
    @PostMapping("/add")
    public String addProduct(Product product){
        service.create(product);
        return "redirect:/";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("product",service.detail(id));
        return "view";
    }

    @GetMapping("{id}/edit")
    public String showFormEdit(@PathVariable Integer id, Model model){
        model.addAttribute("product",service.detail(id));
        return "save";
    }

    @PostMapping("{id}/edit")
    public String edit(@ModelAttribute Product product){
        service.update(product);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        int id= Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(HttpServletRequest request){
        String nameFind=request.getParameter("nameFind");
        return new ModelAndView("home","list",service.findByName(nameFind));
    }
}
