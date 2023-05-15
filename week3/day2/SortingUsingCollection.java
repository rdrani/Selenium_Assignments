package assignments.week3.day2;

import java.util.Arrays;

public class SortingUsingCollection {

	public static void main(String[] args) {
		
		// Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		
		// get the length of the array		
		// sort the array			
		// Iterate it in the reverse order
		// print the array
		// Required Output: Wipro, HCL , CTS, Aspire Systems
		
		String[] strComp = {"HCL", "Wipro",  "Aspire Systems", "CTS"};
		Arrays.sort(strComp);
		for (int i = strComp.length-1; i >=0 ; i--) {
			System.out.println(strComp[i]);
		}
	}

}
