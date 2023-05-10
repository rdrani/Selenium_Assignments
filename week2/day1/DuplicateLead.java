package assignments.week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateLead {

	public static void main(String[] args) {
		/*                  
		  1. Launch URL  http://leaftaps.co/opentaps/control/login
		  2. Enter UserName and Password Using Id Locator
		  3. Click on Login Button using Class Locator
		  4. Click on CRM/SFA Link
		  5. Click on Leads Button
		  6. Click on Create Lead 
		  7. Enter CompanyName Field Using id Locator
		  8. Enter FirstName Field Using id Locator
		  9. Enter LastName Field Using id Locator
		  10. Enter FirstName(Local) Field Using id Locator
		  11. Enter Department Field Using any Locator of Your Choice
		  12. Enter Description Field Using any Locator of your choice 
		  13. Enter your email in the E-mail address Field using the locator of your choice
		  14. Select State/Province as NewYork Using Visible Text
		  15. Click on Create Button
          16. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
          17. Click on Duplicate button
          18. Clear the CompanyName Field using .clear() And Enter new CompanyName
          19.Clear the FirstName Field using .clear() And Enter new FirstName
          20.Click on Create Lead Button
          21. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
		*/		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Test123");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("efg");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("123");
		driver.findElement(By.name("departmentName")).sendKeys("Testing");
		driver.findElement(By.name("description")).sendKeys("Creating new Lead");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abcd@testleaf.com");
		Select sel = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		sel.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		
		System.out.println(driver.getTitle());

		driver.findElement(By.partialLinkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Google");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("NewTest123");
		driver.findElement(By.name("submitButton")).click();
		System.out.println(driver.getTitle());
	}

}
