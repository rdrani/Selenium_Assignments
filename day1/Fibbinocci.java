package assignments.day1;

public class Fibbinocci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0, num2=1, sum=0;
		System.out.println("The Fibbonocci series is: \n" + num1 +"\n"+num2);
		for(int i=2; i<11; i++) {
			sum = num1+num2;
			System.out.println(sum);
			num1 = num2;
			num2 = sum;
		}
	}
}
