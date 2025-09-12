package org.example.demo_spring.repository;

import org.example.demo_spring.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
