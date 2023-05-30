package assignments.week5.day1.leaftaps;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{

	@Test
	public void runDuplicateLead() throws InterruptedException {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
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
		if(leadName.equals(duplicateName))
			System.out.println("Names are same");
		else
			System.out.println("Names are not same");
		

	}

}
