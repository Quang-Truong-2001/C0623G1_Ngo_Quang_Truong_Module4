package com.example.demo.controller;

import com.example.demo.service.IServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
