package org.example.demo_spring_data_jpa.repository;

import org.example.demo_spring_data_jpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByNameContaining(String name);
    Page<Student> findAllByNameContaining(String name, Pageable pageable);
    @Query(value = "SELECT * FROM student where name like :searchName ;", nativeQuery = true)
    List<Student> findByName(@Param("searchName") String name);
}
