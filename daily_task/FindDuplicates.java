import java.util.Arrays;
  
public class FindDuplicates {
    public static void main(String args[]) {
        //int[] nums = {1, 2, 3, 1};
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        //int[] nums = {1,2,3,4};
        boolean isDup = false;
        Arrays.sort(nums);
        for(int i=1; i < nums.length; i++){
            if(nums[i-1] == nums[i])
            {
                isDup = true;
                break;
            }
        }
      System.out.println(isDup);
    }
}
