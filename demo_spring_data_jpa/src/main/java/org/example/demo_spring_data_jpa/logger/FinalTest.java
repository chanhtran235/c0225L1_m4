package org.example.demo_spring_data_jpa.logger;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.demo_spring_data_jpa.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class FinalTest {
//    private  static int count =0;
//    @Autowired
//    private HttpServletRequest request;
//
//    @After("execution(* org.example.demo_spring_data_jpa.controller.HomeController.showHome(..))")
//    public void countVisitWeb(){
//        HttpSession session = request.getSession();
//        if (session.getAttribute("isAccess")==null){
//            count++;
//            session.setAttribute("isAccess",true);
//        }
//        System.out.println("-----------------------số lần-----------------------");
//        System.out.println(count);
//        System.out.println("-----------------------------------------------------");
//    }
//    @AfterReturning("execution(* org.example.demo_spring_data_jpa.controller.StudentController.save(..))")
//    public void loggingAddStudentSuccess(){
//        System.out.println("-------------thêm mới thành công---------");
//    }
//    @AfterThrowing("execution(* org.example.demo_spring_data_jpa.controller.StudentController.save(..))")
//    public void loggingAddStudentException(JoinPoint joinPoint){
//        Object[] args =joinPoint.getArgs();
//        StudentDto studentDto = (StudentDto)args[0];
//
//        System.out.println("-------------thêm mới không thành công---------");
//        System.out.println(studentDto.getName());
//        System.out.println("-----------------------------------------------");
//    }
//    @Around("execution(* org.example.demo_spring_data_jpa.controller.StudentController.save(..))")
//    public Object loggingAddStudentException1(ProceedingJoinPoint proceedingJoinPoint){
//        System.out.println("-------------Trước khi---------");
//        Object object;
//        try {
//            object = proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("-------------------Sau khi ----------------------------");
//        return object;
//    }


}
