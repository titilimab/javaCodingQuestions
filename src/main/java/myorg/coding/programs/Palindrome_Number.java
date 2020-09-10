package myorg.coding.programs;

import java.util.Scanner;

public class Palindrome_Number {
	
	public static void main(String[] args) {
		
		Scanner sn = new Scanner(System.in);
		int num = sn.nextInt();
		
		int remainder, sum = 0;
		int temp;
		
		temp = num;
		while(num > 0) {
			remainder = num%10;
			sum = (sum*10)+remainder;
			num = num/10;
		}
		
		System.out.println("Before reverse : "+temp+"\nAfter reverse : "+sum);
		
		if(sum == temp)
			System.out.println("The number : "+temp+" is a Palindrome");
		else
			System.out.println("The number : "+temp+" is not a Palindrome");
	}

	/*Console Output :
	  
	 1234321
	Before reverse : 1234321
	After reverse : 1234321
	The number : 1234321 is a Palindrome
	
	 3468429
	Before reverse : 3468429
	After reverse : 9248643
	The number : 3468429 is not a Palindrome
	 * */
}
