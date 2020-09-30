package com.example.practice.threadDump;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Incheol Jung
 */
public class InfinitLoop {

    public static void main(String[] args) {
        Random random = new Random();
        while(true){
            List<String> dummyList = new ArrayList<>();
            for(int loop =0; loop <1000; loop++){
                String temp = "ABCDEFG";
                dummyList.add(temp);
            }
//            if (random.nextInt(100000) == 1) break;
        }
    }
}
