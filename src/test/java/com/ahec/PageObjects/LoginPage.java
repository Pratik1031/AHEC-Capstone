package com.ahec.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {

	private By regUsername = By.id("reg_username");
	private By regPassword = By.id("reg_password");
	private By regEmail = By.id("reg_email");
	private By registration = By.xpath("//button[@value='Register']");
	private By loginUsername = By.name("username");
	private By loginPassword = By.id("password");
	private By loginBtn = By.name("login");
	private By forgotPassword = By.xpath("//a[text()='Lost your password?']");
	private By myAccountLink = By.xpath("//*[@id='menu-main-menu']/li[8]"); // Corrected XPath here
	private By emailField = By.id("user_login");
	private By resetButton = By.xpath("//button[@value='Reset password']");
	private By successMessage = By.xpath("(//div[@class='wc-block-components-notice-banner__content'])[1]");

	WebDriver ldriver;

	// Constructor to initialize the ldriver
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Registration form methods
	public void setRegUserName(String uname) {
		WebElement usernameField = ldriver.findElement(regUsername);
		usernameField.clear();
		usernameField.sendKeys(uname);
	}

	public void setRegPassword(String pwd) {
		WebElement passwordField = ldriver.findElement(regPassword);
		passwordField.clear();
		passwordField.sendKeys(pwd);
	}

	public void setRegEmail(String email) {
		WebElement emailField = ldriver.findElement(regEmail);
		emailField.clear();
		emailField.sendKeys(email);
	}

	public void clickRegister() {
		WebElement registerButton = ldriver.findElement(registration);
		registerButton.click();
	}

	// Login form methods
	public void setLoginUserName(String uname) {
		WebElement usernameField = ldriver.findElement(loginUsername);
		usernameField.clear();
		usernameField.sendKeys(uname);
	}

	public void setLoginPassword(String pwd) {
		WebElement passwordField = ldriver.findElement(loginPassword);
		passwordField.clear();
		passwordField.sendKeys(pwd);
	}

	public void clickLogin() {
		WebElement loginButton = ldriver.findElement(loginBtn);
		loginButton.click();
	}

	// Forgot Password link method
	public void clickForgotPassword() {
		WebElement forgotPasswordLink = ldriver.findElement(forgotPassword);
		forgotPasswordLink.click();
	}

	public void navigateToMyAccount() {
		WebElement myAccLink = ldriver.findElement(myAccountLink);
		myAccLink.click();
	}

	public void enterEmailForPasswordReset(String email) {
		WebElement emailInput = ldriver.findElement(emailField);
		emailInput.sendKeys(email);
	}

	public void clickResetPasswordButton() {
		WebElement resetBtn = ldriver.findElement(resetButton);
		resetBtn.click();
	}

	public boolean isSuccessMessageDisplayed() {
		WebElement successMsg = ldriver.findElement(successMessage);
		return successMsg.isDisplayed();
	}
}
