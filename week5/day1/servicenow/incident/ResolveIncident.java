package assignments.week5.day1.servicenow.incident;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ResolveIncident extends IncidentBase {

	@Test
	public void resolveIncident() throws InterruptedException {
		String strState = "Resolved";

//		4.  click on open and Search for the existing incident and navigate into the incident.
		shadow.findElementByXPath("//span[text()='Open']").click();
		Thread.sleep(1000);
		WebElement frameElement = shadow.findElementByXPath("//iframe");
		driver.switchTo().frame(frameElement);
		shadow.findElementByXPath("//span[text()='Incidents']/following::input").sendKeys(strIncidentId, Keys.ENTER);
		shadow.findElementByXPath("//tbody[@class='list2_body']//td[3]/a").click();
		
//		5. Update the state as Resolved 
		Select state = new Select(shadow.findElementByXPath("//select[@id='incident.state']"));
		state.selectByVisibleText(strState);
		shadow.findElementByXPath("//span[text()='Resolution Information']").click();
		Select code = new Select(shadow.findElementByXPath("//select[@id='incident.close_code']"));
		code.selectByVisibleText("Solution provided");
		shadow.findElementByXPath("//textarea[@id='incident.close_notes']").sendKeys("Resolved");
		shadow.findElementByXPath("//button[text()='Update']").click();
		
//		6. Click update  and verify the State
		Select incidentSel = new Select(shadow.findElementByXPath("//span[text()='Incidents']/following::select"));
		incidentSel.selectByVisibleText("Number");
		
		shadow.findElementByXPath("//span[text()='Incidents']/following::input").sendKeys(strIncidentId, Keys.ENTER);
		Thread.sleep(2000);
		String strStateResolved = shadow.findElementByXPath("//tbody[@class='list2_body']//td[8]").getText();
		if(strState.equals(strStateResolved)) {
			System.out.println("Incident resolved");
		}else {
			System.out.println("Incident not resolved");
		}
		
		
	}
}
