package assignments.week7.day2.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesForceSteps extends BaseClass{

	@Given("Login to Salesforce application")
	public void login_to_salesforce_application() {
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
	}

	@Given("Click on toggle menu button from the left corner")
	public void click_on_toggle_menu_button() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}

	@Given("Click view All")
	public void click_view_all() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}

	@Given("Click {string} from App Launcher")
	public void click_from_app_launcher(String option) {
		Actions builder = new Actions(driver);
		builder.scrollToElement(driver.findElement(By.xpath("//p[text()='"+option+"']"))).perform();
		driver.findElement(By.xpath("//p[text()='"+option+"']")).click();
	}
	
	@Given("Click on {string} button")
	public void click_on_new_button(String option) {
		driver.findElement(By.xpath("//*[text()='"+option+"']")).click();
	}

	@When("Click save")
	public void click_save() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']"))).click();
	}

	@Then("Verify {string} name")
	public void verify_account_name(String module) {
		String alert = driver.findElement(By.xpath("//div[@role='alertdialog']")).getText();
		System.out.println(alert);
		Assert.assertTrue(alert.contains("created"));
	}
}
