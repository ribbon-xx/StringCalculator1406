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
		} else if (!input.startsWith("//")) {
			return methodSum(input);
		} else {
			String tmp = replaceDelim(input);
			return methodSum(tmp);
		}
	}

	private static int toInt(String input) {
		return Integer.parseInt(input);
	}

	private static int methodSum(String input) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(input);
		while (m.find()) {
			int number = toInt(m.group());
			if (number < 0) {
				throw new NumberFormatException("negatives not allowed "
						+ number);
			}
			ints.add(number);
		}

		int sum = 0;
		for (Integer integer : ints) {
			sum += integer;
		}
		return sum;
	}

	private static String replaceDelim(String input) {
		String tmp = input.substring(2);
		while (tmp.contains("[")) {
			int pos1 = tmp.indexOf("[");
			int pos2 = tmp.indexOf("]");
			if (tmp.indexOf("[", pos1 + 1) == pos1) {
				String delimContent = tmp.substring(pos1 + 1,
						tmp.lastIndexOf("]"));
				String delimDefine = tmp.substring(pos1,
						tmp.lastIndexOf("]") + 1);
				tmp = tmp.replaceAll(Pattern.quote(delimDefine), "");
				tmp = tmp.replaceAll(Pattern.quote(delimContent), ",");
			} else {
				String delimContent = tmp.substring(pos1 + 1, pos2);
				String delimDefine = tmp.substring(pos1, pos2 + 1);
				tmp = tmp.replaceAll(Pattern.quote(delimDefine), "");
				tmp = tmp.replaceAll(Pattern.quote(delimContent), ",");
			}
		}
		return tmp;
	}
}
