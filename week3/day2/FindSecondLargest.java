package assignments.week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
		// Here is the input
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		//       output= 7;

		/*
		 * Pseudo Code: 
		 * a) Create a empty Set Using TreeSet
		 * b) Declare for loop iterator from 0 to data.length and add into Set 
		 * c) converted Set into List
		 * d) Print the second last element from List
		 * 
		 * 
		 */
		Set<Integer> nums = new TreeSet<>();
		for (int intNum : data) {
			nums.add(intNum);
		}
		List<Integer> numList = new ArrayList<>(nums);
		System.out.println(numList.get(numList.size()-2));

	}

}
