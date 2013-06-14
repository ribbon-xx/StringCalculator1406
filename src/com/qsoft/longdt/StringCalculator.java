package com.qsoft.longdt;

public class StringCalculator {

	public static int add(String input) {
		if (input.isEmpty()) {
			return 0;
		} else if (input.length() == 1) {
			return toInt(input);
		}
		return -1;
	}

	private static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
