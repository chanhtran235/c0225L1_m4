package org.example.demo_spring_thymeleaf.repository;

import org.example.demo_spring_thymeleaf.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);

}
