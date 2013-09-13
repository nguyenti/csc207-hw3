package edu.grinnell.csc207.nguyenti.utils;

import java.util.ArrayList;

public class StringUtils {

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

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '"') {
				if (charArray.length > i + 1 && charArray[i + 1] == '"') {
					current = current + '"';
					i += 1;
				} else /* next character != '"' */{
					if (inQuotes) {
						inQuotes = false;
					} else /* !inQuotes */{
						for (int j = i + 1; j < charArray.length; j++) {
							if (charArray[j] == '"') {
								inQuotes = true;
							}
						}
					}
				}
			} else /* charArray[i] != '"' */{
				if (charArray[i] == separator && !inQuotes) {
					if (!current.equals("")) {
						all.add(current);
					}
					current = "";
				} else /* charArray[i] != '"' or ',' */{
					current = current + charArray[i];
				}
			}
		}

		if (!current.equals("")) {
			all.add(current);
		}

		String[] array = all.toArray(new String[all.size()]);
		return array;
	}// splitCSV

	public String deLeet(String hackerType) {
		String[][] things = { { "|\\|", "n" }, { "|3", "b" }, { "3", "e" },
				{ "+", "t" }, { "@", "a" }, { "1", "l" }, { "0", "o" } };
		for (String[] pair : things) {
			hackerType = hackerType.replace(pair[0], pair[1]);
		}
		return hackerType;
	}

}
