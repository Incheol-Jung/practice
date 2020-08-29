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

    public String orElseThrowTest() throws Exception {
        City city = new City("pusan");
        return Optional.ofNullable(city)
                       .map(City::getName)
                       .orElseThrow(Exception::new);
    }

    public Optional<Address> orTest() throws Exception {
        City city = new City();
        Address address = city.getAddress();
        Address notEmptyAddress = new Address("seongnam");
        Address notEmptyAddress2 = new Address("daegue");

        return Optional.ofNullable(address)
                       .filter(a -> a.getStreet().contains("seoul"))
                       .or(Optional::empty)
                       .or(() -> Optional.ofNullable(notEmptyAddress))
                       .or(() -> Optional.ofNullable(notEmptyAddress2));

        return Optional.ofNullable(address)
                       .filter(a -> a.getStreet().contains("seoul"))
                       .or(() -> Optional.ofNullable(notEmptyAddress2))
                       .or(() -> Optional.ofNullable(notEmptyAddress));
    }

    private String printTest(){
        System.out.println("print test !!!!!!!!!");
        return "incheol";
    }

    public void ifPresentTest(){
        City city = new City("seoul");
        Optional.ofNullable(city).ifPresent(i -> System.out.println(i.getName()));
    }

    public static void main(String[] args) throws Exception {
        Example example = new Example();

//        System.out.println("orElseGetTest -> " + example.orElseGetTest());
//        System.out.println("orElseTest -> " + example.orElseTest());
        example.orTest().ifPresent((value) -> System.out.println(value.getStreet()));
    }
}
