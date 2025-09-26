package org.example.demo_spring_thymeleaf.service;

import org.example.demo_spring_thymeleaf.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(int id);
    boolean add(Student student);
}
