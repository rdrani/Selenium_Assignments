package assignments.week5.day1.servicenow.incident;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends IncidentBase {
	@Test
	public void updateIncident() throws InterruptedException {
		String strUrgency = "1 - High";
		String strState = "In Progress";

//		3. Click-All and Enter Incident in filter navigator and press enter 
		shadow.findElementByXPath("//input[@id='filter']").sendKeys(Keys.ENTER);
		Thread.sleep(1000);

//		4. Search for the existing incident and click on the incident (OR) The instance is available by default
		WebElement frameElement = shadow.findElementByXPath("//iframe");
		driver.switchTo().frame(frameElement);
		shadow.findElementByXPath("//span[text()='Incidents']/following::input").sendKeys(strIncidentId, Keys.ENTER);
		shadow.findElementByXPath("//tbody[@class='list2_body']//td[3]/a").click();

//		5. Update the incidents with Urgency as High and State as In Progress
		Thread.sleep(2000);
		Select urgency = new Select(shadow.findElementByXPath("//select[@id='incident.urgency']"));
		urgency.selectByVisibleText(strUrgency);
		Select state = new Select(shadow.findElementByXPath("//select[@id='incident.state']"));
		state.selectByVisibleText(strState);
		shadow.findElementByXPath("//button[text()='Update']").click();

//		6. Verify the priority and state
		Thread.sleep(3000);
		Select incidentSel = new Select(shadow.findElementByXPath("//span[text()='Incidents']/following::select"));
		incidentSel.selectByVisibleText("Number");
		
		shadow.findElementByXPath("//span[text()='Incidents']/following::input").sendKeys(strIncidentId, Keys.ENTER);
		Thread.sleep(2000);
		shadow.findElementByXPath("//tbody[@class='list2_body']//td[3]/a").click();

		urgency = new Select(shadow.findElementByXPath("//select[@id='incident.urgency']"));
		boolean isUrgency = strUrgency.equals(urgency.getFirstSelectedOption().getText());
		state = new Select(shadow.findElementByXPath("//select[@id='incident.state']"));
		boolean isState = strState.equals(state.getFirstSelectedOption().getText());
		if(isUrgency&&isState) {
			System.out.println("Incident updated correctly");
		}else {
			System.out.println("Incident not updated correctly");
		}
		
	}
}
