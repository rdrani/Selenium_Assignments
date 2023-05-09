package assignments.daily_task;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {
//		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int[] nums = { 3,2,3 };
		Arrays.sort(nums);
		int n = 0;
		int temp = 1, count = 1;
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i] == nums[i + 1])
				count++;
			else {
				if (temp < count) {
					temp = count;
					count = 1;
					n = nums[i];
					System.out.println(n);
				}
			}

		}
		if (temp < count) {
			temp = count;
			count = 1;
			n = nums[nums.length-1];
		}
		System.out.println("Majority element is: "+n);

	}

}
