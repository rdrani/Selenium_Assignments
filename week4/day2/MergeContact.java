package assignments.week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * //Pseudo Code
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 2. Enter UserName and Password Using Id Locator
		 * 3. Click on Login Button using Class Locator
		 * 4. Click on CRM/SFA Link
		 * 5. Click on contacts Button
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 7. Click on Widget of From Contact
		 * 8. Click on First Resulting Contact
		 * 9. Click on Widget of To Contact
		 * 10. Click on Second Resulting Contact
		 * 11. Click on Merge button using Xpath Locator
		 * 12. Accept the Alert
		 * 13. Verify the title of the page
		 */
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a[1]")).click();
		List<String> handlesList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(handlesList.get(1));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(handlesList.get(0));
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following::a[1]")).click();
		handlesList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(handlesList.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(handlesList.get(0));
		driver.findElement(By.linkText("Merge")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
	}

}
