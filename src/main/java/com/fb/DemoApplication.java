package com.fb;

import com.fb.model.Student;
import com.fb.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(StudentService studentService) {
        return args -> {
            studentService.saveStudentDetails(Student.builder().name("abdellah").age(22).city("casa").build());
            studentService.getAllStudents().forEach(System.out::println);
        };
    }
}
