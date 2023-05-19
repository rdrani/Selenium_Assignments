package assignments.week1.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {

		// Build a logic to reverse the even position words (output: I ma a erawtfos tester)

		/*
		 * Pseudo Code:
		 * 
		 * Declare the input as Follow String test = "I am a software tester"; 
		 * a) split the words and have it in an array 
		 * b) Traverse through each word (using loop)
		 * c) find the odd index within the loop (use mod operator) 
		 * d)split the words and have it in an array 
		 * e)print the even position words in reverse order using another loop (nested loop) 
		 * f) Convert words to character array if the position is even else print
		 * the word as it is(concatenate space at the end).
		 * 
		 */
		String test = "I am a software tester"; 
		String[] strArray = test.split(" ");
		String temp = "";
		for(int i = 0; i < strArray.length; i++) {
			if(i%2 != 0) {
				char[] ch = strArray[i].toCharArray();
				for(int j = ch.length - 1 ; j >= 0; j-- ) {
					temp = temp + ch[j];
				}
			}else {
				temp = strArray[i];
			}
			System.out.print(temp + " ");
			temp = "";
		}
		

	}

}
