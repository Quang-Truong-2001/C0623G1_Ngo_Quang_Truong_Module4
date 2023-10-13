package com.example.ex2_caculator.controller;


import com.example.ex2_caculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class Caculator {

    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping
    public String show() {
        return "home";
    }

    @GetMapping("/caculator")
    public String caculator(Model model,
                           @RequestParam(value = "numberOne") double numberOne,
                           @RequestParam(value = "numberTwo") double numberTwo,
                           @RequestParam(value = "operator") String operator) {
        if(numberTwo==0 && operator.equals("Division")){
            model.addAttribute("result","Mẫu phải khác không");
            return "home";
        }
        double result=calculatorService.calculator(numberOne,numberTwo,operator);
        model.addAttribute("result",result);
        return "home";
    }
}
