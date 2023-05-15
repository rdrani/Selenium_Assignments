package assignments.week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		
		/*
		 * Problem 
		 * 
		 * There will be running number between 1 to 10
		 * One of the unique number will be missing
		 * Find the missing number
		 * 
		 * 
		 */
		
		/*
		 * Psuedocode
		 * 
		 * a) Remove the duplicates using Set
		 * b) Make sure the set is in the ascending order
		 * c) Iterate from the starting number and verify the next number is + 1
		 * d) If did not match, that is the number
		 * 
		 */
		int num[] = {2,5,5,6,8,5,1,2,6,5,3,4};
		Set<Integer> numSet = new TreeSet<>();
		for (int i : num) {
			numSet.add(i);
		}
		List<Integer> numList = new ArrayList<>(numSet);
		for (int i = 1; i < numList.size(); i++) {
			if((numList.get(i-1)!=(numList.get(i)-1)))
				System.out.println("The missing number is:"+(numList.get(i-1)+1));
		}
		
	}

}
