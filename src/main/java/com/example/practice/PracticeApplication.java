package com.example.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        System.out.println("hello PracticeApplication main method!!!!!!!!! ");
        SpringApplication.run(PracticeApplication.class, args);
    }

}
