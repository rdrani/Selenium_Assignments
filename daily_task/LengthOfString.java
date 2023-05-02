package assignments.daily_task;

/**
 * @author Rani
 *
 * Java class to find the length of the last word in the given String
 * 
 */
public class LengthOfString {

	public static void main(String[] args) {
//		String s= "Hello World";
		String s= " fly me  to  the moon ";
//		String s= "luffy is still joyboy";
		String[] strArray = s.split(" ");
		int lenOfArray = strArray.length;
		int lenOfLastWord = strArray[lenOfArray - 1].length();
		System.out.println("The last word is \""+strArray[lenOfArray-1]+"\" with the length "+lenOfLastWord);

	}

}
