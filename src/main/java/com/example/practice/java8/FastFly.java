package com.example.practice.java8;

/**
 * @author Incheol Jung
 */
public interface FastFly extends DefaultMethods.Fly {
    default void takeOff() { System.out.println("FastFly::takeOff"); }
}

