package edu.grinnell.csc207.nguyenti.utils;

import java.util.ArrayList;

public class StringUtils {

	public static void main(String args[]) {
		String[] ary = StringUtils.splitCSV("a,\"b,b\"\",c");
		System.out.print("{ ");
		for (int i = 0; i < ary.length; i++) {
			System.out.print(ary[i]);
			System.out.print(" ; ");
		}
		System.out.println("}");
	}

	public static String[] splitAt(String str, char c) {
		char[] charArray = str.toCharArray();
		String current = "";
		ArrayList<String> all = new ArrayList<String>();

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != c) {
				current = current + charArray[i];
			} else {
				all.add(current);
				current = "";
			}
		}

		all.add(current);

		String[] array = all.toArray(new String[all.size()]);
		return array;
	}// SplitAt

	public static String[] splitCSV(String str) {
		char[] charArray = str.toCharArray();
		String current = "";
		ArrayList<String> all = new ArrayList<String>();
		char separator = ',';
		boolean inQuotes = false;

		// Iterate through charArray
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '"') {
				// If the character at [i] is '"'...
				if (charArray.length > i + 1 && charArray[i + 1] == '"') {
					// If it is a double-quote, then treat it as '"' and move on
					current = current + '"';
					i += 1;
				} else if(inQuotes){
					// If a quote was already established, end it
					inQuotes = false;
				} else {
					// Else start a quote
					inQuotes = true;
				}
			} else if (charArray[i] == separator && !inQuotes) {
				// If the character at [i] is the separator (and not within
				// quotes) then separate the strings
					all.add(current);
					current = "";
			} else {
					// If the character at [i] is not a special character, add
					// it to the current string
					current = current + charArray[i];
			}
		}

		if (!current.equals("")) {
			// Add the final string
			all.add(current);
		}
		String[] array = all.toArray(new String[all.size()]);
		return array;
	}// splitCSV

	public static String deLeet(String hackerType) {
		String[][] things = { { "|\\|", "n" }, { "|3", "b" }, { "3", "e" },
				{ "+", "t" }, { "@", "a" }, { "1", "l" }, { "0", "o" } };
		for (String[] pair : things) {
			hackerType = hackerType.replace(pair[0], pair[1]);
		}
		return hackerType;
	}

}
