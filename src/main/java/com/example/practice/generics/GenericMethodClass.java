package com.example.practice.generics;

/**
 * @author Incheol Jung
 */
public class GenericMethodClass {
    public <T> T showGenericData(T data){
        return data;
    }

    public <T> T showGenericData2(T data){
        return data;
    }

    public static void main(String[] args) {
        GenericMethodClass genericMethodClass = new GenericMethodClass();
        System.out.println(genericMethodClass.<String>showGenericData("incheol"));
        System.out.println(genericMethodClass.<Integer>showGenericData2(1000));
    }
}

