package assignments.week5.day1.servicenow.incident;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateIncident extends IncidentBase{
  @Test
  public void createIncident() throws InterruptedException {
	  
//		4. Click on Create new option and fill the manadatory fields
		shadow.findElementByXPath("//span[text()='Create New']").click();
		WebElement frameElement = shadow.findElementByXPath("//iframe");
		driver.switchTo().frame(frameElement);
		strIncidentId = shadow.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
		System.out.println("Incident id:"+strIncidentId);
		shadow.findElementByXPath("//button[@id='lookup.incident.caller_id']").click();
		Thread.sleep(1000);
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		shadow.findElementByXPath("//a[text()='System Administrator']").click();
		driver.switchTo().window(windowHandles.get(0));
		Thread.sleep(1000);
		driver.switchTo().frame(frameElement);
		shadow.findElementByXPath("//a[@id='lookup.incident.short_description']").click();
		windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		shadow.findElementByXPath("//a[text()='Issue with networking']").click();
		driver.switchTo().window(windowHandles.get(0));
		driver.switchTo().frame(frameElement);
		shadow.findElementByXPath("//button[@id='sysverb_insert_bottom']").click();
		
//		5. Verify the newly created incident ( copy the incident number and paste it in search field and enter then verify the instance number created or not)
		Thread.sleep(2000);
		Select incidentSel = new Select(shadow.findElementByXPath("//span[text()='Incidents']/following::select"));
		incidentSel.selectByVisibleText("Number");
		shadow.findElementByXPath("//span[text()='Incidents']/following::input").sendKeys(strIncidentId,Keys.ENTER);
		Thread.sleep(2000);
		String strIncFromTable = shadow.findElementByXPath("//tbody[@class='list2_body']//td[3]").getText();
		if(strIncidentId.equals(strIncFromTable)) {
			System.out.println("Incident created successfully");
		}else {
			System.out.println("Incident not created");
		}
		
  }

}
