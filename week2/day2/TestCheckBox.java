package assignments.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCheckBox {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		Basic Checkbox
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
		
//		Notification
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		System.out.println("Notification displayed: "+driver.findElement(By.className("ui-growl-title")).getText());
		
//		Choose your favorite language(s)
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		driver.findElement(By.xpath("//label[text()='Javascript']")).click();
		driver.findElement(By.xpath("//label[text()='Others']")).click();
		System.out.println("Favourite languages selected");
		
//		Tri State Checkbox
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']//div[2]")).click();
			Thread.sleep(1000);
			System.out.println("Checkbox state: "
					+ (driver.findElement(By.xpath("//p[contains(text(),'State')]"))).getText());
//			
		}
		
//		Toggle Switch
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		System.out.println("Toggle switch: "
				+ (driver.findElement(By.className("ui-growl-title"))).getText());
		
//		Verify if check box is disabled
		System.out.println("Checkbox enabled: "+driver.findElement(By.id("j_idt87:j_idt102_input")).isEnabled());

//		Select Multiple
		driver.findElement(By.xpath("//div[@id='j_idt87:multiple']/ul")).click();
		driver.findElement(By.xpath("(//label[text()='London'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Paris'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Rome'])[2]")).click();
		
	}

}
