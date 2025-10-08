package org.example.demo_spring_data_jpa.validation;

import org.example.demo_spring_data_jpa.dto.StudentDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto = (StudentDto) target;
        if (studentDto.getName().isEmpty()){
            errors.rejectValue("name","notEmpty","Không để trống");
        }else if (!studentDto.getName().matches("^[A-Z]\\w*")){
            errors.rejectValue("name","name.patter","Không đúng định dạng");

        }
    }
}
