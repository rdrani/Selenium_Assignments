package assignments.week7.day2.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateDashboardSteps extends BaseClass {

	@Given("Enter Name as {string}")
	public void enter_name_as(String name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("dashboardNameInput")))).sendKeys(name);
	}

	@When("Click Create")
	public void click_create() throws InterruptedException {
		driver.findElement(By.id("submitBtn")).click();
	}

	@Then("Verify Dashboard Name")
	public void verify_individuals_name() {
		String name = driver.findElement(By.xpath("//span[@class='slds-form-element__static slds-grid slds-grid_align-spread']")).getText();
		if (name.indexOf("\n") != -1)
			name = name.substring(0, name.indexOf("\n"));
		System.out.println("Dashboard Name: "+name);
	}
}
