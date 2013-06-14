package com.qsoft.longdt;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int add(String input) {
		if (input.isEmpty()) {
			return 0;
		} else if (input.length() == 1) {
			return toInt(input);
		} else if (input.contains(",")) {
			return methodSum1(input);
		}
		return -1;
	}

	private static int toInt(String input) {
		return Integer.parseInt(input);
	}

	private static int methodSum1(String input) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(input);
		while (m.find()) {
			int number = toInt(m.group());
			ints.add(number);
		}

		int sum = 0;
		for (Integer integer : ints) {
			sum += integer;
		}
		return sum;
	}
}
