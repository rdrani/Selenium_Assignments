package assignments.week4.day2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundWindow {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();

//		Click and Confirm new Window Opens
		driver.findElement(By.id("j_idt88:new")).click();
		int size = driver.getWindowHandles().size();
		if (size > 1)
			System.out.println("New window opened");
		else
			System.out.println("No new windows opened");
//		Thread.sleep(2000);
		
//		Find the number of opened tabs
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		int newWindowCount = driver.getWindowHandles().size();
		if (newWindowCount > size)
			System.out.println(newWindowCount - size + " New window(s) have been opened");
//		Thread.sleep(2000);
		
		
//		Close all windows except Primary
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		int count =0;
		for (int i = 1; i < windowHandles.size(); i++) {
			driver.switchTo().window(windowHandles.get(i)).close();
			count++;
		}
		System.out.println(count + " window(s) closed");
		driver.switchTo().window(windowHandles.get(0));
//		Thread.sleep(2000);
		
		
//		Wait for 2 new tabs to open
		driver.findElement(By.id("j_idt88:j_idt95")).click();
//		while(driver.getWindowHandles().size()==1) {
//			System.out.println("Waiting for new windows to open..");
//			Thread.sleep(500);
//		}
		System.out.println(driver.getWindowHandles().size()-1+" new window(s) opened after wait");

	}

}
