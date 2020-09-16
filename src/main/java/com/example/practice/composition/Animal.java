package com.example.practice.composition;

/**
 * @author Incheol Jung
 */
public class Animal {
    private int legCount;
    private String name;

    public void printName(){
        System.out.println("I'm " + this.name);
    }

    private void run(){
        System.out.println("run with legs");
    }

    public void move(){
        this.run();
    }
}
