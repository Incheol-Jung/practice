package com.example.practice.statics;

/**
 * @author Incheol Jung
 */
public class StaticCar {
    static String _where="I am a Car from Germany!";
    Country _country;            // object of inner class country
    StaticCar(){
        _country=new Country();    // instantiate the inner class
    }
    static class Country {       // static member inner class
        String showCountry() {
            return _where;
        }
    }

    public static void main(String[] args) {

        StaticCar myCar = new StaticCar() ;  // instantiated object of class StaticCar
        System.out.print("Access through an Country reference");
        System.out.println(" created in an object of a StaticCar:");
        System.out.println(myCar._country.showCountry());

        // instantiated object of class StaticCar.Country
        StaticCar.Country country = new StaticCar.Country();
        StaticCar.Country country2 = new StaticCar.Country();
        System.out.println("Access through an Country reference that is local:");
        System.out.println(country.showCountry());
        System.out.println("is same?? = " + (country == country2));
    }
}
