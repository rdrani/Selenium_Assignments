package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRadio {

	public static void main(String[] args) {		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		
//		Your most favorite browser
		driver.findElement(By.xpath("//table[@id='j_idt87:console1']//label[text()='Chrome'][1]/preceding::span[1]")).click();
		System.out.println("Favorite browser selected");
		
//		UnSelectable
		driver.findElement(By.xpath("//label[text()='Bengaluru']/preceding::span[1]")).click();
		if(driver.findElement(By.xpath("//label[text()='Bengaluru']/preceding::input[1]")).isSelected())
			System.out.println("Bengaluru selected");
		driver.findElement(By.xpath("//label[text()='Bengaluru']/preceding::span[1]")).click();
		if(!driver.findElement(By.xpath("//label[text()='Bengaluru']/preceding::input[1]")).isSelected())
			System.out.println("Bengaluru unselected");
		
//		Find the default select radio button
		System.out.println("Default selected radio button is: "+
				driver.findElement(By.xpath("//table[@id='j_idt87:console2']//input[(@type='radio')and(@checked='checked')]/following::label[1]")).getText());
		
//		Select the age group (only if not selected)
		if(!(driver.findElement(By.xpath("//label[text()='21-40 Years']/preceding::input[1]")).isSelected()))
			driver.findElement(By.xpath("//label[text()='21-40 Years']/preceding::span[1]")).click();
		else
			System.out.println("Correct age group is selected");
		
		
	}

}
