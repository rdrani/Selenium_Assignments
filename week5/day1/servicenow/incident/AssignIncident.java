package assignments.week5.day1.servicenow.incident;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AssignIncident extends IncidentBase {
	@Test
	public void assignIncident() throws InterruptedException {
		String strGroup = "Application Development";

//		4. click on open and Search for the existing incident and click on  the incident
		shadow.findElementByXPath("//span[text()='Open']").click();
		Thread.sleep(1000);
		WebElement frameElement = shadow.findElementByXPath("//iframe");
		driver.switchTo().frame(frameElement);
		Select incidentSel = new Select(shadow.findElementByXPath("//span[text()='Incidents']/following::select"));
		incidentSel.selectByVisibleText("Number");
		
		shadow.findElementByXPath("//span[text()='Incidents']/following::input").sendKeys(strIncidentId, Keys.ENTER);
		shadow.findElementByXPath("//tbody[@class='list2_body']//td[3]/a").click();
		
		
//		5. Assign the incident to  Software group
		shadow.findElementByXPath("//button[@id='lookup.incident.assignment_group']").click();
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		shadow.findElementByXPath("//a[text()='"+strGroup+"']").click();
		driver.switchTo().window(windowHandles.get(0));
		Thread.sleep(1000);
		driver.switchTo().frame(frameElement);
		shadow.findElementByXPath("//button[@id='lookup.incident.assigned_to']").click();
		windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		shadow.findElementByXPath("//tbody//td[3]/a").click();
		driver.switchTo().window(windowHandles.get(0));
		Thread.sleep(1000);
		driver.switchTo().frame(frameElement);
		
//		6. Update the incident with Work Notes
		shadow.findElementByXPath("//textarea[@id='activity-stream-textarea']").sendKeys("Incident assigned to Application Development group");
		shadow.findElementByXPath("//button[text()='Update']").click();
		
//		7. Verify the Assignment group and Assigned for the incident
		incidentSel = new Select(shadow.findElementByXPath("//span[text()='Incidents']/following::select"));
		incidentSel.selectByVisibleText("Number");
		shadow.findElementByXPath("//span[text()='Incidents']/following::input").sendKeys(strIncidentId, Keys.ENTER);
		Thread.sleep(2000);
		String strAssignedGrp = shadow.findElementByXPath("//tbody[@class='list2_body']//td[10]").getText();
		String strAssignedTo = shadow.findElementByXPath("//tbody[@class='list2_body']//td[11]").getText();
		if(strGroup.equals(strAssignedGrp)) {
			System.out.println("Incident Assignment group: "+strAssignedGrp);
			System.out.println("Incident Assigned to: "+strAssignedTo);
		}else {
			System.out.println("Incident not assigned to any group");
		}
	

	}

}
