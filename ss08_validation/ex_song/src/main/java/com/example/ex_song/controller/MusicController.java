package com.example.ex_song.controller;

import com.example.ex_song.dto.MusicDTO;
import com.example.ex_song.model.Music;
import com.example.ex_song.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class MusicController {

    @Autowired
    private IMusicService service;

    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("result", "list", service.showList());
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("musicDTO", new MusicDTO());
        return "index";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute MusicDTO musicDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new MusicDTO().validate(musicDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("musicDTO", musicDTO);
            return "index";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDTO, music);
            service.create(music);
            redirectAttributes.addFlashAttribute("message", "Them thanh cong");
            return "redirect:/";
        }
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam Integer id, Model model) {
        model.addAttribute("musicDTO", service.findById(id));
        return "index";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute MusicDTO musicDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new MusicDTO().validate(musicDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("musicDTO", musicDTO);
            return "index";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDTO, music);
            service.update(music);
            redirectAttributes.addFlashAttribute("message", "Cap nhat thanh cong thanh cong");
            return "redirect:/";
        }
    }

}
