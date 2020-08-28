package myorg.coding.programs;

import java.util.Scanner;

public class FindNumberOfWords {

	public int count(String sentence) {

		//Verify if the word is empty or null then return the count as 0 
		if (sentence == null || sentence.isEmpty()) 
		{ 
			return 0; 
		}
		//Verify if word is not empty or null perform the below counting operation
		else {
			int wordCount = 0; 
			boolean isWord = false; 
			int endOfLine = sentence.length() - 1; 
			char[] charArray = sentence.toCharArray();

			for (int i = 0; i < charArray.length; i++) 
			{
				// case 1 : if the char is a letter and the char is not end of line, then set isWord = true. 
				if (Character.isLetter(charArray[i]) && i != endOfLine)
				{
					isWord = true; 	
				}
				/*case 2 : if char isn't a letter (means space or full stop are encountered - non letters) 
				  and there have been letters before means isWord  was true in previous iteration, 
				  counter-"wordCount" goes up 
				  isWord flag is reset to false to verify for next coming word.
				 */
				else if ((!Character.isLetter(charArray[i])) && isWord) 
				{ 
					wordCount++; 
					isWord = false;
				}
				//case 3 : last word of String; if it doesn't end with a non letter, it wouldn't count without this.
				else if (Character.isLetter(charArray[i]) && i == endOfLine) 
				{ 
					wordCount++; 
				}

			}//end of for loop
			System.out.println(sentence+"\n word count : "+wordCount);
			System.out.println("***************");
			return wordCount;
		}
	}
	
	public static void main(String args[]) {
		
		FindNumberOfWords fn = new FindNumberOfWords();
		Scanner sn = new Scanner(System.in);
		String str = sn.nextLine();
		sn.close();
		String sentence =" India is my country. I am proud of it! What a beautiful place$ "; 
		fn.count(str.trim());
		fn.count(sentence.trim());
		fn.count(" !&&&&$$$. ");
		fn.count(" . ");
		
		/*
		  	Expected Output :
			I want to dance

			I want to dance
 			word count : 4
		 	***************
			India is my country. I am proud of it! What a beautiful place$
 			word count : 13
		 	***************
 			!&&&&$$$. 
 			word count : 0
		 	***************
 			. 
 			word count : 0
		 	***************

		 * */
		
	}


}
