package org.example.demo_spring.service;

import org.example.demo_spring.entity.Student;
import org.example.demo_spring.repository.IStudentRepository;
import org.example.demo_spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository ;

//    public StudentService(IStudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.add(student);
    }
}
