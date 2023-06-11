package assignments.week7.day1.steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadsSteps {
	public ChromeDriver driver;
	public String leadID;
	public String leadName;
	List<String> allhandles;

	@Given("Open the Chrome browser")
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	
	@Then("Close the browser")
	public void closeBrowser() {
		driver.quit();
	}

	@And("Load the url")
	public void loadUrl() {
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("Enter the username as {string}") // to parameterize data - {string (lower case)}-> case sensitive
	public void enterUsername(String uName) { // pass parameter to method
		driver.findElement(By.id("username")).sendKeys(uName); // use parameter instead of hard coding value
	}

	@And("Enter the password as {string}")
	public void enterPassword(String pWord) {
		driver.findElement(By.id("password")).sendKeys(pWord);
	}

	@When("Click on Login button")
	public void clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("HomePage should be displayed")
	public void verifyHomePage() {
		String title = driver.getTitle();
		if (title.contains("Leaftaps"))
			System.out.println("Login successfull");
	}

	@But("Error message should be displayed")
	public void verifyErrorMessage() {
		System.out.println("Error message is displayed");
	}

	@When("Click on CRMSFA link")
	public void clickCRMSFALink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@And("Click on Leads link")
	public void clickLeadsLink() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@And("Click on CreateLead link")
	public void clickCreateLeadLink() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Given("Enter the companyName as (.*)$")
	public void enterCompanyName(String cName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	}

	@And("Enter the firstName as (.*)$")
	public void enterFirstName(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}

	@And("Enter the lastName as (.*)$")
	public void enterLastName(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	}

	@And("Enter the phone number as (.*)$")
	public void enterPhoneNumber(String ph) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(ph);
	}

	@When("Click on submit button")
	public void clickSubmitButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("ViewLeads page should be displayed as (.*)$")
	public void verifyViewLeadsPage(String cName) {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(cName)) {
			System.out.println("Lead created successfully");
		}
	}

	@And("Click on Find Leads link")
	public void clickFindLeadsLink() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@And("Click on Phone tab")
	public void clickPhoneTab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@Given("Enter the phone number to find lead as (.*)$")
	public void enterFindLeadPhoneNumber(String ph) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(ph);
	}

	@When("Click on Find Leads button")
	public void clickFindLeadsButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}

	@And("Click on the first Lead from the results")
	public void clickFirstLeadFromResults() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@And("Click on the Edit button")
	public void clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@And("Enter the company name to edit as (.*)$")
	public void enterEditCompanyName(String cName) {
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys(cName);
	}

	@Then("ViewLeads page should be displayed with company name as (.*)$")
	public void verifyLeadEdited(String cName) {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(cName)) {
			System.out.println("Lead edited successfully");
		}
	}

	@And("Capture lead ID of First Resulting lead")
	public void captureLeadId() {
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	}

	@And("Click on Delete button")
	public void clickDeleteButton() {
		driver.findElement(By.linkText("Delete")).click();
	}

	@And("Enter captured Lead Id")
	public void enterLeadId() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}

	@Then("Verify no results are displayed")
	public void verifyLeadDeleted() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Lead deleted successfully");
		}
	}

	@And("Capture lead name of First Resulting lead")
	public void captureLeadName() {
		leadName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
	}

	@And("Click on Duplicate Lead")
	public void clickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}

	@Then("Verify lead name displayed is same as captured lead name")
	public void verifyLeadDuplicated() {
		String duplicateName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if (leadName.equals(duplicateName)) {
			System.out.println("Lead duplicated successfully");
		}
	}
	
	@And("Click on Merge Leads link")
	public void clickMergeLeadsLink() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	
	@And("Click on lookup widget of From Lead")
	public void clickFromLeadWidget() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	}
	
	@And("Change driver control to popup window")
	public void switchToPopUpWindow() {
		allhandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allhandles.get(1));
	}
	
	@And("Enter the firstName of From Lead as (.*)$")
	public void enterFromFirstName(String fFirstName) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fFirstName);
	}
	
	@And("Switch driver control back to main window")
	public void switchToMainWindow() {
		driver.switchTo().window(allhandles.get(0));
	}
	
	@And("Click on lookup widget of To Lead")
	public void clickToLeadWidget() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	}
	
	@And("Enter the firstName of To Lead as (.*)$")
	public void enterToFirstName(String tFirstName) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(tFirstName);
	}
	
	@And("Click on Merge button")
	public void clickMergeButton() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
	}
	
	@And("Accept the alert")
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	@Then("Verify leads are merged")
	public void verifyLeadsMerged() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Leads merged successfully");
		}
	}


}
