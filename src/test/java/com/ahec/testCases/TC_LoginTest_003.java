package com.ahec.testCases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ahec.PageObjects.LoginPage;

public class TC_LoginTest_003 extends BaseClass {

	WebDriverWait wait;

	@BeforeMethod
	public void setupWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	LoginPage lp;

	@Test(priority = 1)
	public void testUserRegistration() {
		lp = new LoginPage(driver);
		test = extent.createTest("testUserRegistration");
		test.info("Test started: userRegistration");

		try {

			lp.navigateToMyAccount();
			test.info("Navigated to 'My Account'.");

			// Register a new user
			lp.setRegUserName("John234");
			lp.setRegEmail("johnd58@gmail.com");
			lp.setRegPassword("John@234");
			lp.clickRegister();
			test.info("User registered with username: John234 and email: johnd32@gmail.com");

			// Verify Dashboard after registration
			WebElement DashboardHeading = driver.findElement(By.xpath("//h1[text()='My account']"));
			wait.until(ExpectedConditions.visibilityOf(DashboardHeading));
			Assert.assertTrue(DashboardHeading.isDisplayed(), "You are Not redirected to the Dashboard!");
			test.pass("Redirected to Dashboard after registration successfully.");

			test.info("User logged out successfully.");

		} catch (Exception e) {
			captureScreenshot("testUserRegistration");
			test.fail("Error occurred during user registration: " + e.getMessage());
			Assert.fail("User Registration failed.");
		}

		test.info("Test completed: userRegistration");
	}

	@Test(priority = 2)
	public void testVerifyLogin() {
		lp = new LoginPage(driver);
		test = extent.createTest("testVerifyLogin with username: " + username);
		test.info("Test started: verifyLogin");

		try {
			lp.setLoginUserName(username);
			lp.setLoginPassword(password);
			lp.clickLogin();
			test.info("Entered Username: " + username + " and Password: " + password);

			WebElement DashboardHeading = driver.findElement(By.xpath("//h1[text()='My account']"));
			wait.until(ExpectedConditions.visibilityOf(DashboardHeading));
			Assert.assertTrue(DashboardHeading.isDisplayed(), "You are not redirected to the Dashboard!");
			test.pass("Redirected to Dashboard after login successfully.");

		} catch (Exception e) {
			captureScreenshot("testVerifyLogin_" + username);
			test.fail("Error occurred during login: " + e.getMessage());
			Assert.fail("Login failed.");
		}

		test.info("Test completed: verifyLogin");
	}

	@Test(priority = 3)
	public void testForgotPassword() {
		lp = new LoginPage(driver);
		test = extent.createTest("testForgotPassword");
		test.info("Test Started: Forgot Password");

		try {
			lp.navigateToMyAccount();
			test.info("Navigated to 'My Account'.");

			lp.clickForgotPassword();
			test.info("Clicked on 'Lost your password?' link.");

			lp.enterEmailForPasswordReset("john@gmail.com");
			test.info("Entered email: john@gmail.com");
			lp.clickResetPasswordButton();
			test.info("Clicked on 'Reset Password' button.");

			Assert.assertTrue(lp.isSuccessMessageDisplayed(), "Success message is not displayed.");
			test.pass("Password reset process completed successfully.");

		} catch (Exception e) {
			captureScreenshot("testForgotPassword");
			test.fail("Error occurred during forgot password: " + e.getMessage());
			Assert.fail("Forgot password process failed.");
		}

		test.info("Test Completed: Forgot Password");
	}

}
