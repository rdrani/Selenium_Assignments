package assignments.week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {

		/*
		 * Pseudo code 

		 * a) Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";
		 *
		 *Output= We learn java basics as part of sessions in week1
		 *
		 * Psuedocode
		 *
		 * b) Split the String based on white spaces and save as String Array ,Then iterate the Array	  
		 * c) Create a empty Set 
		 * d) Iterate the String array
	                 d.1) add each word into Set
		 * e) Print the Set values which is having unique words
		 */
		String text = "We learn java basics as part of java sessions in java week1";
		String[] strText = text.split(" ");
		Set<String> strSet = new LinkedHashSet<>();
		String output = "";
		for (int i = 0; i < strText.length; i++) {
			if(strSet.add(strText[i]))
				output+=" "+strText[i];
		}
		output = output.trim();
		System.out.println(output);
	}

}
