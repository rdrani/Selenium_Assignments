package assignments.daily_task;

public class FindSquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10000;
		for(int i = 1; i <= n; i++)
		{
			if(i*i > n) 
			{
//			to find the largest number whose square is less than or equal to the given number
				System.out.println("The square root of "+ n +" is "+ (i-1));
				break;
			}
		}

	}

}
