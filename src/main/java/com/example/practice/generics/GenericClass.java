package com.example.practice.generics;

/**
 * @author Incheol Jung
 */
public class GenericClass<T> {
    private T t;

    public GenericClass(T t) {
        this.t = t;
    }

    public GenericClass() {

    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        GenericClass stringGenericClass = new GenericClass<>();
        stringGenericClass.setT("incheol");
        stringGenericClass.setT(10);
        stringGenericClass.setT("incheol");
        System.out.println(stringGenericClass.getT());

//        GenericClass<Integer> integerGenericClass = new GenericClass<>();
//        integerGenericClass.setT(20);

    }
}
