package assignments.daily_task;

public class HappyNumber {

	public static void main(String[] args) {
//		int n = 19;
		int n = 2;
		int num = n;
		int tmp = 0;
		int sum = 0;
		while(true) {
			sum = 0;
			while(n > 0) {
				tmp = n%10;
				sum = sum + (tmp * tmp);
				n=n/10;
			}
			n = sum;
			if(sum==1) {
				System.out.println(num+" is a Happy Number");
				break;
			}
			if(sum==4) {
				System.out.println(num+" is not a Happy Number");
				break;
			}
		}

	}

}
