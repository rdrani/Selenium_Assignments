package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFacebookUser {

	public static void main(String[] args) throws InterruptedException {
		// Step 1: Download and set the path 
		// Step 2: Launch the chromebrowser
		// Step 3: Load the URL https://en-gb.facebook.com/
		// Step 4: Maximise the window
		// Step 5: Add implicit wait
		// Step 6: Click on Create New Account button
		// Step 7: Enter the first name
		// Step 8: Enter the last name
		// Step 9: Enter the mobile number
		// Step 10: Enterthe password
		// Step 11: Handle all the three drop downs
		// Step 12: Select the radio button "Female"  ( A normal click will do for this step) 
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
//		driver.findElement(By.partialLinkText("Create new account")).click();
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(3000);
//		driver.findElement(By.name("firstname")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
//		driver.findElement(By.name("lastname")).sendKeys("User");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("User");
//		driver.findElement(By.name("reg_email__")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("987654321");
//		driver.findElement(By.id("password_step_input")).sendKeys("Hell0@123");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Hell0@123");
//		Select selDay = new Select(driver.findElement(By.name("birthday_day")));
		Select selDay = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		selDay.selectByVisibleText("1");
//		Select selMonth = new Select(driver.findElement(By.name("birthday_month")));
		Select selMonth = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		selMonth.selectByIndex(0);
//		Select selYear = new Select(driver.findElement(By.name("birthday_year")));
		Select selYear = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		selYear.selectByValue("2001");
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
	}

}
