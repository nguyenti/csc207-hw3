package edu.grinnell.csc207.nguyenti.utils;

import java.math.BigInteger;

public class Calculator {

	// NOTE: input must be in the form
	// "[int] [operator] [int] [operator] ... [int]"
	public static BigInteger eval0(String input) {

		String[] strArray = StringUtils.splitAt(input, ' ');
		BigInteger current = new BigInteger(strArray[0]);

		for (int i = 1; i < strArray.length; i += 2) {
			if (strArray[i].equals("+")) {
				current = current.add(new BigInteger(strArray[i + 1]));
			} else if (strArray[i].equals("-")) {
				current = current.subtract(new BigInteger(strArray[i + 1]));
			} else if (strArray[i].equals("*")) {
				current = current.multiply(new BigInteger(strArray[i + 1]));
			} else if (strArray[i].equals("/")) {
				current = current.divide(new BigInteger(strArray[i + 1]));
			} else if (strArray[i].equals("^")) {
				current = current.pow(Integer.valueOf(strArray[i + 1]));
			} else {
				throw new IllegalArgumentException(
						"The only legal operators are + - * / ^");
			}
		}

		return current;
	}
}
