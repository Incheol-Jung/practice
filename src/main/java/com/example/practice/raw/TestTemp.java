package com.example.practice.raw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Incheol.Jung
 * @since 2024. 04. 15.
 */
public class TestTemp<T> {
	private List<T> items;

	public void pushAll(List<T> src) {
		for (T t : src) {

		}
	}

	public void swap(List<T> list, int i, int j) {

	}

	// @SafeVarargs
	public final void test22(List<T> src) {

		for (T t : src) {
			System.out.println(t);
		}
	}

	public void pushAll2(Iterable<?> src) {
		Set s = new TreeSet<Integer>();
		Set<String> ss = s;
		// src.forEach(temp -> System.out.println(temp));
	}

	public static void main(String[] args) {
		String temp = "dsa";
		TestTemp test = new TestTemp<Integer>();
		List<String> testtt = new ArrayList();
		test.swap(testtt, 1, 2);
	}
}

class Person {

}

class Person2 extends Person {

}
