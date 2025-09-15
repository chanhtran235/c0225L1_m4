package org.example.demo_spring.controller;

import org.example.demo_spring.entity.Student;
import org.example.demo_spring.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping ("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("studentList", studentService.findAll());
        return modelAndView;
    }

    @GetMapping ("/add")
    public String showFormAdd( ){
        return "/student/add";
    }
    @PostMapping("/add")
    public String save(@RequestParam(name = "id") int id,
                       @RequestParam(name = "name") String name,
                       RedirectAttributes redirectAttributes){
        studentService.add(new Student(id,name));
        redirectAttributes.addFlashAttribute("mess","add success");
        return "redirect:/students";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id",required = false,defaultValue = "3")int id,
                         Model model
                         ){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "/student/detail";
    }

    @GetMapping("/detail/{id:[12]}")
    public String detail2(@PathVariable(name = "id")int id,
                         Model model
    ){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "/student/detail";
    }
}
