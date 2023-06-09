package assignments.week6.day2.leaftaps;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{

	@Test(dataProvider = "fetchData")
	public void runDuplicateLead(String ph) throws InterruptedException {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(ph);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String leadId = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td[1]//a[@class='linktext'])[1]")).getText();
		System.out.println(leadId);
		String leadName = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td[3]//a[@class='linktext'])[1]")).getText();
		System.out.println(leadName);
		driver.findElement(By.linkText(leadId)).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.name("submitButton")).click();
		String duplicateName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		Assert.assertEquals(leadName, duplicateName);

	}
	
	@BeforeTest
	public void setValues() {
		excelFileName = "DuplicateLead";
	}

}
