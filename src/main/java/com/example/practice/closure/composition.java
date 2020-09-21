package com.example.practice.closure;

import com.example.practice.composition.Animal;
import com.example.practice.composition.Bird;

/**
 * @author Incheol Jung
 */
public class composition {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.go();
        System.out.println("-------------");
        animal = new Bird();
        animal.go();

    }
}
