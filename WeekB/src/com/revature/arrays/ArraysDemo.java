package com.revature.arrays;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		
		// create a 2D array of ints
		
		int[][] arr1 = new int[10][20];
		
		// really creating an array of arrays
		int[][] arr2 = {{6,5,4},{3,2,1}};
		
		
		
		/*
		 * 1 2 3
		 * 4 5 6
		 */
		
		/*
		 * Emily's code:
		 * 
		for (int i = 0; i < arr2.length; i++) { // iterating over rows
			for(int j = 0; j < arr2[i].length; j++) { // iterating columns in a row
				System.out.println("i = " + i);
				System.out.println("j = " + j);
				System.out.println("arr2[i][j] = " + arr2[i][j]);
			}
		}
		*/
		
		// 1D array
		int[] arr1D = {5, 7, 2, 9, 4};
		
		// 2D array
		int[][] arr2D = {{1,2,3},{4,5,6}};
		
		int[][] arr2D2 = {{6,5,4},{3,2,1}};
		
		/*
		System.out.println("Sum of all elements in arr2 = " + sumElement(arr2));
		System.out.println();
		System.out.println("Largest element in arr2 = " + largestElement(arr2));
		System.out.println();
		System.out.println("Unsorted array arr2 = " + Arrays.toString(arr2[0]) + Arrays.toString(arr2[1]));
		System.out.println();
		sortArray(arr2);
		System.out.println("Sorted array arr2 = " + Arrays.toString(arr2[0]) + Arrays.toString(arr2[1]));
		
		*/
		
		// For 1D Array:
		/*
		System.out.println("Unsorted 1D array arr1D = " + Arrays.toString(arr1D));
		System.out.println();
		sort1DArray(arr1D);
		System.out.println("Sorted 1D array arr1D = " + Arrays.toString(arr1D));
		System.out.println();
		*/
		
		System.out.println("Unsorted 2D array arr2D = " + Arrays.toString(arr2D[0]) + Arrays.toString(arr2D[1]));
		System.out.println();
		sort2DArray(arr2D);
		System.out.println("Sorted 2D array arr2D = " +Arrays.toString(arr2D[0]) + Arrays.toString(arr2D[1]));
		System.out.println();
		
		System.out.println("Unsorted 2D array arr2D2 = " + Arrays.toString(arr2D2[0]) + Arrays.toString(arr2D2[1]));
		System.out.println();
		sort2DArray(arr2D2);
		System.out.println("Sorted 2D array arr2D2 = " +Arrays.toString(arr2D2[0]) + Arrays.toString(arr2D2[1]));
		
	}
	
	// Return the largest element in the provided array
	
	public static int largestElement(int[][] arr) {
		int largestElement = arr[0][0];
		
		for (int i = 0; i < arr.length; i++) { // iterating over rows
			for(int j = 0; j < arr[i].length; j++) { // iterating columns in a row
				if (arr[i][j] > largestElement) {
					largestElement = arr[i][j];
				}
			}
		}
		return largestElement;
	}
	
	// Return the sum of all elements in the provided array
	
	public static int sumElement(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) { // iterating over rows
			for(int j = 0; j < arr[i].length; j++) { // iterating columns in a row
				sum = sum + arr[i][j];
			}
		}
		return sum;
	}
	
	// Sort provided array from top left to bottom right
	
	public static int[][] sort2DArray(int[][] arr) {
		//int previousElement = arr[0][0];
		
		int tempElement1;
		int tempElement2;
		
		for (int i = arr.length-1; i >= 0; i--) { // iterating over rows
		//for (int i = 0; i < arr.length; i++) { // iterating over rows
			for(int j = arr[i].length-1; j >= 0; j--) {
			//for(int j = 0; j < arr[i].length; j++) { // iterating columns in a row
				for(int k = arr[i].length-1; k >= 0; k--) {
				//for(int k = 0; k < arr[i].length-1; k++) {
					if (arr[i][k] > arr[i][j]) {
					
						tempElement1 = arr[i][k];
						tempElement2 = arr[i][j];
						arr[i][k] = tempElement2;
						arr[i][j] = tempElement1;
					}	
				}
			}
		}
		
		return arr;
	}
	
	// Sort provided array from top left to bottom right
	
		public static int[] sort1DArray(int[] arr) {
			
			int tempElement1;
			int tempElement2;
			
			for (int i = 0; i < arr.length; i++) { // iterating over rows
				for(int j = 0; j < arr.length - 1; j++) { // iterating columns in a row
					if (arr[j] > arr[i]) {
						
						tempElement1 = arr[i];
						tempElement2 = arr[j];
						arr[i] = tempElement2;
						arr[j] = tempElement1;
						
					}
				}
			}
			
			return arr;
		}
}
