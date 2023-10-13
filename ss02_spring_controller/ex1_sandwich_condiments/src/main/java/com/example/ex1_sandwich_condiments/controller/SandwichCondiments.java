package com.example.ex1_sandwich_condiments.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class SandwichCondiments {

    @GetMapping
    public String show() {
        return "home";
    }

    @GetMapping("/save")
    public String save(Model model, @RequestParam(value = "condiment", required = false, defaultValue = "") String[] condiment){
        model.addAttribute("result", condiment);
        return "display";
    }
}
