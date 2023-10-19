package com.example.lan1.controller;


import com.example.lan1.model.Student;
import com.example.lan1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller

@RequestMapping("")
public class Controller {
    @Autowired
    private IService service;
    @GetMapping("")
    public ModelAndView showList(){
        return new ModelAndView("home","list",service.showList());
    }
    @GetMapping("/add")
    public String showFormSave(Model model){
        model.addAttribute("student",new Student());
        return "save";
    }
    @PostMapping("/add")
    public String save(Student student){
        service.create(student);
        return "redirect:/";
    }
    @GetMapping("{id}/view")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("student",service.detail(id));
        return "view";
    }
    @GetMapping("{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model){
        model.addAttribute("student",service.detail(id));
        return "save";
    }
    @PostMapping("{id}/edit")
    public String edit(Student student){
        service.update(student);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        int id= Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        return "redirect:/";
    }
    @GetMapping("/findByName")
    public ModelAndView find(HttpServletRequest request){
        String name=request.getParameter("name");
        return new ModelAndView("home","list",service.findByName(name));
    }

}
