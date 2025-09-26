package org.example.demo_spring_thymeleaf.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.demo_spring_thymeleaf.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        // kế nối
        List<Student> studentList = new ArrayList<>();
        TypedQuery<Student> query = entityManager.createQuery("from Student",Student.class);
//        TypedQuery<Student> query = session.createNativeQuery("select * from student",Student.class);
        studentList = query.getResultList();
        return studentList;
    }

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class,id);
        return student;
    }

    @Transactional
    @Override
    public boolean add(Student student) {
        try{
            entityManager.persist(student);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
