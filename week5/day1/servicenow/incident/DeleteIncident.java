package assignments.week5.day1.servicenow.incident;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DeleteIncident extends IncidentBase{
	@Test
	public void deleteIncident() throws InterruptedException {

//		3. Enter Incident in filter navigator and press enter
		shadow.findElementByXPath("//input[@id='filter']").sendKeys(Keys.ENTER);
		Thread.sleep(1000);

//		4. Search for the existing incident and navigate into the incident
		WebElement frameElement = shadow.findElementByXPath("//iframe");
		driver.switchTo().frame(frameElement);
		shadow.findElementByXPath("//span[text()='Incidents']/following::input").sendKeys(strIncidentId, Keys.ENTER);
		shadow.findElementByXPath("//tbody[@class='list2_body']//td[3]/a").click();

//		5. Delete the incident
		shadow.findElementByXPath("//button[@id='sysverb_delete']").click();
		Thread.sleep(3000);
		shadow.findElementByXPath("//button[@id='ok_button']").click();
		Thread.sleep(2000);
		
//		6. Verify the deleted incident"
		Select incidentSel = new Select(shadow.findElementByXPath("//span[text()='Incidents']/following::select"));
		incidentSel.selectByVisibleText("Number");
		shadow.findElementByXPath("//span[text()='Incidents']/following::input").sendKeys(strIncidentId, Keys.ENTER);
		Thread.sleep(3000);
		int size = shadow.findElementsByXPath("//tbody[@class='list2_body']/tr").size();
		if(size == 0) {
			System.out.println("Incident deleted successfully");
		}else {
			System.out.println("Incident not deleted");
		}
	}
	
}
