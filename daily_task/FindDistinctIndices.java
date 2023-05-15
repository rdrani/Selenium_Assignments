package assignments.daily_task;

public class FindDistinctIndices {

	public static void main(String[] args) {
		/*
		 * Given an integer array nums and an integer k, return true if there are two
		 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
		 * - j) <= k.
		 */
		int[] nums = {1,2,3,1}; int k = 3;
//		int[] nums = {1,0,1,1}; int k = 1; 
//		int[] nums = {1,2,3,1,2,3}; int k = 2;
		boolean output = false;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if((nums[i] == nums[j]) && (Math.abs(i-j)<=k))
				{
					output = true;
					break;
				}
			}
		}
		System.out.println(output);

	}

}
