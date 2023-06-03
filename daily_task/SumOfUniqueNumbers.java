package assignments.daily_task;

import java.util.HashSet;
import java.util.Set;

public class SumOfUniqueNumbers {
	public static void main(String args[]) {
//		int[] nums = { 1, 2, 3, 2, 4, 8, 6, 5, 4, 2, 8, 7, 2, 3, 8, 3 };
		int[] nums = { 1, 2, 3, 2 };
//		int[] nums = { 1, 1, 1, 1, 1 };
//		int[] nums = { 1, 2, 3, 4, 5 };

		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new HashSet<>();
		int sum = 0;
		for (int num : nums) {
			if (!s1.add(num)) {
				if (s2.add(num)) {
					sum -= num;
				}
			} else {
				sum += num;
			}
		}
		System.out.println(sum);
	}
}