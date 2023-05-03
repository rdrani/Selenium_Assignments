package assignments.daily_task;

public class FindSquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10000;
		for(int i = 1; i <= n; i++)
		{
			if(i*i > n) 
			{
				System.out.println("The square root of "+ n +" is "+ (i-1));
				break;
			}
		}

	}

}
