package assignments.week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonOneplus {

	public static void main(String[] args) throws IOException, InterruptedException{

//		1.Load the URL https://www.amazon.in/
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
//		2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 9 pro"+Keys.ENTER);
		
//		3.Get the price of the first product
		String priceFromResults = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		priceFromResults = priceFromResults.replaceAll("[^0-9.]", "");
		float fpriceResults = Float.parseFloat(priceFromResults);
		System.out.println("Price of the first product from results: " + fpriceResults);
		
//		4. Print the number of customer ratings for the first displayed product
		System.out.println("No of ratings: " + driver
				.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText());
		
//		5. Click the first text link of the first image
		driver.findElement(By.xpath("//h2/a")).click();
		
//		6. Take a screen shot of the product displayed
		List<String> handles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));
		Thread.sleep(3000);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/amazon_oneplus.png");
		FileUtils.copyFile(source, destination);
		
//		7. Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		
//		8. Get the cart subtotal and verify if it is correct.
		String priceFromCart = driver.findElement(By.xpath("//*[@id='attach-accessory-cart-subtotal']")).getText();
		priceFromCart = priceFromCart.replaceAll("[^0-9.]", "");
		float fpriceCart = Float.parseFloat(priceFromResults);
		System.out.println("Price from cart: "+fpriceCart );
		if(fpriceResults == fpriceCart)
			System.out.println("Cart subtotal is correct");
		else
			System.out.println("Cart subtotal is incorrect");
		
//		9.close the browser
		driver.quit();
	}

}
