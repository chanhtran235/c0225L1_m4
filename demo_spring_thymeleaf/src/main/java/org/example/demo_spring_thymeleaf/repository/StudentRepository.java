package org.example.demo_spring_thymeleaf.repository;

import org.example.demo_spring_thymeleaf.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




@Repository
public class StudentRepository implements IStudentRepository {

    private static List<Student> studentList = new ArrayList<>();
    static {
//        studentList.add(new Student(1,"chánh1",true, Arrays.asList("java","js","php"),"C02"));
//        studentList.add(new Student(2,"chánh1",true, Arrays.asList("java","js","php"),"C02"));
//        studentList.add(new Student(3,"chánh1",true, Arrays.asList("java","js","php"),"C02"));
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
