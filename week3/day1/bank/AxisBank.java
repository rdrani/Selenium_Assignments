package assignments.week3.day1.bank;

public class AxisBank extends BankInfo{

	public static void main(String[] args) {
		AxisBank ab = new AxisBank();
		ab.deposit();
		ab.fixed();
		ab.saving();
	}
	@Override
	public void deposit() {
		System.out.println("AxisBank -> deposit");
	}

}
