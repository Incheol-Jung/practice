package com.example.practice.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Incheol Jung
 */
public enum Category {
    CLOTHES("CA0001"),
    SHOES("CA0002"),
    JACKET("CA0003"),
    DRESS("CA0004"),
    UNKNOWN("알수없음");;

    private String code;

    Category(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Category findWithArraysStream(String code) {
        return Arrays.stream(values())
                     .filter(accountStatus -> accountStatus.getCode().equals(code))
                     .findAny()
                     .orElse(UNKNOWN);

    }

    public Category findWithStreamOf(String code) {
        return Stream.of(values())
                     .filter(accountStatus -> accountStatus.getCode().equals(code))
                     .findAny()
                     .orElse(UNKNOWN);

    }

    private static final Map<String, Category> descriptions = Collections.unmodifiableMap(Stream.of(values())
                                                                                                .collect(Collectors.toMap(
                                                                                                    Category::getCode,
                                                                                                    Function.identity())));

    public static Category findWithHashMap(String code) {
        return Optional.ofNullable(descriptions.get(code)).orElse(UNKNOWN);
    }

}
