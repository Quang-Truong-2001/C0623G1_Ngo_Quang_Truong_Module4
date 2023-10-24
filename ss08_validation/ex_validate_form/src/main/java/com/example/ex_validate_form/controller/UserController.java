package com.example.ex_validate_form.controller;

import com.example.ex_validate_form.dto.UserDTO;
import com.example.ex_validate_form.model.User;
import com.example.ex_validate_form.service.IServiceUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private IServiceUser service;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "index";
    }

    @GetMapping("/result")
    public String showResult(){
        return "result";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute UserDTO userDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        new UserDTO().validate(userDTO,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "index";
        } else {
            User user=new User();
            BeanUtils.copyProperties(userDTO,user);
            service.create(user);
            redirectAttributes.addFlashAttribute("message","Them moi thanh cong");
            return "redirect:/result";
        }
    }
}
