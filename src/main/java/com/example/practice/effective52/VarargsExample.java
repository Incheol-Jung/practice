package com.example.practice.effective52;

import static org.springframework.boot.context.properties.bind.Bindable.*;

/**
 * @author Incheol.Jung
 * @since 2024. 06. 06.
 */
public class VarargsExample {
	static int sum(int... args) {
		int sum = 0;
		for (int arg : args) {
			sum += arg;
		}

		return sum;
	}

	static int sum2(int... args) {
		if(args.length == 0){
			throw new IllegalArgumentException("인수가 1개 이상 필요합니다");
		}

		int sum = 0;
		for (int arg : args) {
			sum += arg;
		}

		return sum;
	}

	static int sum3(int first, int... args) {
		int sum = 0;
		for (int arg : args) {
			sum += arg;
		}
		return sum;
	}

	public static void main(String[] args) {
		int sum = VarargsExample.sum(1, 2, 3, 4, 5);
		System.out.println(sum);
	}
}
