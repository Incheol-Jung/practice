package com.example.practice.exceptionhandler;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Incheol Jung
 */
@Getter
@Setter
@ToString
public class Person {
    private int id;
    private String name;
    private Date registerDate;
}
