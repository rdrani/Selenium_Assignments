package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Email
		9	Enter Email
		10	Click find leads button
		11	Capture name of First Resulting lead
		12	Click First Resulting lead
		13	Click Duplicate Lead
		14	Verify the title as 'Duplicate Lead'
		15	Click Create Lead
		16	Confirm the duplicated lead name is same as captured name
		17	Close the browser (Do not log out)
		*/
		ChromeDriver driver = new ChromeDriver();
		login(driver);
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("test1234@testleaf.com");
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
		if(leadName.equals(duplicateName))
			System.out.println("Names are same");
		else
			System.out.println("Names are not same");
		driver.close();
		

	}
	public static void login(ChromeDriver driver) {
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
	}

}
