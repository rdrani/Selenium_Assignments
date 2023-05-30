package assignments.week5.day1.servicenow.incident;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateIncident2 extends IncidentBase{
	  @Test
	  public void createIncident2() throws InterruptedException {
			
//			4.  Click on Create new option and Create new incident without filling the manadatory fields (Short description & Caller)
			shadow.findElementByXPath("//span[text()='Create New']").click();
			WebElement frameElement = shadow.findElementByXPath("//iframe");
			driver.switchTo().frame(frameElement);
			shadow.findElementByXPath("//button[@id='sysverb_insert']").click();
			
//			5. Verify the error message displayed on the top
			Thread.sleep(500);
			String strErrorMsg = shadow.findElementByXPath("//div[@id='output_messages']/div").getText();
			if(strErrorMsg!="") {
				System.out.println("Error message displayed: \n"+strErrorMsg);
			}else {
				System.out.println("Error message not displayed");
			}
			
	  }



}
