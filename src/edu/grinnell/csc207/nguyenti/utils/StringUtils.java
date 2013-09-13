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

	// Iterate through charArray
	for (int i = 0; i < charArray.length; i++) {
	    // If the character at [i] is '"'...
	    if (charArray[i] == '"') {
		// If it is a double-quote, then treat it as '"' and move on
		if (charArray.length > i + 1 && charArray[i + 1] == '"') {
		    current = current + '"';
		    i += 1;
		} else {
		    // If a quote was already established, end it
		    if (inQuotes) {
			inQuotes = false;
		    } else {
			// If there is another quote character later, start a
			// quote. Otherwise, ignore it.
			for (int j = i + 1; j < charArray.length; j++) {
			    if (charArray[j] == '"'
				    && (charArray.length <= j + 1 || charArray[j + 1] != '"')) {
				inQuotes = true;
			    }
			}
		    }
		}
	    } else {
		// If the character at [i] is the separator (and not within
		// quotes) then separate the strings
		if (charArray[i] == separator && !inQuotes) {
		    all.add(current);
		    current = "";
		} else {
		    // If the character at [i] is not a special character, add
		    // it to the current string
		    current = current + charArray[i];
		}
	    }
	}

	// Add the final string
	if (!current.equals("")) {
	    all.add(current);
	}

	String[] array = all.toArray(new String[all.size()]);
	return array;
    }// splitCSV
}
