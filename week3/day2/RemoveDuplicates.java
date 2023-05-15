package assignments.week3.day2;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
//		Declare a String as "PayPal India"
//		Convert it into a character array
//		Declare a Set as charSet for Character
//		Declare a Set as dupCharSet for duplicate Character
//		Iterate character array and add it into charSet
//		if the character is already in the charSet then, add it to the dupCharSet
//		Check the dupCharSet elements and remove those in the charSet
//		Iterate using charSet
//		Check the iterator variable isn't equals to an empty space
//		print it
		String s = "PayPal India";
		char[] chArr = s.toLowerCase().toCharArray();
		Set<Character> charSet = new LinkedHashSet<>();
		Set<Character> dupCharSet = new LinkedHashSet<>();
		for (int i = 0; i < chArr.length; i++) {
			if(!charSet.add(chArr[i])) {
				dupCharSet.add(chArr[i]);
			}
		}
		charSet.removeAll(dupCharSet);
		for (Iterator<Character> itr = charSet.iterator(); itr.hasNext();) {
			char ch = itr.next();
			if(ch!=' ')
				System.out.print(ch);
		}
		
	}

}
