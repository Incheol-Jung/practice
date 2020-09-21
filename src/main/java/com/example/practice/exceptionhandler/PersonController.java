package com.example.practice.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Incheol Jung
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @GetMapping
    public String test(){
        return "test";
    }

    @GetMapping("/exception")
    public String exception1(){
        throw new NullPointerException();
    }


    @ExceptionHandler(value = NullPointerException.class)
    public String nullPointerExceptionHandle(NullPointerException ex){
        return "nullPointerException Handle!!!";
    }


    @GetMapping("/exception2")
    public String exception2(){
        throw new ClassCastException();
    }

//    @ExceptionHandler({NullPointerException.class, ClassCastException.class})
//    public String handle(Exception ex){
//        return "Exception Handle!!!";
//    }
}
