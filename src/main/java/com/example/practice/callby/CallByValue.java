package com.example.practice.callby;

/**
 * @author Incheol Jung
 */
public class CallByValue {
    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;

        System.out.println("x = " + x);
        System.out.println("y = " + System.identityHashCode(y));
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println("a = " + System.identityHashCode(a));
        System.out.println("b = " + System.identityHashCode(b));

        System.out.println("swap() 호출 전 : a = " + a + ", b = " + b);

        swap(a, b);

        System.out.println("swap() 호출 후 : a = " + a + ", b = " + b);
    }
}
