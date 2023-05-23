package assignments.daily_task;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrencesInArray {

	public static void main(String[] args) {
		
		int[] arr = {1,2,2,1,1,3};
//		int[] arr = {1,2};
//		int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
		boolean isUnique = false;
		Map<Integer,Integer> numMap = new HashMap<>();
		for (int num : arr) {
			numMap.put(num, numMap.getOrDefault(num, 0)+1);
		}
		Set<Integer> numSet = new HashSet<>(numMap.values());
		if(numSet.size()==numMap.size())
			isUnique = true;
		
		System.out.println(isUnique);
	}

}
