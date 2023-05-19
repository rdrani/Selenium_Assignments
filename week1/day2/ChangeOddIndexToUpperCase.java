package assignments.week1.day2;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pseudo Code
		 * 
		 * Declare String Input as Follow
		 * String test = "changeme";
		 * a) Convert the String to character array
		 * b) Traverse through each character (using loop)
		 * c)find the odd index within the loop (use mod operator)
		 * d)within the loop, change the character to uppercase, if the index is odd
		 * else don't change
		 * 
		 */

//		Method 1
		String test = "changeme";
		String testUpper = test.toUpperCase();
		String oddIndexString = "";
		char[] ch = test.toCharArray();
		char[] chUpperCase = testUpper.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (i % 2 != 0) {
				ch[i] = chUpperCase[i];
			}
			oddIndexString = oddIndexString + ch[i];
		}
		System.out.println(oddIndexString);

//		Method 2
		String test1 = "changeme";
		String oddIndexStr = "";
		char[] ch1 = test1.toCharArray();
		for (int i = 0; i < ch1.length; i++) {
			if (i % 2 != 0) {
				oddIndexStr = oddIndexStr + ("" + ch1[i]).toUpperCase();
			} else {
				oddIndexStr = oddIndexStr + ch1[i];
			}
		}
		System.out.println(oddIndexStr);

	}

}
