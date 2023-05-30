package assignments.week5.day1.servicenow.incident;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.sukgu.Shadow;

public class IncidentBase {
	public ChromeDriver driver;
	public Shadow shadow;
	public static String strIncidentId = "INC0010044";

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		1. Launch ServiceNow application
		driver.get("https://dev148688.service-now.com");

//		2. Login with valid credentials username as admin and password 
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Welcome@1");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(3000);
		
//		3. Enter Incident in filter navigator and press enter"
		shadow = new Shadow(driver);
		Thread.sleep(3000);
		shadow.findElementByXPath("//div[text()='All']").click();
		Thread.sleep(1000);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Incident");
		Thread.sleep(1000);

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		driver.switchTo().defaultContent();
		shadow.findElementByXPath("//img[@class='now-avatar-img']").click();
		Thread.sleep(1000);
		shadow.findElementByXPath("//*[text()='Log out']").click();
		driver.close();
	}

}
