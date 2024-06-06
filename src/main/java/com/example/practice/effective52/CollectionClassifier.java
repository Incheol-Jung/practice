package com.example.practice.effective52;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Incheol.Jung
 * @since 2024. 06. 06.
 */
public class CollectionClassifier {
	public static String classify(Set<?> s) {
		return "집합";
	}

	public static String classify(List<?> s) {
		return "리스트";
	}

	public static String classify(Collection<?> s) {
		return "그 외";
	}

	public static void main(String[] args) {
		Collection<?>[] collections = {
			new HashSet<String>(),
			new ArrayList<String>(),
			new HashMap<String, String>().values(),
		};

		for (Collection<?> c : collections) {
			System.out.println(classify(c));
		}
	}
}
