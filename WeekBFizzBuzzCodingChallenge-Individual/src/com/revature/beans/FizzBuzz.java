package com.revature.beans;

public class FizzBuzz {

	public void fizzBuzzBasic() {
		for (int i = 1; i <= 100; i++) {
			if(i % 3 == 0 & i % 5 == 0) {
				System.out.print("fizzbuzz");
			}
			else if(i % 3 == 0) {
				System.out.print("fizz");
			}
			else if(i % 5 == 0){
				System.out.print("buzz");
			}
			else {
				System.out.print(i);
			}
			if(i < 100) {
				System.out.print(", ");
			}
		}
	}
	
	public void fizzBuzzAdvanced(int m, int n, int[] numbers, String[] terms) {
		boolean printed = false;
		
		for (int i = m; i <= n; i++) {
			for(int j = 0; j < numbers.length; j++) {
				if(i % numbers[j] == 0) {
					System.out.print(terms[j]);
					printed = true;
				}
				else if(printed == false & j == (numbers.length -1)) {
					System.out.print(i);
				}
			}
			
			if(i < n) {
				System.out.print(", ");
			}
			
			printed = false;
			
		}
		// Attempt # 1
		/*for (int i = m; i <= n; i++) {
			if(i % numbers[0] == 0 & i % numbers[1] == 0) {
				System.out.print(terms[0] + terms[1] + ", ");
			}
			else if(i % numbers[0] == 0) {
				System.out.print(terms[0] + ", ");
			}
			else if(i % numbers[1] == 0){
				System.out.print(terms[1] + ", ");
			}
			else {
				System.out.print(i + ", ");
			}
		}
		*/
	}
}
