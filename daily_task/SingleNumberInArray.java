package assignments.daily_task;

import java.util.Arrays;
public class SingleNumberInArray {
    public static void main(String args[]) {
      int[] nums = {4,1,2,1,2};
      //int[] nums = {2,2,1};
      //int[] nums = {1};
      Arrays.sort(nums);
      for(int i = 0; i < nums.length; i++){
          if((i<nums.length-1)&&(nums[i] == nums[i+1]))
          {
              i++;
          }else
          {
              System.out.println(nums[i]);
              break;
          }
      }
    }
}	