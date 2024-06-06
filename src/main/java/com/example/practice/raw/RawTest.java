package com.example.practice.raw;

import static com.example.practice.raw.Wild.*;
import static org.springframework.boot.context.properties.bind.Bindable.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Incheol.Jung
 * @since 2024. 03. 13.
 */
class Stack<E> {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();

		// push에서 E 타입만 허용하므로 이 형변환은 안전하다.
		@SuppressWarnings("unchecked") E result =
			(E)elements[--size];

		elements[size] = null; // 다 쓴 참조 해제
		return result;
	}

	// 매개변수의 원소들을 스택에 넣는 메서드를 추가한다.
	public void pushAll(Iterable<? extends E> src) {
		for (E e : src) {
			push(e);
		}
	}

	// 모든 원소를 매개변수로 전달받은 컬렉션에 옮긴다.
	public void popAll(Collection<E> dst) {
		while (!isEmpty()) {
			dst.add(pop());
		}
	}

	public static void main(String[] args) {
		Stack<Parent> numbers = new Stack<>();
		Collection<Child> objects = Arrays.asList(new Child());

		// numbers.popAll(objects);
	}
}

class Parent {

}

class Child extends Parent {

}

class Generic<T> {
	private List<T> items= new ArrayList<>();

	void add(T item) {
		items.add(item);
	}
}

class Wild {
	private Collection<?> items;

	void add(List<? extends Parent> params) {
		// items.addAll(params);
	}

	public static double sumOfList(List<? extends Number> list) {
		double s = 0.0;
		for (Number n : list) {
			s += n.doubleValue();
		}
		return s;
	}
}

class ParentProcessor {

	public static <T> void processGeneric(List<T> animals) {
		for (T animal : animals) {
			// 동물을 처리하는 로직
		}
	}

	// 모든 종류의 동물을 처리하는 메서드
	public static void processParents(List<? extends Parent> animals) {
		for (Parent animal : animals) {
			// 동물을 처리하는 로직
		}
	}

	// 또 다른 예시: 동물 목록을 출력하는 메서드
	public static void printParents(List<? extends Parent> animals) {
		for (Parent animal : animals) {
			System.out.println(animal);
		}
	}
}

class Item26 {

	public static void main(String[] args) {
		Generic<Child> generic = new Generic<>();
		generic.add(new Child());
		// generic.add(new Parent());
		ParentProcessor.processGeneric(new ArrayList<Child>());
		ParentProcessor.processGeneric(new ArrayList<Parent>());
		List<Integer> li = Arrays.asList(1, 2, 3);
		System.out.println("sum = " + Wild.sumOfList(li));

		List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		System.out.println("sum = " + Wild.sumOfList(ld));

		sumOfList(Arrays.asList(1, 2, 3, 4));

		// List<Integer> li = Arrays.asList(1, 2, 3);
		List<String> ls = Arrays.asList("one", "two", "three");
		printList(li); // 컴파일 에러 발생
		printList(ls); // 컴파일 에러 발생
		int val = Item26.numElementsInCommon(new HashSet<>(Arrays.asList("tiger", "lion", "fox")),
			new HashSet<>(Arrays.asList(1, 2, 3)));
		System.out.println(val);

		int val2 = Item26.numElementsInCommon2(new HashSet<>(Arrays.asList("tiger", "lion", "fox")),
			new HashSet<>(Arrays.asList(1, 2, 3)));
		System.out.println(val2);

	}

	public static void printList(List<?> list) {
		for (Object elem : list) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	static int numElementsInCommon(Set<?> s1, Set<?> s2) {
		int result = 0;
		// s1.add(1);
		for (Object o1 : s1) {
			if (s2.contains(o1)) {
				result++;
			}
		}
		return result;
	}

	static int numElementsInCommon2(Set s1, Set s2) {
		int result = 0;
		s1.add(1);
		for (Object o1 : s1) {
			if (s2.contains(o1)) {
				result++;
			}
		}
		return result;
	}
}
