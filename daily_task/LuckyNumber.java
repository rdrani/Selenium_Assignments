package assignments.daily_task;

import java.util.Arrays;

public class LuckyNumber {
	public static void main(String args[]) {
//		int[] arr = { 2, 2, 3, 4 };
//		int[] arr = { 1, 2, 2, 3, 3, 3 };
//		int[] arr = { 2, 2, 2, 3, 3 };
		int[] arr = { 1, 3, 4, 4, 2, 4, 2, 1, 3, 4, 4 };
		int lucky = -1;
		int count = 1;
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			if (i != 0 && arr[i] == arr[i - 1]) {
				count++;
			} else {
				if (arr[i] == count) {
					lucky = count;
					break;
				} else
					count = 1;
			}
		}
		System.out.println(lucky);
	}
}