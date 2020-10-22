package com.example.practice.stream;

import java.util.stream.Stream;

import lombok.Getter;

/**
 * @author Incheol Jung
 */
public class MapStream {

    @Getter
    static class Food {

        private String name;
        private Integer calories;

        public Food(String name, int calories) {
            this.name = name;
            this.calories = calories;
        }
    }

    public static void main(String[] args) {
        Stream<Food> foodStream = Stream.of(new Food("apple", 100),
                                            new Food("banana", 300),
                                            new Food("grape", 50),
                                            new Food("mango", 1000),
                                            new Food("pineapple", 200),
                                            new Food("peach", 300));
        int totalCalories = foodStream.map(Food::getCalories)
            .reduce(0, Integer::sum);

        System.out.println("total calories is " + totalCalories);
    }
}
