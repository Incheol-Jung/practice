package com.example.practice.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Incheol Jung
 */
@RestControllerAdvice()
public class ControllerSupport {

    @ExceptionHandler({NullPointerException.class, ClassCastException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String handle(Exception ex) {
        return "Exception Handle!!!";
    }
}
