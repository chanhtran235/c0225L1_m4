package org.example.demo_spring.service;

import org.example.demo_spring.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
}
