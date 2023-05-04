package assignments.daily_task;

public class PalindromePhrase {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
//		String s = "race a car";
//		String s = " ";
		Boolean isPalindrome = false;
		String rev = "";
		s = s.replaceAll("[\\W_]", "");
		char[] ch = s.toCharArray();
		for (int i = ch.length - 1; i >= 0; i--) {
			rev = rev + ch[i];
		}
		isPalindrome = s.equalsIgnoreCase(rev);
//		Output is "true" if the string is a palindrome and "false" if it is not
		System.out.println(isPalindrome);
	}

}
