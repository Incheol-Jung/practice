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
public class Address {
    private String street;
    private Zipcode zipcode;

    public Address(String street) {
        this.street = street;
    }
}
