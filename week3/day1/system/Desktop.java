package assignments.week3.day1.system;

public class Desktop extends Computer{
	public void desktopSize() {
		System.out.println("Desktop size : Inside Desktop");
	}
	public static void main(String args[]) {
		Desktop dt = new Desktop();
		dt.desktopSize();
		dt.computerModel();
	}
}
