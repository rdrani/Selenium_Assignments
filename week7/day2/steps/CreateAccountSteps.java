package assignments.week7.day2.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;

public class CreateAccountSteps extends BaseClass {

	@Given("Click on Accounts tab")
	public void click_on_accounts_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@data-target-selection-name='sfdc:TabDefinition.standard-Account']"))).click();
	}

	@Given("Enter {string} as account name")
	public void enter_as_account_name(String name) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
	}

	@Given("Select Ownership as Public")
	public void select_ownership_as_public() {
		driver.findElement(By.xpath("//label[text()='Ownership']/following::button")).click();
		driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Public']")).click();
	}

}
