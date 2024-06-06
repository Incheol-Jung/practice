package com.example.practice.effective52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Incheol.Jung
 * @since 2024. 06. 06.
 */
public class SetList {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		List<Integer> list = new ArrayList<>();

		for (int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}

		for (int i = 0; i < 3; i++) {
			set.remove(i);
			list.remove(i);
		}

		System.out.println(set + " " + list);
	}
}
