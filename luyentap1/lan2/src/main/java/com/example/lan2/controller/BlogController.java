package com.example.lan2.controller;


import com.example.lan2.dto.BlogDTO;
import com.example.lan2.model.Blog;
import com.example.lan2.service.IServiceBlog;
import com.example.lan2.service.IServiceCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    private IServiceBlog serviceBlog;

    @Autowired
    private IServiceCategory serviceCategory;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault (value = 10,sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        return new ModelAndView("home","list",serviceBlog.showList(pageable));
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("category", serviceCategory.showList());
        model.addAttribute("blogDTO", new BlogDTO());
        return "save";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute BlogDTO blogDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new BlogDTO().validate(blogDTO,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("category", serviceCategory.showList());
            return "save";
        } else {
            Blog blog=new Blog();
            BeanUtils.copyProperties(blogDTO, blog);
            serviceBlog.save(blog);
            redirectAttributes.addFlashAttribute("message","Thêm "+ blog.getName()+ " thành công");
            return "redirect:/";
        }
    }

    @GetMapping("{id}/update")
    public String showFormEdit(@PathVariable Integer id, Model model){
        model.addAttribute("category", serviceCategory.showList());
        model.addAttribute("blogDTO", serviceBlog.detail(id));
        return "save";
    }
    @PostMapping("{id}/update")
    public String edit(@Validated @ModelAttribute BlogDTO blogDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new BlogDTO().validate(blogDTO,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("category", serviceCategory.showList());
            return "save";
        } else {
            Blog blog=new Blog();
            BeanUtils.copyProperties(blogDTO,blog);
            serviceBlog.save(blog);
            return "redirect:/";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        Blog blog=serviceBlog.detail(id);
        serviceBlog.delete(blog);
        return "redirect:/";
    }
}
