package com.example.practice;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableAsync
@SpringBootApplication
public class PracticeApplication {
    static final int TIMEOUT = 7000;

    @Bean
    RestTemplate restTemplateWithConnectReadTimeout() {
        return new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(TIMEOUT))
            .setReadTimeout(Duration.ofMillis(TIMEOUT))
            .build();
    }

    public static void main(String[] args) {
        System.out.println("hello PracticeApplication main method!!!!!!!!! ");
        SpringApplication.run(PracticeApplication.class, args);
    }

}
