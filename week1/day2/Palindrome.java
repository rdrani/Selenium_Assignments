package assignments.week1.day2;

public class Palindrome {

	public static void main(String[] args) {

		// Build a logic to find the given string is palindrome or not

		/*
		 * Pseudo Code a) Declare A String value as"madam" b) Declare another String rev
		 * value as "" c) Iterate over the String in reverse order d) Add the char into
		 * rev e) Compare the original String with the reversed String, if it is same
		 * then print palinDrome
		 * 
		 * Hint: Use .equals or .equalsIgnoreCase when you compare a String
		 */
		String str = "madam";
		String rev = "";
		char ch[] = str.toCharArray();
		for (int i = ch.length - 1; i >= 0; i--) {
			rev = rev + ch[i];
		}
		if (str.equalsIgnoreCase(rev)) {
			System.out.println("The string '" + str + "' is a palindrome");
		} else {

			System.out.println("The string '" + str + "' is not a palindrome");
		}

	}

}
