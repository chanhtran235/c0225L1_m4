package org.example.demo_spring_data_jpa.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.demo_spring_data_jpa.dto.StudentDto;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int countVisit = 0;
    // các vụ phụ sẽ thực hiên ở đây
//    @After("execution(* org.example.demo_spring_data_jpa.controller.HomeController.showHome(..))")
//    public void countVisit(){
//        countVisit++;
//        System.out.println("-----------------------------------");
//        System.out.println(countVisit);
//        System.out.println("-----------------------------------");
//    }
//    @Before("execution(* org.example.demo_spring_data_jpa.controller.StudentController.*(..))")
//    public void countVisit(){
//        countVisit++;
//        System.out.println("-----------------------------------");
//        System.out.println(countVisit);
//        System.out.println("-----------------------------------");
//    }
//    @AfterReturning("execution(* org.example.demo_spring_data_jpa.controller.StudentController.save(..))")
//    public void loggingAddNewSuccess(JoinPoint joinPoint){
//        System.out.println("-------------Thêm mới thành công----------------------");
//         Object[] objects = joinPoint.getArgs();
//        StudentDto studentDto = (StudentDto) objects[0];
//        System.out.println(studentDto.getName());
//        System.out.println("-----------------------------------");
//    }
//
//    @AfterThrowing("execution(* org.example.demo_spring_data_jpa.controller.StudentController.save(..))")
//    public void loggingAddNewNotSuccess(){
//        System.out.println("-------------Thêm mới không thành công----------------------");
//
//        System.out.println("-----------------------------------");
//    }

    @Around("execution(* org.example.demo_spring_data_jpa.controller.StudentController.save(..))")
    public Object logging(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("-------------Code thực thi trức nghiệp vụ chính code ở đây----------------------");

        Object object;
        try {
           object= proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("------------Code thực sau nghiệp vụ chính-----------------------");

        return object;
    }
}
