package com.example.practice.statics;

/**
 * @author Incheol Jung
 */
public class StaticUtil {
    private static final int MAX_COUNT = 10;

    public static int getApply(int count){
        return MAX_COUNT * count;
    }
}
