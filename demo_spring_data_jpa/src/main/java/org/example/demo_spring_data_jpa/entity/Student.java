package org.example.demo_spring_data_jpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean gender;
    private String className;
    @OneToOne
    @JoinColumn(name = "username", unique = true)
    private Jame jame;
    @ManyToOne
    @JoinColumn(name = "class_id", unique = true)
    private ClassCG classCG;
}
