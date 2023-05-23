package assignments.week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		
//		2. Go to Mens Fashion
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText("Men's Fashion"))).perform();
		
//		3. Go to Sports Shoes
		driver.findElement(By.linkText("Sports Shoes")).click();
		
//		4. Get the count of the sports shoes
		String itemCount = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();
		System.out.println("Item count: "+itemCount.replaceAll("[^0-9]", ""));
		
//		5. Click Training shoes (Training shoes returning very few results so using Running Shoes)
		driver.findElement(By.xpath("//div[text()='Running Shoes']")).click();
		Thread.sleep(1000);
		
//		6. Sort by Low to High
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		Thread.sleep(2000);
		
//		7. Check if the items displayed are sorted correctly
		List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		boolean isSorted = checkSorted(priceList);
		if(isSorted)
			System.out.println("Items sorted correctly");
		else
			System.out.println("Items sorted incorrectly");
		
//		8.Select the price range (900-1200)
		WebElement priceFrom = driver.findElement(By.name("fromVal"));
		driver.executeScript("arguments[0].setAttribute('value', '900')", priceFrom);
		WebElement priceTo = driver.findElement(By.name("toVal"));
		driver.executeScript("arguments[0].setAttribute('value', '1200')", priceTo);
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(3000);
		
//		9.Filter with color Navy
		driver.findElement(By.xpath("//button[@data-filtername='Color_s']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(3000);
		
//		10 verify the all applied filters 
		String filters = driver.findElement(By.className("filters")).getText();
		System.out.println("Filters applied: " +filters);
		Thread.sleep(3000);
		
//		11. Mouse Hover on first resulting Training shoes
		WebElement firstElement = driver.findElement(By.xpath("//*[@class='product-title']"));
		builder.scrollToElement(firstElement).perform();
		builder.moveToElement(firstElement).perform();
		Thread.sleep(1000);
		
//		12. click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		Thread.sleep(1000);
		
//		13. Print the cost and the discount percentage
		System.out.println("Price: "+driver.findElement(By.className("payBlkBig")).getText());
		System.out.println("Discount %: "+driver.findElement(By.xpath("//*[@class='percent-desc ']")).getText());
		Thread.sleep(3000);
		
//		14. Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/snapdeal_runningshoe.png");
		FileUtils.copyFile(source, destination);
		Thread.sleep(5000);
		
//		15. Close the current window
		driver.findElement(By.xpath("//div[contains(@class,'close')]")).click();
		Thread.sleep(1000);
		
//		16. Close the main window
		driver.close();
		
	}
	static boolean checkSorted(List<WebElement> priceList) {
		double prev =0, curr = 0;
		String price ="";
		prev = Double.parseDouble(priceList.get(0).getText().replaceAll("[^0-9]", ""));
		boolean isSorted = true;
		for (int i = 1; i < priceList.size(); i++) {
			price = priceList.get(i).getText().replaceAll("[^0-9]", "");
			curr = Double.parseDouble(price);
			System.out.print(curr +", ");
			if(prev > curr)
				isSorted = false;
			prev = curr;
		}
		System.out.println("");
		return isSorted;
	}

}
