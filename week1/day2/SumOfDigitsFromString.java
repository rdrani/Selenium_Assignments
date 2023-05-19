package assignments.week1.day2;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		/*
		 * Method 1
		 * Pseudo Code
		 * Declare a String text with the following value
			String text = "Tes12Le79af65";
		    Declare a int variable sum
			int sum = 0;
		 * a) using replaceAll(), replace all the non-digits into ""
		 * b) Now, convert the String into array
		 * c) Iterate over the array and get each character
		 * d) Using Character.getNumericValue(), Change the char into int
		 * e) Add the values to sum & print
		 * 
		 */
		String text = "Tes12Le79af65";
		int sum = 0;
		text = text.replaceAll("[^0-9.]", "");
		char[] ch = text.toCharArray();
		for(int i = 0; i < ch.length; i++) {
			sum = sum + Character.getNumericValue(ch[i]);
		}
		System.out.println(sum);
		
		/*
		 * Method 2
		 * Pseudo Code
		 * Declare a String text with the following value
			String text = "Tes12Le79af65";
		    Declare a int variable sum
			int sum = 0;
		 * a) Iterate an  array over the String
		 * b) Get each character and check if it is a number using Character.isDigit()
		 * c) Now covert char to int using Character.getNumericValue() and add it to sum
		 * d) Now Print the value
		 */
		String text1 = "Tes12Le79af65";
		int sum1 = 0;
		char[] ch1 = text1.toCharArray();
		for(int i = 0; i < ch1.length; i++) {
			if(Character.isDigit(ch1[i])) {
				sum1 = sum1 + Character.getNumericValue(ch1[i]);
			}
		}
		System.out.println(sum1);
	}

}
