package com.example.practice.generics;

/**
 * @author Incheol Jung
 */
public class GenericLimitClass<T extends Number> {
    private T t;

    public double getDouble(){
        return t.doubleValue();
    }

    public void setT(T t){
        this.t = t;
    }

    public static void main(String[] args) {
        GenericLimitClass<Double> genericLimitClass = new GenericLimitClass<>();
        genericLimitClass.setT((double)100);
    }
}
