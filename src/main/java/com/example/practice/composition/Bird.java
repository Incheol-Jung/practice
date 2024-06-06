package com.example.practice.composition;

import java.util.HashMap;

/**
 * @author Incheol Jung
 */
public class Bird extends Animal {
	private int wingCount;

	public void printName() {
		super.printName();
		System.out.println("I have ${wingCount} wings");
	}

	private void fly() {
		System.out.println("fly with wings");
	}

	protected void move() {
		this.fly();
	}

	public static void main(String[] args) {
		HashMap<Person, Integer> hashMap = new HashMap<>();
		Person person1 = new Person("aaa", 1);
		Person person2 = new Person("aaa", 2);
		hashMap.put(person1, 1);
		hashMap.put(person2, 2); // 1 -> 2
		// hashMap.remove(person2);
		System.out.println(hashMap.get(person1)); // 1
		System.out.println(hashMap.get(person2)); // 2
	}
}
class Person {
	private String name;
	private Integer age;

	@Override
	public int hashCode() {
		return 11;
	}

	@Override
	public boolean equals(Object obj) {
		Person temp = null;
		if(obj instanceof Person){
			temp = (Person)obj;
		}
		return this.name.equals(temp.name) && this.age.equals(temp.age);
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}
