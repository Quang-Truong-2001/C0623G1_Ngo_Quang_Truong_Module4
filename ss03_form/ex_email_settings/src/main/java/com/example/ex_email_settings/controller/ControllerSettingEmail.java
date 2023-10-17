package com.example.ex_email_settings.controller;

import com.example.ex_email_settings.model.Setting;
import com.example.ex_email_settings.service.IEmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ControllerSettingEmail {

    @Autowired
    private IEmailSettingService emailSettingService;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("setting",emailSettingService.show());
                return "home";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Setting setting){
        emailSettingService.update(setting);
        return "redirect:/";
    }
}
