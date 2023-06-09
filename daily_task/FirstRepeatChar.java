package assignments.daily_task;

import java.util.Map;
import java.util.TreeMap;

public class FirstRepeatChar {
	public static void main(String args[]) {
		String s = "abccbaacz";
//    	String s = "abcdd";

		// Method 1
		Map<Integer, Character> sMap = new TreeMap<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					sMap.put(j, s.charAt(i));
					break;
				}
			}
		}
		if (!sMap.isEmpty()) {
			Map.Entry<Integer, Character> firstEntry = sMap.entrySet().iterator().next();
			System.out.println("First repeating letter in the given string is: " + firstEntry.getValue());
		} else {
			System.out.println("No repeating letters present in the given string");
		}

		// Method 2
		int index = s.length();
		char result = 0;
		int tmp = 0;
		for (int i = 0; i < s.length(); i++) {
			tmp = s.indexOf(s.charAt(i), i + 1);
			if (0 <= tmp && tmp < index) {
				index = tmp;
				result = s.charAt(i);
			}
		}
		if (result != 0)
			System.out.println("First repeating letter in the given string is: " + result);
		else
			System.out.println("No repeating letters present in given string");
	}
}
