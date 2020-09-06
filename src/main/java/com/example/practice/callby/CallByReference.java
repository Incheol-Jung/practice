package com.example.practice.callby;

/**
 * @author Incheol Jung
 */
public class CallByReference {
    private class Person{
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + '}';
        }
    }

    public static void swap(Person x, Person y) {
        String temp = x.name;
        x.name = y.name;
        y.name = temp;
    }

    public static void main(String[] args) {
        CallByReference example = new CallByReference();
        example.test();
    }

    private void test() {
        Person incheol = new Person("incheol");
        Person andrew = new Person("andrew");

        System.out.println("swap() 호출 전 : incheol = " + incheol + ", andrew = " + andrew);
        swap(incheol, andrew);
        System.out.println("swap() 호출 후 : incheol = " + incheol + ", andrew = " + andrew);
    }
}
