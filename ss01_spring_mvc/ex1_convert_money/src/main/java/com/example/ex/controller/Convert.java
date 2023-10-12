package com.example.ex.controller;

import com.example.ex.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class Convert {
    @Autowired
    private IConvertService convertService;

    @GetMapping
    public String show(){
        return "convert";
    }
    @GetMapping("/convert")
    public String convert(Model model,@RequestParam int usd){
        model.addAttribute("vnd",convertService.convertUSDToVND(usd));
        return "convert";
    }
}
