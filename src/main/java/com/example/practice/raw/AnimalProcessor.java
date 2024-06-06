// package com.example.practice.raw;
//
//
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collection;
// import java.util.List;
//
// /**
//  * @author Incheol.Jung
//  * @since 2024. 03. 17.
//  */
// class Animal {
// 	// 동물의 공통 속성과 동작
// }
//
// class Dog extends Animal {
// 	// 개의 고유한 속성과 동작
// }
//
// class Cat extends Animal {
// 	// 고양이의 고유한 속성과 동작
// }
//
// public class AnimalProcessor {
// 	// 제네릭을 사용하여 모든 종류의 동물을 저장하고 반환하는 메서드
// 	public static <T extends Animal> List<T> getAnimals() {
// 		List<T> animals = new ArrayList<>();
// 		// 동물을 가져오는 로직
// 		return animals;
// 	}
//
// 	// 제네릭을 사용하여 동물 목록을 처리하는 메서드
// 	public static <T extends Animal> void processAnimals(List<T> animals) {
// 		animals.add(new Dog());
// 		for (T animal : animals) {
// 			// 동물을 처리하는 로직
// 			System.out.println(animal.getClass());
// 		}
// 	}
//
// 	public static void processAnimals2(List<? super Animal> animals) {
// 		animals.add(new Dog());
// 		for (Animal animal : animals) {
// 			// 동물을 처리하는 로직
// 			System.out.println(animal.getClass());
// 		}
// 	}
//
//
// 	static void printArray(Object[] arr) {
// 		for (Object e : arr) {
// 			System.out.println(e);
// 		}
// 	}
//
// 	static void printCollection(Collection<Object> c) {
// 		for (Object e : c) {
// 			System.out.println(e);
// 		}
// 	}
//
// 	public static void main(String[] args) {
// 		Integer[] integers = new Integer[]{1, 2, 3};
// 		printArray(integers);
// 		List<Integer> list = Arrays.asList(1, 2, 3);
// 		printCollection(list);
//
// 		AnimalProcessor.getAnimals();
// 		List<Animal> animals = List.of(new Dog(), new Cat());
// 		AnimalProcessor.processAnimals(animals);
// 		AnimalProcessor.processAnimals(new ArrayList<Cat>());
// 		AnimalProcessor.processAnimals(new ArrayList<Dog>());
// 	}
// }