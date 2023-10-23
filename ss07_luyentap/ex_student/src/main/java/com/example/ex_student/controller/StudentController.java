package com.example.ex_student.controller;

import com.example.ex_student.model.ClassRoom;
import com.example.ex_student.model.Student;
import com.example.ex_student.service.IClassRoomService;
import com.example.ex_student.service.ICourseService;
import com.example.ex_student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRoomService roomService;
    @Autowired
    private ICourseService courseService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault (value = 4, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable){
        return new ModelAndView("home","list",studentService.showList(pageable));
    }
    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("classes", roomService.showListClassRoom());
        model.addAttribute("courseslist",courseService.showListClassCourse());
        model.addAttribute("student", new Student());
        return "save";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Student student, Model model){
        studentService.create(student);
        return "redirect:/";
    }
    @GetMapping("{id}/edit")
    public String showFormUpdate(@PathVariable Integer id,Model model){
        model.addAttribute("classes", roomService.showListClassRoom());
        model.addAttribute("student",studentService.findById(id));
        return "save";
    }
    @PostMapping("{id}/edit")
    public String edit(@ModelAttribute Student student){
        studentService.update(student);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        studentService.delete(id);
        return "redirect:/";
    }
}
