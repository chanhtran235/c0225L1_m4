package org.example.demo_spring_data_jpa.controller;

import org.example.demo_spring_data_jpa.entity.Student;
import org.example.demo_spring_data_jpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping ("/students")
public class StudentController {
    @ModelAttribute("subjects")
    public List<String> getSubjects(){
        return Arrays.asList("JAVA", "PHP","SQL");
    }
    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("studentList", studentService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam(name = "searchName") String searchName){
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("studentList", studentService.searchByName(searchName));
        return modelAndView;
    }

    @GetMapping ("/add")
    public String showFormAdd(Model model){
        model.addAttribute("student", new Student());
        return "/student/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute(name = "student") Student student,
                       RedirectAttributes redirectAttributes){
        studentService.add(student);
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

    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable(name = "id")int id,
                         Model model
    ){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "/student/detail";
    }

}
