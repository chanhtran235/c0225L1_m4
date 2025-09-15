package org.example.demo_spring.repository;

import org.example.demo_spring.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



public class StudentRepository implements IStudentRepository {

    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh"));
        studentList.add(new Student(2,"chánh2"));
        studentList.add(new Student(3,"chánh3"));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(int id) {
        for (Student student: studentList){
            if (id==student.getId()){
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }
}
