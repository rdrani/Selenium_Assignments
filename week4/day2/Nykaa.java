package assignments.week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		
//		2) Mouseover on Brands and Search L'Oreal Paris
		Actions builder = new Actions(driver);
		WebElement brands = driver.findElement(By.linkText("Brands"));
		builder.moveToElement(brands).perform();
		String brand = "L'Oreal Paris";
		driver.findElement(By.id("brandSearchBox")).sendKeys(brand,Keys.ENTER);
		
//		3) Click L'Oreal Paris
		driver.findElement(By.linkText(brand)).click();
		
//		4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		if(title.contains(brand))
			System.out.println("Page title contains brand name '"+brand+"'");
		else
			System.out.println("Page title does not contain brand name '"+brand+"'");
		System.out.println("Title: "+title);
		
//		5) Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
		Thread.sleep(700);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(1000);
		
//		6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(700);
		driver.findElement(By.xpath("//li//span[text()='Hair Care']")).click();
		Thread.sleep(700);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(1000);

//		7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(1000);
		
//		8) Check whether the Filter is applied with Shampoo
		Thread.sleep(700);
		String result = driver.findElement(By.className("css-xrzmfa")).getText();
		System.out.println(result);
		result = result.toLowerCase();
		if((result.contains("color")||result.contains("colour"))&&result.contains("protect"))
			System.out.println("Filters applied correctly");
		else
			System.out.println("Filters not applied correctly");
		
//		9) Click on L'Oreal Paris Colour Protect Shampoo
		Thread.sleep(700);
		driver.findElement(By.xpath("//div[@class='css-d5z3ro']//a")).click();
		
//		10) GO to the new window and select size as 175ml
		Thread.sleep(1000);
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		Thread.sleep(500);
		
//		11) Print the MRP of the product
		System.out.println(driver.findElement(By.className("css-1jczs19")).getText().replaceAll("[^0-9.]", ""));
		
//		12) Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		Thread.sleep(500);
		
//		13) Go to Shopping Bag 
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		Thread.sleep(500);
		
//		14) Print the Grand Total amount
		driver.switchTo().frame(0);
		String strGrandTotal = driver.findElement(By.xpath("//span[contains(@class,'css-1um1mkq')]")).getText();
		strGrandTotal = strGrandTotal.replaceAll("[^0-9.]", "");
		System.out.println("Grand total: "+strGrandTotal);
		
//		15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		Thread.sleep(2000);
		
//		16) Click on Continue as Guest	
//		(Option not displayed outside India, so getting grand total from main window to compare)
		driver.switchTo().window(windowHandles.get(0));
		
//		17) Check if this grand total is the same in step 14
		driver.findElement(By.xpath("//*[@class='css-aesrxy']")).click();
		driver.switchTo().frame(0);
		String strTotalFromHomePage = driver.findElement(By.xpath("//span[contains(@class,'css-1um1mkq')]")).getText();
		strTotalFromHomePage = strTotalFromHomePage.replaceAll("[^0-9.]", "");
		System.out.println("Grand total from home page: "+strTotalFromHomePage);
		if(strTotalFromHomePage.equalsIgnoreCase(strGrandTotal))
			System.out.println("The grand total on both pages are same");
		else
			System.out.println("The grand total on both pages are not the same");
		
//		18) Close all windows
		driver.quit();
		
	}

}
