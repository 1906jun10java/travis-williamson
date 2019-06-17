package com.revature.demo;
import com.revature.beans.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		FizzBuzz fb = new FizzBuzz();
		fb.fizzBuzzBasic();
		System.out.println();
		System.out.println();
		
		/* First hardcoding test for fizzBuzzAdvanced() - "do, re, mi"
		int[] numbers = {2, 3, 5};
		String[] terms = {"do", "re", "mi"};
		fb.fizzBuzzAdvanced(1, 30, numbers, terms);
		*/
		
		/* Second hardcoding test for fizzBuzzAdvanced() - "fizz, buzz"
		int[] numbers = {3, 5};
		String[] terms = {"fizz", "buzz"};
		fb.fizzBuzzAdvanced(1, 100, numbers, terms);
		*/
		
		// Attempt with Scanner class
		Scanner sc = new Scanner(System.in);
		System.out.println("Type the first number for your range: ");
		int firstNumberInRange = sc.nextInt();
		
		System.out.println("Type the second number for your range: ");
		int secondNumberInRange = sc.nextInt();
		
		while (secondNumberInRange < firstNumberInRange) {
			System.out.println("The second number must be larger than the first number");
			System.out.println("Type the second number for your range: ");
			secondNumberInRange = sc.nextInt();
		}
		
		System.out.println("Your range is: " + firstNumberInRange + "-" + secondNumberInRange);
		
		System.out.println("Type the length you would like for an array of integer numbers: ");
		System.out.println("(Length must be greater than 1)");
		int arrayLength = sc.nextInt();
		
		while(arrayLength < 2) {
			System.out.println("The length of the array must be greater than 1.");
			System.out.println("Type the length you would like for an array of integer numbers: ");
			arrayLength = sc.nextInt();
		}
		
		int[] numbersArray = new int[arrayLength];
		
		System.out.println("Type your first number: ");
		int numberForArray = sc.nextInt();
		
		numbersArray[0] = numberForArray;
		
		for(int i = 1; i < numbersArray.length; i++) {
			System.out.println("Type another number for your array: ");
			numberForArray = sc.nextInt();
			
			numbersArray[i] = numberForArray;
		}
		
		System.out.println("Type in your first word for a String array of the same length as your numbers array: ");
		String stringForArray = sc.next();
		
		String[] stringArray = new String[arrayLength];
		stringArray[0] = stringForArray;
		
		for(int i = 1; i < stringArray.length; i++) {
			System.out.println("Type another word for your String array: ");
			stringForArray = sc.next();
			
			stringArray[i] = stringForArray;
		}
		
		//To check to see if arrays are being created properly
		//System.out.println("Your number array is: " + Arrays.toString(numbersArray));
		//System.out.println("Your String array is: " + Arrays.toString(stringArray));
		
		System.out.println();
		System.out.println();
		
		fb.fizzBuzzAdvanced(firstNumberInRange, secondNumberInRange, numbersArray, stringArray);
	}
}
