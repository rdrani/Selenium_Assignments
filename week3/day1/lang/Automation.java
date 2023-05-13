package assignments.week3.day1.lang;

public class Automation extends MultipleLangauge{

	public static void main(String[] args) {
		Automation auto = new Automation();
		auto.java();
		auto.selenium();
		auto.ruby();
		auto.python();
	}

	@Override
	public void java() {
		System.out.println("Automation -> java()");		
	}

	@Override
	public void selenium() {
		System.out.println("Automation -> selenium()");		
	}

	@Override
	public void ruby() {
		System.out.println("Automation -> ruby()");		
	}

}
