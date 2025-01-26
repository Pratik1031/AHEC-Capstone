package com.ahecBDD.stepDefinitions;

import static org.testng.Assert.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.*;

import io.cucumber.java.en.*;

public class CommonSteps {
	WebDriver driver;
	Actions action;

	public void Loading_Program_Section() {
		WebElement Program = driver.findElement(By.id("menu-item-264"));
		action = new Actions(driver);
		Action hover = action.moveToElement(Program).build();
		hover.perform();
	}

	@Given("the browser is open and navigated to the url")
	public void the_browser_is_open_and_navigated_to_the_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://westfloridaahec.org/");
	}

	@When("user navigates to Login page")
	public void user_navigate_to_login_page() {
		WebElement myAccount = driver.findElement(By.linkText("MY ACCOUNT"));
		myAccount.click();
	}

	@And("user enters username {string} and password {string} and click log in button")
	public void user_enters_username_and_password_g(String username, String password) {
		WebElement user = driver.findElement(By.id("username"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement loginBtw = driver.findElement(By.cssSelector("button[name ='login']"));
		user.clear();
		user.sendKeys(username);
		pass.clear();
		pass.sendKeys(password);
		loginBtw.click();
	}

	@Then("verify the status {string} of login")
	public void verify_the_status_of_login(String expectedstatus) {
		WebElement dashboard = driver.findElement(By.tagName("h2"));
		if (expectedstatus.equals("success"))
			assertTrue(dashboard.getText().equals("DASHBOARD"), "Valid user login failed");
		else
			assertFalse(dashboard.getText().equals("DASHBOARD"), "Invalid user login");
	}

	@And("user enters username {string} email {string} and password {string}")
	public void user_enters_username_email_and_password(String username, String email, String password) {
		WebElement user = driver.findElement(By.id("reg_username"));
		WebElement Email = driver.findElement(By.id("reg_email"));
		WebElement pass = driver.findElement(By.id("reg_password"));
		WebElement registerBtw = driver.findElement(By.cssSelector("button[name ='register']"));
		user.clear();
		user.sendKeys(username);
		Email.clear();
		Email.sendKeys(email);
		pass.clear();
		pass.sendKeys(password);
		registerBtw.click();
	}

	@Then("verify the status {string} of registration")
	public void verify_the_status_of_registration(String expectedstatus) {
		WebElement dashboard = driver.findElement(By.tagName("h2"));
		if (expectedstatus.equals("success"))
			assertTrue(dashboard.getText().equals("DASHBOARD"), "valid user login failed");
		else
			assertFalse(dashboard.getText().equals("DASHBOARD"), "Invalid user login success");
	}

	@When("user hover over PROGRAMS nav-Link")
	public void user_hover_over_programs_nav_link() {
		Loading_Program_Section();
	}

	@And("user clicks Tobacco link")
	public void user_clicks_tobacco_link() {
		WebElement Tobacco = driver.findElement(By.partialLinkText("Tobacco"));
		Tobacco.click();

	}

	@Then("validate Tobacco link is navigating to Tobacco page")
	public void validate_tobacco_link_is_navigating_to_tobacco_page() {
		String content = driver.findElement(By.className("entry-title")).getText();
		// Title verification
		assertTrue(driver.getTitle().contains("Tobacco"), "Not navigating to Tobacco page");
		// Content verification
		assertTrue(content.contentEquals("TOBACCO"), "Not navigating to Tobacco page");
	}

	@When("user clicks Quit Tobacco")
	public void user_clicks_quit_tobacco() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement QuitTobacco = driver.findElement(By.xpath("//div[@class = 'post-content']//a[1]//h2"));
		QuitTobacco.click();
	}

	@Then("validate page is navigated to Quit Tobacco content")
	public void validate_page_is_navigated_to_quit_tobacco_content() {
		WebElement Title = driver.findElement(By.tagName("h1"));
		assertEquals(Title.getText(), "QUIT TOBACCO", "Wrong Page");
	}

	@And("user clicks AHEC Scholars link")
	public void user_clicks_ahec_scholars_link() {
		WebElement AHECScholars = driver.findElement(By.partialLinkText("AHEC Scholars"));
		AHECScholars.click();
	}

	@Then("validate AHEC Scholars link is navigating to AHEC Scholars page")
	public void validate_ahec_scholars_link_is_navigating_to_ahec_scholars_page() {
		String content = driver.findElement(By.className("entry-title")).getText();
		assertTrue(driver.getTitle().contains("AHEC Scholars"), "Not navigating to AHEC Scholars page");
		assertTrue(content.contentEquals("AHEC SCHOLARS"), "Not navigating to AHEC Scholars page");
	}

	@Then("validate AHEC Scholars content {string}")
	public void validate_ahec_scholars_content(String ExpectedContent) {
		String Content = driver.findElement(By.tagName("h3")).getText();
		assertEquals(Content, ExpectedContent, "Wrong page");
	}

	@And("user clicks Healthy Aging link")
	public void user_clicks_healthy_aging_link() {
		WebElement HealthyAging = driver.findElement(By.partialLinkText("Healthy Aging"));
		HealthyAging.click();
	}

	@Then("validate Healthy Aging link is navigating to Healthy Aging page")
	public void validate_healthy_aging_link_is_navigating_to_healthy_aging_page() {
		String content = driver.findElement(By.className("entry-title")).getText();
		assertTrue(driver.getTitle().contains("Healthy Aging"), "Not navigating to Healthy Aging page");
		assertTrue(content.contentEquals("HEALTHY AGING"), "Not navigating to Healthy aging page");
	}

	@And("validate the content of fourth fusion-li-item is {string}")
	public void validate_the_content_of_fourth_fusion_li_item_is(String expectedContent) {
		List<WebElement> Content = driver.findElements(By.className("fusion-li-item-content"));
		assertEquals(Content.get(3).getText(), expectedContent);
	}

	@When("user clicks Covering Florida link")
	public void user_clicks_covering_florida_link() {
		WebElement Navigators = driver.findElement(By.partialLinkText("Covering "));
		Navigators.click();
	}

	@Then("validate Covering Florida link is navigating to Covering Florida page")
	public void validate_covering_florida_link_is_navigating_to_covering_florida_page() {
		String content = driver.findElement(By.tagName("h2")).getText();
		assertTrue(driver.getTitle().contains("Navigators"), "Not navigating to Navigators  page");
		assertTrue(content.contentEquals("EDUCATING TOWARDS A HEALTHIER COMMUNITY"), "Not navigating to Tobacco page");

	}

	@Then("validate the content in main where content-box-heading count {int}")
	public void validate_the_content_using_content_box_heading_count_in_main(Integer expectedCount) {
		int ActualCount = driver.findElements(By.xpath("//main//h2[@class = 'content-box-heading']")).size();

		assertEquals(ActualCount, expectedCount, "Wrong content page");
	}

	@When("user navigates to account details")
	public void user_navigates_to_account_details() {
		WebElement accountDetails = driver.findElement(By.xpath("//*[@id=\"post-381\"]/div/div/nav/ul/li[6]/a"));
		accountDetails.click();
	}

	@And("user changes Display name as {string} and save changes")
	public void user_changes_display_name_as_and_save_changes(String newDisplayName) {
		WebElement displayName = driver.findElement(By.id("account_display_name"));
		displayName.clear();
		displayName.sendKeys(newDisplayName);
		WebElement saveChanges = driver.findElement(By.cssSelector("button[value = 'Save changes']"));
		saveChanges.submit();
	}

	@Then("Display name is changed and {string} is displayed in the hello message")
	public void display_name_is_changed_and_is_displayed_in_the_account(String newDisplayName) {
		String helloMessage = driver.findElement(By.className("hello")).getText();
		assertEquals(helloMessage, "Hello " + newDisplayName);
	}

	@When("user changes password {string} to {string}")
	public void user_changes_password_to(String oldpass, String newpass) {
		WebElement currentPassword = driver.findElement(By.id("password_current"));
		WebElement newPassword = driver.findElement(By.id("password_1"));
		WebElement confPassword = driver.findElement(By.id("password_2"));

		currentPassword.sendKeys(oldpass);
		newPassword.sendKeys(newpass);
		confPassword.sendKeys(newpass);

		WebElement saveChanges = driver.findElement(By.cssSelector("button[value = 'Save changes']"));
		saveChanges.submit();

	}

	@And("user clicks log out")
	public void user_clicks_log_out() {
		WebElement logout = driver.findElement(By.linkText("Log out"));
		logout.click();
	}

	@Then("the Login page is displayed")
	public void the_login_page_is_displayed() {
		WebElement LoginTitle = driver.findElement(By.tagName("h2"));
		assertEquals(LoginTitle.getText(), "LOGIN", "Log out failed");
	}

	@When("user user enters username {string} and password {string} and click log in button")
	public void user_user_enters_username_and_password_and_click_log_in_button(String username, String Newpassword) {
		WebElement user = driver.findElement(By.id("username"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement loginBtw = driver.findElement(By.cssSelector("button[name ='login']"));
		user.clear();
		user.sendKeys(username);
		pass.clear();
		pass.sendKeys(Newpassword);
		loginBtw.click();
	}

	@Then("Account login successful")
	public void account_login_successful() {
		WebElement Dashboard = driver.findElement(By.tagName("h2"));
		assertEquals(Dashboard.getText(), "DASHBOARD", "Log in failed");
	}

	@When("user enters firstname {string} , lastname {string} , phone {string} and email {string} in form")
	public void user_enters_firstname_lastname_phone_and_email_in_form(String fname, String lname, String ph,
			String email) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement firstNameEl = driver.findElement(By.cssSelector("input[title = 'First']"));
		WebElement lastNameEl = driver.findElement(By.cssSelector("input[title = 'Last']"));
		WebElement PhoneEl = driver.findElement(By.id("cog-1"));
		WebElement EmailEl = driver.findElement(By.id("cog-2"));

		firstNameEl.sendKeys(fname);
		lastNameEl.sendKeys(lname);
		PhoneEl.sendKeys(ph);
		EmailEl.sendKeys(email);
	}

	@And("selects the appropriate options")
	public void selects_the_appropriate_options() {
		WebElement country = driver.findElement(By.xpath("//div[@class = 'el-radio-group']//label[4]"));
		country.click();
	}

	@And("clicks submit button")
	public void clicks_submit_button() {
		WebElement submitform = driver.findElement(By.className("cog-button__text"));
		submitform.click();

	}

	@Then("Successful form submission message {string} is displayed")
	public void successful_form_submission_message_is_displayed(String successMessage) {

		WebElement formSubMessage = driver.findElement(By.className("cog-confirmation-message"));
		assertEquals(formSubMessage.getText(), successMessage, "Form not submitted successfully");

	}

	@And("browser is closed")
	public void browser_is_closed() {
		driver.quit();
	}
}
