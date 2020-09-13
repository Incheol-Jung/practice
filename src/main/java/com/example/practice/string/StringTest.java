package com.example.practice.string;

/**
 * @author Incheol Jung
 */
public class StringTest {

    public static void main(String[] args) {
        String str1 = "test";
        String str2 = "test";
        String str3 = str1 + str2;

        String str4 = "";
        str4 += 0;
        str4 += 1;
        str4 += 2;

        String str5 = "123";
        for(int i = 0; i < 100; ++i) {
            str5 = str5 + "456";
        }
    }
}
