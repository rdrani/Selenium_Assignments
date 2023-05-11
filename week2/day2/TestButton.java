package assignments.week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestButton {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
//		Click and Confirm title
		driver.findElement(By.id("j_idt88:j_idt90")).click();
		System.out.println("Title: "+driver.getTitle());
		driver.navigate().back();

//		Confirm if the button is disabled
		if(!driver.findElement(By.id("j_idt88:j_idt92")).isEnabled())
			System.out.println("Button is disabled");
		
//		Find the position of the Submit button
		Point location = driver.findElement(By.id("j_idt88:j_idt94")).getLocation();
		System.out.println("Button position :"+location);
		
//		Find the Save button color
		System.out.println("Button color: "+driver.findElement(By.id("j_idt88:j_idt90")).getCssValue("background-color"));
		
//		Find the height and width of this button
		System.out.println("Button size: "+driver.findElement(By.id("j_idt88:j_idt98")).getSize());
		
//		Click Image Button and Click on any hidden button
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();
		//driver.findElement(By.xpath("//div[@class='card ui-fluid']//input[@type='hidden'][2]")).click();
		
//		How many rounded buttons are there?
		List<WebElement> rndBtnElements = driver.findElements(By.xpath("//button[contains(@class,'rounded-button')]"));
		System.out.println("Number of rounded buttons: "+rndBtnElements.size());
		rndBtnElements = null;
		
	}

}
