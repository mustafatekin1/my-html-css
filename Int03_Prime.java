package interviewquestions;

import java.util.Scanner;

public class Int03_Prime {

	public static void main(String[] args) {

		System.out.println("Please enter a number to check if it is prime or not");
		Scanner scan = new Scanner (System.in);
		int num = scan.nextInt();
		
		checkPrime(num);
		System.out.println(checkPrime(num));
		

	}
// Create a method which checks if the number is prime or not
	public static boolean checkPrime(int num) {
		boolean check = true;
		if (num<0) {
			System.out.println("Please enter a positive number");
		}
		else if (num==1) {
			System.out.println("1 is a prime number");
		}
		
		else {
			int counter = 1;
			for (int i=2; i<num; i++) {
				
				if (num%i == 0) {
					counter++;
				}
			}
				
			if (counter>1) {
				check = true;
				System.out.println("This is a prime number");
				}
			
			else {
				check = false;
					System.out.println("This is NOT a prime number");
				}

			}
		return check;
	}
	
				
	
	}
