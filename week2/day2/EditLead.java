package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
		* */
		
		ChromeDriver driver = new ChromeDriver();
		login(driver);
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();
		driver.findElement(By.xpath("//div[@class='x-tab-panel']//input[@name='firstName']")).sendKeys("Hello");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String leadId = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td[1]//a[@class='linktext'])[1]")).getText();
		System.out.println(leadId);
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td[1]//a[@class='linktext'])[1]")).click();
		System.out.println(driver.getTitle());
		String exCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Google");
		driver.findElement(By.name("submitButton")).click();
		String newCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if(exCompany.equals(newCompany))
			System.out.println("Company name not updated");
		else
			System.out.println("Company name updated");
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