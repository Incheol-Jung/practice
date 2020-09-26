package com.example.practice.java8;

/**
 * @author Incheol Jung
 */
public interface UserInstance<T, X extends Throwable> {
    void accept(T instance) throws X;
}
