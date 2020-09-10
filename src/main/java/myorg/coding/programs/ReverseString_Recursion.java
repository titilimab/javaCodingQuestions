package myorg.coding.programs;

import java.util.Scanner;

/*
	Declaration :   String java.lang.String.substring(int beginIndex)
	
	public String substring(int beginIndex)
	
	Returns a string that is a substring of this string. Thesubstring begins with the character at the specified index andextends to the end of this string. 
	Examples: 
	
	"unhappy".substring(2) returns "happy"
	"Harbison".substring(3) returns "bison"
	"emptiness".substring(9) returns "" (an empty string)
	
	Parameters:beginIndex - the beginning index, inclusive.Returns:the specified substring.Throws:IndexOutOfBoundsException - if beginIndex is negative or larger than thelength of this String object.
 */
public class ReverseString_Recursion {

	public static void main(String[] args) {
		String str;
		System.out.println("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
		str = scanner.nextLine();
		scanner.close();
		String reversed = reverseString(str);
		System.out.println("The reversed string is: " + reversed);
	}

	public static String reverseString(String str)
	{
		if (str.isEmpty())
			return str;
	
		String subStringFrom1stIndex = str.substring(1);
		char charAt0thIndex = str.charAt(0);
		System.out.println("SubString from 1st index : "+subStringFrom1stIndex);
		System.out.println("character at 0th index : "+charAt0thIndex);
		
		//Calling Function Recursively
		return reverseString(subStringFrom1stIndex) + charAt0thIndex;
		
		//return reverseString(str.substring(1)) + str.charAt(0);
	}
	/* Console Output :
	  
		Enter your username: 
		April
		SubString from 1st index : pril
		character at 0th index : A
		SubString from 1st index : ril
		character at 0th index : p
		SubString from 1st index : il
		character at 0th index : r
		SubString from 1st index : l
		character at 0th index : i
		SubString from 1st index : 
		character at 0th index : l
		The reversed string is: lirpA
*/

}
