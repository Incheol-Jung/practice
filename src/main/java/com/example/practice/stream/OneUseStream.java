package com.example.practice.stream;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author Incheol Jung
 */
public class OneUseStream {

    public static void main(String[] args) {
        Stream<String> fruits =Stream.of("apple", "banana", "grape", "orange", "mango");

        String longestName = fruits.sorted(Comparator.comparing(String::length)).findFirst().orElse("");
        String shortestName = fruits.sorted(Comparator.comparing(String::length).reversed()).findFirst().orElse("");
        System.out.println("longestName is " + longestName + ", shortestName is " + shortestName);
    }
}
