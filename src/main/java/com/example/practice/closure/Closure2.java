package com.example.practice.closure;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

/**
 * @author Incheol Jung
 */
@Configuration
public class Closure2 {

    private String someVariable = "9000";

    public void anonymousClosure() {
        String someVariable = "1000";
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                System.out.println(Closure2.this.someVariable);
                return Integer.parseInt(someVariable);
            }
        };
    }
    public void lambdaClosure() {
        Function<String,Integer> function = i -> {
            System.out.println(this.someVariable);
            return null;
        };
    }

//    public static void main(String[] args) {
//        Closure2 c = new Closure2();
//        c.lambdaClosure();
//        c.anonymousClosure();
//    }
}
