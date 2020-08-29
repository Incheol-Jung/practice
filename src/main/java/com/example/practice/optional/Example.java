package com.example.practice.optional;

import java.util.Optional;

/**
 * @author Incheol Jung
 */
public class Example {

    public String nullCheckChainingOrigin() {
        City city = new City();
        if (city != null) {
            Address address = city.getAddress();
            if (address != null) {
                Zipcode zipcode = address.getZipcode();
                if (zipcode != null) {
                    zipcode.getCode();
                }
            }
        }

        return "incheol";
    }

    public String nullCheckChainingOptional() {
        City city = new City();
        return Optional.ofNullable(city)
                       .map(City::getAddress)
                       .map(Address::getZipcode)
                       .map(Zipcode::getCode)
                       .orElse("incheol");
    }

    public String getAddressOrigin() {
        City city = new City();
        Address address = city.getAddress();
        if (address != null && address.getStreet().contains("seoul")) {
            return address.getStreet();
        }
        return "incheol";
    }

    public String getAddressOptional() {
        City city = new City();
        Address address = city.getAddress();
        return Optional.ofNullable(address)
                       .filter(a -> a.getStreet().contains("seoul"))
                       .map(Address::getStreet)
                       .orElse("incheol");
    }

    public String orElseGetTest(){
        City city = new City("pusan");
        return Optional.ofNullable(city)
            .map(City::getName)
            .orElseGet(() -> printTest());
    }

    public String orElseTest(){
        City city = new City("pusan");
        return Optional.ofNullable(city)
                       .map(City::getName)
                       .orElse(printTest());
    }

    private String printTest(){
        System.out.println("print test !!!!!!!!!");
        return "incheol";
    }

    public static void main(String[] args) {
        Example example = new Example();

        System.out.println("orElseGetTest -> " + example.orElseGetTest());
        System.out.println("orElseTest -> " + example.orElseTest());
    }
}
