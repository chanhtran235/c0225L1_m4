package org.example.demo_spring_thymeleaf.repository;


import jakarta.persistence.TypedQuery;
import org.example.demo_spring_thymeleaf.entity.Student;

import org.example.demo_spring_thymeleaf.utils.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




@Repository
public class StudentRepository implements IStudentRepository {

    @Override
    public List<Student> findAll() {
        // kế nối
        List<Student> studentList = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
//        TypedQuery<Student> query = session.createQuery("from Student");
        TypedQuery<Student> query = session.createNativeQuery("select * from student",Student.class);
        studentList = query.getResultList();
        session.close();
        return studentList;
    }

    @Override
    public Student findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Student student = session.find(Student.class,id);
        session.close();
        return student;
    }

    @Override
    public boolean add(Student student) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            // cách update
            // studentUpdate= findById(id);
            // studentUpdate.setName(student.getName)
            //...... set các trường khác
            //  session.merge(studentUpdate);

            // xoá
            // studentDelete= findById(id);
            //  session.remove(studentDelete);
            session.persist(student);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
        return true;
    }
}
