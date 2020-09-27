package com.example.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Incheol Jung
 */
public class StringFilter {

    public static void main(String[] args) {

        final Function<String, Predicate<String>> startsWithLetter =
            letter -> name -> name.startsWith(letter);

        List<String> list = new ArrayList();
        list.add("incheol");

        long count = list.stream().filter(startsWithLetter.apply("N")).count();
        System.out.println(count);
    }
}
