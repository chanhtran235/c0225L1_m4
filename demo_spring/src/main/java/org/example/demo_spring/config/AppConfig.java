package org.example.demo_spring.config;

import org.example.demo_spring.repository.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public StudentRepository studentRepository(){
        return new StudentRepository();
    }
}
