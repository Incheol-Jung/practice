package com.example.practice.composition;

/**
 * @author Incheol Jung
 */
public class Bird extends Animal {
    private int wingCount;

    public void printName(){
        super.printName();
        System.out.println("I have ${wingCount} wings");
    }
    private void fly() {
        System.out.println("fly with wings");
    }

    protected void move(){
        this.fly();
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.printName();
    }
}
