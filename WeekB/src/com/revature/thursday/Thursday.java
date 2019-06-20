package com.revature.thursday;

public class Thursday {

	public static void main(String[] args) {
		String mainString = "engineers";
		String subString = "gin";
		System.out.println("Does " + mainString + " contain " + subString + " as a substring? " + containsSubstring(mainString, subString));
		System.out.println();
		
		int rows = 4;
		
		System.out.println("How many blocks does a triangle with " + rows + " rows contain? " + triangle(rows));
		//
		System.out.println();
	}
	
	public static boolean containsSubstring (String str, String substr) {
		boolean hasSubstring = false;
		
		int substrLength = substr.length();
		
		for (int i = 0; i <= str.length() - substrLength; i++) {
			//System.out.println(str.substring(i, substrLength + i));
			if (str.substring(i, substrLength + i).equals(substr)) {
				hasSubstring = true;
			}
		}
		return hasSubstring;
	}
	
	public static int triangle (int numRows) {
		int blocks = numRows;
		
		// base case
		if (numRows == 1) {
			return numRows;
		}
		// recursive case
		
		return blocks + triangle(numRows - 1);
	}
}
