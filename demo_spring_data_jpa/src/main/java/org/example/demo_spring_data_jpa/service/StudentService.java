package org.example.demo_spring_data_jpa.service;

import org.example.demo_spring_data_jpa.entity.Student;
import org.example.demo_spring_data_jpa.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository ;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(String name, Pageable pageable) {
        return studentRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public List<Student> searchByName(String name) {
        return studentRepository.findAllByNameContaining(name);
    }


    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.save(student)!=null;
    }
}
