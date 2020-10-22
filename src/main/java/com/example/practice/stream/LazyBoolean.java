package com.example.practice.stream;

/**
 * @author Incheol Jung
 */
public class LazyBoolean {
    public static boolean firstCondition(){
        System.out.println("first condition");
        return true;
    }

    public static boolean secondCondition(){
        System.out.println("second condition");
        return true;
    }

    public static void main(String[] args) {
        if(firstCondition() || secondCondition()){
            System.out.println("condition done!!");
        }
    }
}
