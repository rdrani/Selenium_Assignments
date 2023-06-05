package assignments.daily_task;

import java.util.*;

public class DistinctStringsInArray {
    public static void main(String args[]) {
        //String[] arr = {"d","b","c","b","c","a"}; int k = 2;
        String[] arr = {"aaa","aa","a"}; int k = 1;
        //String[] arr = {"a","b","a"}; int k = 3;
        
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : arr) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }

        String result = "";
        int count = 0;
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
                if (count == k) {
                    result = entry.getKey();
                    break;
                }
            }
        }

        System.out.println("Output: \"" + result + "\"");
    }
}
