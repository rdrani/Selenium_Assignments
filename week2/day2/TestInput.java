package assignments.week2.day2;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestInput {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.leafground.com/input.xhtml");
		
//		Type your name
		driver.findElement(By.id("j_idt88:name")).clear();
		driver.findElement(By.id("j_idt88:name")).sendKeys("Rani R");
	
//		Append Country to this City.
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys(", India");
		
//		Verify if text box is disabled
		System.out.println("Text box is enabled: "+driver.findElement(By.id("j_idt88:j_idt93")).isEnabled());
		
//		Clear the typed text.
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		
//		Retrieve the typed text.
		System.out.println("The text is: "+ driver.findElement(By.id("j_idt88:j_idt97")).getAttribute("value"));
		
//		Type email and Tab. Confirm control moved to next element.
		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("test@google.com\t");
		System.out.println("Control moved to next input field: "+!driver.findElement(By.id("j_idt88:j_idt99")).isSelected());
		
//		Type about yourself
		driver.findElement(By.id("j_idt88:j_idt101")).sendKeys("Trying to learn Selenium");

//		Just Press Enter and confirm error message*
		driver.findElement(By.id("j_idt106:thisform:age")).submit();
		System.out.println("Error message displayed: "+driver.findElement(By.xpath("//span[text()='Age is mandatory']")).isDisplayed());
		
//		Click and Confirm Label Position Changes
		Point location = driver.findElement(By.id("j_idt106:j_idt113")).getLocation();
		driver.findElement(By.id("j_idt106:float-input")).click();
		Point location2 = driver.findElement(By.id("j_idt106:j_idt113")).getLocation();
		if((location.x!=location2.x)||(location.y!=location2.y)) {
			System.out.println("Label position has changed from "+location+" to "+location2);
		}
		
//		Type your name and choose the third option
		driver.findElement(By.id("j_idt106:auto-complete_input")).sendKeys("Rani");
		driver.findElement(By.xpath("//span[@id='j_idt106:auto-complete_panel']//li[3]")).click();
		driver.findElement(By.id("j_idt106:j_idt116_input")).sendKeys("01/01/2001");
		
//		Type your DOB (mm/dd/yyyy) and confirm date chosen
		String month = driver.findElement(By.className("ui-datepicker-month")).getText();
		String year = driver.findElement(By.className("ui-datepicker-year")).getText();
		String day = driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//a[@class=' ui-state-default ui-state-active']")).getText();
		System.out.println("Date selected: "+day+" "+month+" "+year);
		
//		Type number and spin to confirm value changed
		driver.findElement(By.id("j_idt106:j_idt118_input")).sendKeys("1008");
		driver.findElement(By.xpath("//span[@id='j_idt106:j_idt118']//span[@class='ui-button-text']")).click();
		System.out.println("Number changed after spin: "+(driver.findElement(By.id("j_idt106:j_idt118_input")).getText()!="1008"));
		
//		Type random number (1-100) and confirm slider moves correctly
		driver.findElement(By.id("j_idt106:slider")).sendKeys(""+(new Random()).nextInt(101));
		Thread.sleep(2000);
		System.out.println("Slider moved to :"+driver.findElement(By.xpath("//div[@id='j_idt106:j_idt120']/span")).getAttribute("style"));
		
//		Click and Confirm Keyboard appears
		driver.findElement(By.id("j_idt106:j_idt122")).click();
		System.out.println("Keyboard displayed: "+driver.findElement(By.xpath("//div[@class='keypad-row']/parent::div")).isDisplayed());
		
//		Custom Toolbar 
		driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124_toolbar']//button[contains(@class,'ql-bold')]")).click();
		driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124_editor']/div[contains(@class,'ql-editor')]")).sendKeys("Selenium ");
		driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124_toolbar']//button[contains(@class,'ql-bold')]")).click();
		driver.findElement(By.xpath("//div[@id='j_idt106:j_idt124_editor']/div[contains(@class,'ql-editor')]")).sendKeys("is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation. It provides a playback tool for authoring functional tests across most modern web browsers, without the need to learn a test scripting language");
		
	}

}
