package assignments.week3.day2;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		/*
		 * Problem
		 * 
		 * a) Take your name as input
		 * b) Print all unique characters only (any order)
		 * 
		 * Input:  babu
		 * Output: a u 
		 * 
		 */

		/*
		 * Psuedocode
		 * 
		 * a) Convert String to Character array
		 * b) Create a new Set -> HashSet
		 * c) Add each character to the Set and if it is already there, remove it
		 * d) Finally, print the set
		 * 
		 */
		String name = "Rani Ramanamurthy";
		char[] nameArr = name.toLowerCase().toCharArray();
		Set<Character> nameSet = new HashSet<>();
		Set<Character> duplicates = new HashSet<>();
		for (int i = 0; i < nameArr.length; i++) {
			if(nameArr[i]!=' ') {
				if(!nameSet.add(nameArr[i]))
					duplicates.add(nameArr[i]);
				}
		}
		nameSet.removeAll(duplicates);
		System.out.println(nameSet);
	}

}
