package org.example.demo_spring_data_jpa.repository;

import org.example.demo_spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
List<Student>  findAllByNameContainingAndClassNameContaining(String name,String className);
@Query(value = "SELECT * FROM student where name like :searchName ;",nativeQuery = true)
List<Student> findByName1(@Param("searchName") String name);
}
