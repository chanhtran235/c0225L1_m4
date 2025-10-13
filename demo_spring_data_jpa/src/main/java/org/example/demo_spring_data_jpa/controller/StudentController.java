package org.example.demo_spring_data_jpa.controller;

import jakarta.validation.Valid;
import org.example.demo_spring_data_jpa.dto.StudentDto;
import org.example.demo_spring_data_jpa.entity.Student;
import org.example.demo_spring_data_jpa.exception.DuplicateAdminException;
import org.example.demo_spring_data_jpa.service.IClassService;
import org.example.demo_spring_data_jpa.service.IStudentService;
import org.example.demo_spring_data_jpa.validation.StudentValidate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassService classService;

//    @GetMapping(value = "")
//    public ModelAndView showList(@PageableDefault(page = 0,size = 3,sort = "name",direction = Sort.Direction.DESC) Pageable pageable,
//                                 @RequestParam(name = "searchName", required = false,defaultValue = "")String searchName){
//        ModelAndView modelAndView = new ModelAndView("/student/list");
//        Page<Student> studentPage = studentService.findAll(searchName,pageable);
//        modelAndView.addObject("studentPage", studentPage);
//        modelAndView.addObject("searchName", searchName);
//        return modelAndView;
//    }

    @GetMapping(value = "")
    public ModelAndView showList(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                 @RequestParam(name = "searchName", required = false, defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("name").and(Sort.by("gender").ascending()));

        ModelAndView modelAndView = new ModelAndView("/student/list");
        Page<Student> studentPage = studentService.findAll(searchName, pageable);
        modelAndView.addObject("studentPage", studentPage);
        modelAndView.addObject("searchName", searchName);
        return modelAndView;
    }


    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("classList", classService.findAll());
        return "student/add";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute(name = "studentDto") StudentDto studentDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) throws DuplicateAdminException {

        StudentValidate studentValidate = new StudentValidate();
        studentValidate.validate(studentDto,bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("classList", classService.findAll());
            return "student/add";
        }

        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.add(student);
        redirectAttributes.addFlashAttribute("mess", "add success");
        return "redirect:/students";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id", required = false, defaultValue = "3") int id,
                         Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }

    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable(name = "id") int id,
                          Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }


    @ExceptionHandler(DuplicateAdminException.class)
    public String handleDuplicate(){
        return "client-exception";
    }


}
