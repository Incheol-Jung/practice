package com.example.practice.java8;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author Incheol Jung
 */
public class HandleException {

    public static void main(String[] args) throws IOException {
        Stream.of("/usr", "/tmp").map(path -> {
            try {
                return new File(path).getCanonicalPath();
            } catch (IOException ex) {
                return ex.getMessage();
            }
        }).forEach(System.out::println);
    }
}
