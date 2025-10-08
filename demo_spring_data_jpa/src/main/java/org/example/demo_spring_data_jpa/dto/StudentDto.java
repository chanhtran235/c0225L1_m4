package org.example.demo_spring_data_jpa.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.demo_spring_data_jpa.entity.ClassCG;
import org.example.demo_spring_data_jpa.entity.Jame;

@Setter
@Getter
@NoArgsConstructor
public class StudentDto  {
//    @NotEmpty(message = "Require input data!")
//    @Pattern(regexp = "^[A-Z]\\w*",message = "Not match name pattern!")
    private String name;
    private boolean gender;
    @NotNull(message = "Select class please!")
    private ClassCG classCG;
}
