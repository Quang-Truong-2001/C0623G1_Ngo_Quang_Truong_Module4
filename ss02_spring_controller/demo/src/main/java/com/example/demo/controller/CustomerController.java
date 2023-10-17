package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.IServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Repository
@RequestMapping("")
public class CustomerController {
    @Autowired
    private IServiceCustomer serviceCustomer;

    @GetMapping
    public String home(Model model){
        model.addAttribute("list",serviceCustomer.getList());
        return "home";
    }
    @GetMapping("/save")
    public String showFormSave(){
        return "save";
    }
    @PostMapping("/save")
    public ModelAndView save(@RequestParam String name,
                       @RequestParam String email,
                       @RequestParam String address,
                       ModelAndView modelAndView){
        serviceCustomer.save(new Customer(name,email,address));
        return new ModelAndView("home","list",serviceCustomer.getList());
    }
}
