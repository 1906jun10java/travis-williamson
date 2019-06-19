package com.revature.strings;

public class Wednesday {

	public static void main (String[] args) {
		String yourString = "String";
		String reversedString = reverseString(yourString);
		System.out.println("Reverse of your String = " + reversedString);
		System.out.println();
		
		String palindromeCheck = "racecar";
		System.out.println("Is " + palindromeCheck + " a palindrome? A: " + isPalindrome(palindromeCheck));
		System.out.println();
		
		int n = 5;
		System.out.println("The factorial of " + n + " is: " + calculateFactorial(5));
		System.out.println();
		
		String yourString2 = "String";
		String recursiveReversedString = reverseStringUsingRecursion(yourString2);
		System.out.println("Reverse of your String, using recursion = " + recursiveReversedString);
		System.out.println();
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
	
	public static int calculateFactorial (int n) {
		//
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * calculateFactorial(n - 1);
	}
	
	public static String reverseStringUsingRecursion (String str) {
		String lastChar = str.substring(str.length()-1);
		String firstChars = str.substring(0, str.length()-1);
		
		// base case
		if (str.length() == 1) {
			return str.substring(0);
		}
		
		// recursive case
		return lastChar + reverseStringUsingRecursion(firstChars);
		
	}
}
