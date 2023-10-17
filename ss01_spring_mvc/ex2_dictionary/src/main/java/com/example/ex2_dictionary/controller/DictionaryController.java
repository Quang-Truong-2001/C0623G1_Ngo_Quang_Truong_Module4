package com.example.ex2_dictionary.controller;

import com.example.ex2_dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping
    public String show(){
        return "dictionary";
    }
    @GetMapping ("/find")
    public String findWord(Model model, @RequestParam String english){
        String result=dictionaryService.findByWord(english);
        if(result==null){
            model.addAttribute("vietnamese","Không tìm thấy");
            model.addAttribute("english",english);
        } else {
            model.addAttribute("vietnamese",dictionaryService.findByWord(english));
            model.addAttribute("english",english);
        }
        return "dictionary";
    }
}
