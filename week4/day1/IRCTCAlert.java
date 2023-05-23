package assignments.week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTCAlert {

	public static void main(String[] args) throws InterruptedException {
		
//		a)Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
//		b)Load the url https://www.irctc.co.in/nget/train-search
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Thread.sleep(1000);
		
//		c)Enter MS in ‘From’ textbox
		driver.findElement(By.xpath("//p-autocomplete[@id='origin']//input")).sendKeys("MS");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p-autocomplete[@id='origin']//input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
//		d)Enter Cape in ‘To’ textbox
		driver.findElement(By.xpath("//p-autocomplete[@id='destination']//input")).sendKeys("Cape");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p-autocomplete[@id='destination']//input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
//		e)Click search button 
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(500);
		
//		f)Click refresh button
		driver.findElement(By.xpath("//div[text()=' Refresh ']")).click();
		Thread.sleep(500);
		
//		g)Click WL and Click BookNow button
		driver.findElement(By.xpath("//strong[contains(text(),'WL')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()=' Book Now ']")).click();
		Thread.sleep(500);
		
//		e)Click No button in the alert
		driver.findElement(By.xpath("//span[text()='No']")).click();
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
