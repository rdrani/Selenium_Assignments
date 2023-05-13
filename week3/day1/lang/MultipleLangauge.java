package assignments.week3.day1.lang;

public abstract class MultipleLangauge implements Language, TestTool{
	public void python() {
		System.out.println("MultipleLangauge -> python()");
	}
	public abstract void ruby();
}
