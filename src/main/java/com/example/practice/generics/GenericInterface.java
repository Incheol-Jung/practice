package com.example.practice.generics;

/**
 * @author Incheol Jung
 */
public interface GenericInterface<T> {
    public T get();
}

class StringGeneric implements GenericInterface<String> {

    @Override
    public String get() {
        return "incheol";
    }


    public static void main(String[] args) {
        StringGeneric stringGeneric = new StringGeneric();
        System.out.println(stringGeneric.get());
    }
}

class IntegerGeneric implements GenericInterface<Integer> {

    @Override
    public Integer get() {
        return 20;
    }
}
