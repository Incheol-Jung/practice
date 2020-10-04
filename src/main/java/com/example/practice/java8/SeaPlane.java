package com.example.practice.java8;

/**
 * @author Incheol Jung
 */
public class SeaPlane extends Vehicle implements FastFly, Sail {
    private int alititude;

    @Override
    public void cruise() {
        System.out.println("SeaPlane::cruise currently cruise like: ");
        if (alititude > 0) {
            FastFly.super.cruise();
        } else {
            Sail.super.cruise();
        }
    }
}
