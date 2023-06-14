package assignments.week7.day2.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CreateOpportunitySteps extends BaseClass {
	String opportunityName;

	@Given("Click on Opportunities tab")
	public void click_on_opportunities_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@data-target-selection-name='sfdc:TabDefinition.standard-Opportunity']"))).click();
	}

	@Given("Enter Opportunity name as {string}, Get the text and store it")
	public void enter_opportunity_name_as_get_the_text_and_store_it(String name) {
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input")).sendKeys(name);
		opportunityName = name;
	}

	@Given("Choose close date as Today")
	public void choose_close_date_as_today() {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
	}

	@Given("Choose Close date as Tomorrow Date")
	public void choose_close_date_as_tomorrow_date() {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']/following::td")).click();
	}
	
	@Given("Select Stage as Needs Analysis")
	public void select_stage_as_needs_analysis() {
		driver.findElement(By.xpath("//label[text()='Stage']/following::button")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	}

	@When("Verify the Alert message {string} displayed for Name and Stage")
	public void verify_the_alert_message_displayed_for_name_and_stage(String string) {
		System.out.println(driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::div[contains(@class,'slds-form-element__help')]")).getText());
		System.out.println(driver.findElement(By.xpath("//label[text()='Stage']/following::div[contains(@class,'slds-form-element__help')]")).getText());
	}
}
