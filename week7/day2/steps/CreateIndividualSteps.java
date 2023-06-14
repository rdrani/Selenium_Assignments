package assignments.week7.day2.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CreateIndividualSteps extends BaseClass {

	@Given("Click on New Individual")
	public void click_on_new_individual() {
		driver.findElement(By.xpath("//*[text()='New']")).click();
	}

	@Given("Enter the Last Name as {string}")
	public void enter_the_last_name_as(String name) {
		driver.findElement(By.xpath("//span[text()='Last Name']/following::input")).sendKeys(name);
	}

	@When("Click save individual")
	public void click_save_individual() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Save']"))).click();
	}

}
