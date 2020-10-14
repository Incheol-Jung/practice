package com.example.practice.enums;

/**
 * @author Incheol Jung
 */
public enum Category {
    CLOTHES("CA0001"),
    SHOES("CA0002"),
    JACKET("CA0003"),
    DRESS("CA0004");

    private String code;

    Category(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
