package com.example.practice.closure;

/**
 * @author Incheol Jung
 */
public class Closure {
//    public static void main(String[] args) {
//        int a = 10;
//        int b = 20;
//
//        a = 12;
////        b = 32;
//
//        // implements interface
//        doProcess(a, new Process() {
//            @Override
//            public void process(int i) {
//                System.out.println(i + b);
//            }
//        });
//
//        // lambda
//        doProcess(a, i -> System.out.println(i + b));
//    }

    public static void doProcess(int i, Process p){
        p.process(i);
    }
}

interface Process {
    void process(int i);
}
