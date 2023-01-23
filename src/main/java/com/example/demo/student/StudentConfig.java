package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student johnDoe = new Student(1, "John Doe", "johndoe@gmail.com", LocalDate.of(2000, Month.FEBRUARY, 14));
            Student jimmyChoo = new Student( "Jimmy Choo", "jchoo@gmail.com", LocalDate.of(1989, Month.APRIL, 11));
            Student carolineBoudard = new Student( "Caroline Boudard", "caroB@gmail.com", LocalDate.of(1996, Month.JANUARY, 22));

            studentRepository.saveAll(List.of(johnDoe, jimmyChoo, carolineBoudard));
        };
    }

}
