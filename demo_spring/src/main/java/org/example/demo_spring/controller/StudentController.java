package org.example.demo_spring.controller;

import org.example.demo_spring.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/students")
    public String showList(Model model){
        model.addAttribute("studentList", studentService.findAll());
        return "/student/list";
    }
    @GetMapping ("/students/add")
    public String showFormAdd( ){
        return "/student/add";
    }
    @PostMapping("/students/add")
    public String save(@RequestParam(name = "id") int id,
                       @RequestParam(name = "name") String name,
                       Model model){
        // gọi service thêm mới
        // trả về trang list
        model.addAttribute("studentList", studentService.findAll());
        return "/student/list";
    }
}
