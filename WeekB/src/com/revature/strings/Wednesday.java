package com.revature.strings;

public class Wednesday {

	public static void main (String[] args) {
		String yourString = "Travis";
		String reversedString = reverseString(yourString);
		System.out.println("Reverse of your String = " + reversedString);
		System.out.println();
		System.out.println("Is racecar a palindrome? A: " + isPalindrome("racecar"));
	}
	
	public static String reverseString (String str) {
		String reversedStr = "";
		
		char[] charArray = str.toCharArray();
		char[] reverseCharArray = new char[charArray.length];
		
		for (int i = 0; i < charArray.length; i++) {	
			reverseCharArray[charArray.length - (i+1)] = charArray[i];
		}
		
		for (int i = 0; i < reverseCharArray.length; i++) {
			reversedStr = reversedStr + reverseCharArray[i];
		}
		
		return reversedStr;
	}
	
	public static boolean isPalindrome (String str) {
		
		boolean palindrome = false;
		
		if (str.equals(reverseString(str))) {
			palindrome = true;
		}
		return palindrome;
	}
}
