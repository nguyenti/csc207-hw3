package edu.grinnell.csc207.nguyenti.utils;

import java.util.ArrayList;

public class StringUtils {

    public static String[] SplitAt(String str, char c) {
	char[] charArray = str.toCharArray();
	String current = "";
	ArrayList<String> all = new ArrayList<String>();

	for (int i = 0; i <= charArray.length; i++) {
	    if (charArray[i] != c) {
		current = current + charArray[i];
	    } else {
		if (!current.equals("")) {
		    all.add(current);
		}
		current = "";
	    }
	}

	if (!current.equals("")) {
	    all.add(current);
	}

	String[] array = all.toArray(new String[all.size()]);
	return array;
    }// SplitAt

    public static String[] splitCSV(String str) {
	char[] charArray = str.toCharArray();
	String current = "";
	ArrayList<String> all = new ArrayList<String>();
	char separator = ',';
	
	for (int i = 0; i < charArray.length; i++) {
	    if (charArray[i] == '"') {
		if (charArray[i] == '"' && ){ //&& !current.equals("")) {
		    all.add(current);
		current = "";
		}
	    } else 
	}

	if (!current.equals("")) {
	    all.add(current);
	}

	String[] array = all.toArray(new String[all.size()]);
	return array;
    }// splitCSV
}
