package com.example.orm.controller;

import com.example.orm.dto.StudentDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("")
public class Controller {
    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("studentDTO",new StudentDTO());
        return "index";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute StudentDTO studentDTO, BindingResult bindingResult){
        new StudentDTO().validate(studentDTO,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "index";
        }
        return "result";
    }

}
