package com.example.practice.optional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Incheol Jung
 */
@Getter
@Setter
@NoArgsConstructor
public class City {
    private String name;
    private Address address;

    public City(String name) {
        this.name = name;
    }
}
