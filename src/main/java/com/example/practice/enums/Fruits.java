package com.example.practice.enums;

/**
 * @author Incheol Jung
 */
public class Fruits {
    public static final String APPLE = "apple";
    public static final String BANANA = "banana";
    public static final String ORANGE = "orange";
    public static final String PINEAPPLE = "pineapple";
    public static final String MANGGO = "manggo";

    enum FruitsEnum {
        APPLE("apple"),
        BANANA("banana"),
        ORANGE("orange"),
        PINEAPPLE("pineapple"),
        MANGGO("manggo");

        private String value;

        FruitsEnum(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        String myFruit = "apple";

        switch(myFruit){
            case APPLE:
                System.out.println("this is apple");
                break;
            case BANANA:
                System.out.println("this is banana");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + myFruit);
        }

        FruitsEnum myFruitEnum = FruitsEnum.APPLE;

        switch(myFruitEnum){
            case APPLE :
                System.out.println("this is apple!!");
                break;
            case BANANA :
                System.out.println("this is banana!!");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + myFruit);
        }
    }
}
