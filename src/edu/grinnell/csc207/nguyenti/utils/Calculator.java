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
		if (!(new BigInteger(strArray[i + 1])).equals(BigInteger
			.valueOf(0))) {
		    current = current.divide(new BigInteger(strArray[i + 1]));
		} else {
		    throw new ArithmeticException("Cannot divide by zero");
		}
	    } else if (strArray[i].equals("^")) {
		current = current.pow(Integer.valueOf(strArray[i + 1]));
	    } else {
		throw new IllegalArgumentException(
			"The only legal operators are + - * / ^");
	    }
	}
	return current;
    }

    public static int[] fewestCoins(int denomination) {
	int[] coins = { (int) Math.ceil(denomination / 2.0), 0, 0, 0 };
	for (int twos = 0; twos < (int) Math.ceil(denomination / 2.0) + 1; twos++) {
	    for (int sevens = 0; sevens < (int) Math.ceil(denomination / 7.0) + 1; sevens++) {
		for (int elevens = 0; elevens < (int) Math
			.ceil(denomination / 11.0) + 1; elevens++) {
		    for (int fiftyfours = 0; fiftyfours < (int) Math
			    .ceil(denomination / 54.0) + 1; fiftyfours++) {
			if (twos * 2 + sevens * 7 + elevens * 11 + fiftyfours
				* 54 == denomination
				&& twos + sevens + elevens + fiftyfours < (coins[0]
					+ coins[1] + coins[2] + coins[3])) {
			    coins[0] = twos;
			    coins[1] = sevens;
			    coins[2] = elevens;
			    coins[3] = fiftyfours;
			}
		    }
		}
	    }
	}

	return coins;
    }
}