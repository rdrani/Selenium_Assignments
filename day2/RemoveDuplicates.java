package assignments.day2;

public class RemoveDuplicates {

	public static void main(String[] args) {
		/*
		 * Pseudo code
		 * 
		 * a) Use the declared String text as input 
		 * String text = "We learn java basics as part of java sessions in java week1"; 
		 * b) Initialize an integer variable as count 
		 * c) Split the String into array and iterate over it 
		 * d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. 
		 * f) if the count > 1 then replace the word as ""
		 * g) Displaying the String without duplicate words
		 */

		String text = "We learn java basics as part of java sessions in java week1";
		String[] textArray = text.split(" ");
		int count = 0;
		for (int i = 0; i < textArray.length; i++) {
			count = 0;
			for (int j = i+1; j < textArray.length; j++) {
				if (textArray[i].equals(textArray[j])) {
					count++;
					if (count > 0) {
						textArray[j] = "";
					}
				}
			}
			System.out.print(textArray[i]+" ");
		}
	}

}
