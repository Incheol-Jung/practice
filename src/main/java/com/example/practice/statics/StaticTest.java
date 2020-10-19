package com.example.practice.statics;

/**
 * @author Incheol Jung
 */
public class StaticTest {
    private int count = 0;
    private static String name = "";

    static {
        System.out.println(this.count);
        name = "incheol";
        System.out.println("static block!!!!");
    }

    {
        name = "test";
        System.out.println("non static block!!!");
    }

    public StaticTest(int count) {
        this.count = count;
        name = "test22";
        System.out.println("construct block");
    }

    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest(10);
        System.out.println(StaticTest.name);
    }
}
