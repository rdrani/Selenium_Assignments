package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestInput {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		driver.findElement(By.id("j_idt88:name")).clear();
		driver.findElement(By.id("j_idt88:name")).sendKeys("Rani R");
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys(", India");
		System.out.println(driver.findElement(By.id("j_idt88:j_idt93")).isEnabled());
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		System.out.println(driver.findElement(By.id("j_idt88:j_idt97")).getText());
		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("test@google.com\t");
		if(!driver.findElement(By.id("j_idt88:j_idt99")).isSelected())
			System.out.println("Control moved to next input field");
		driver.findElement(By.id("j_idt88:j_idt101")).sendKeys("Trying to learn Selenium");

		driver.findElement(By.id("j_idt106:thisform:age")).submit();
		System.out.println(driver.findElement(By.linkText("Age is mandatory")).isDisplayed());
		Point location = driver.findElement(By.id("j_idt106:j_idt113")).getLocation();
		driver.findElement(By.id("j_idt106:float-input")).click();

		Point location2 = driver.findElement(By.id("j_idt106:j_idt113")).getLocation();
		System.out.println(location+", "+location2);

		driver.findElement(By.id("j_idt106:auto-complete_input")).sendKeys("Rani");
		Select sel = new Select(driver.findElement(By.xpath("//span[@id='j_idt106:auto-complete_panel']//ul")));
		sel.selectByIndex(2);
		driver.findElement(By.id("j_idt106:j_idt116_input")).sendKeys("01/01/2001");
		

		String month = driver.findElement(By.className("ui-datepicker-month")).getText();
		String year = driver.findElement(By.className("ui-datepicker-year")).getText();
		String day = driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//a[@class=' ui-state-default ui-state-active']")).getText();
		System.out.println(day+" "+month+" "+year);
		
		driver.findElement(By.id("j_idt106:j_idt118_input")).sendKeys("1008");
		driver.findElement(By.className("ui-icon ui-c ui-icon-triangle-1-s")).click();
		System.out.println(driver.findElement(By.id("j_idt106:j_idt118_input")).getText());
		
		driver.findElement(By.id("j_idt106:slider")).sendKeys("80");
		System.out.println(driver.findElement(By.xpath("//div[@id='j_idt106:j_idt120']//span")).getLocation());
		
		
		
		
	}

}
