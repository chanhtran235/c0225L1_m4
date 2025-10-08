package org.example.demo_spring_data_jpa.repository;

import org.example.demo_spring_data_jpa.dto.ClassCGDto;
import org.example.demo_spring_data_jpa.entity.ClassCG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClassRepository extends JpaRepository<ClassCG,Integer> {

    @Query(value = "select c.name, count(s.id) as quality from student s join class_cg c on s.class_id=c.id group by c.id ;"
            ,nativeQuery = true)
    List<ClassCGDto> countStudentInClass();
}
