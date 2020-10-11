package com.example.practice.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Incheol Jung
 */
public class WildCardClass {
    public static void print(List<?> items){
        for(Object item : items){
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        ArrayList items = new ArrayList();
        items.add("incheol");
        items.add(10);

        WildCardClass.print(items);
    }
}
