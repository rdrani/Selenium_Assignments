package assignments.week2.day2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSelect {

	public static void main(String[] args) throws InterruptedException {		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		Which is your favorite UI Automation tool?
		Select sel = new Select(driver.findElement(By.className("ui-selectonemenu")));
		sel.selectByVisibleText("Selenium");
		
//		Choose your preferred country
		driver.findElement(By.id("j_idt87:country_label")).click();
		driver.findElement(By.id("j_idt87:country_2")).click();
		
//		Confirm Cities belongs to Country is loaded
		List<WebElement> listElements = driver.findElements(By.xpath("//*[@id='j_idt87:city_items']/li"));
		boolean isCityLoaded=true;
		for (Iterator<WebElement> iterator = listElements.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			if(webElement.getText()!="Select City" && (webElement.getText()!="Berlin"||webElement.getText()!="Frankfurt"||webElement.getText()!="Munich"))
			{
				System.out.println("Incorrect cites loaded");
				isCityLoaded = false;
			}
		}
		if(isCityLoaded)
			System.out.println("Cities loaded correctly");
		
//		Choose the Course
		driver.findElement(By.xpath("//div[@id='j_idt87:auto-complete']/button")).click();
		driver.findElement(By.xpath("//*[@id='j_idt87:auto-complete_panel']//li[text()='Selenium WebDriver']")).click();
		
//		Choose language randomly
		//int randomInt = (new Random()).nextInt(5)+2;
		driver.findElement(By.id("j_idt87:lang_label")).click();
		//driver.findElement(By.xpath("//ul[@id='j_idt87:lang_items']/li["+randomInt+"]")).click();
		driver.findElement(By.xpath("//ul[@id='j_idt87:lang_items']/li[2]")).click();
		/*
		 * String strLang = driver.findElement(By.id("j_idt87:lang_label")).getText();
		 * System.out.println(strLang);
		 */
		
//		Select 'Two' irrespective of the language chosen
		Thread.sleep(2000);
		driver.findElement(By.id("j_idt87:value_label")).click();	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[text()='Two']")).click();
		 
	}

}
