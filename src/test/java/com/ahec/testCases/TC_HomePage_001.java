package com.ahec.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_HomePage_001 extends BaseClass {

	@Test(priority = 0)
	public void testVerifyURL() {
		test.info("Verifying the URL");
		try {
			String URL = driver.getCurrentUrl();
			String expectedURL = "https://westfloridaahec.org/";
			Assert.assertEquals(URL, expectedURL, "URL Mismatched! You are on the wrong AUT");
			test.pass("URL verified successfully.");
		} catch (Exception e) {
			test.fail("URL verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 1)
	public void testVerifyHomePageTitle() {
		test.info("Verifying Home Page Title");
		try {
			String title = driver.getTitle();
			String expectedTitle = "Home - West Florida Area Health Education Center, Inc";
			Assert.assertEquals(title, expectedTitle, "Home Page Title verification failed");
			test.pass("Home Page Title verified successfully.");
		} catch (Exception e) {
			test.fail("Home Page Title verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void testHomePageLogoIsDisplayed() {
		test.info("Verifying if logo is displayed on Home Page");
		try {
			WebElement logo = driver.findElement(By.xpath("//a[contains(@class, 'fusion-logo-link')]"));
			Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on Home Page");
			test.pass("Logo is displayed successfully.");
		} catch (Exception e) {
			test.fail("Logo verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 3)
	public void testVerifyNavigationMenu() {
		test.info("Verifying Navigation Menu");
		try {
			WebElement navBar = driver.findElement(By.id("menu-main-menu"));
			Assert.assertTrue(navBar.isDisplayed(), "Nav Bar is not Displayed!");
			test.pass("Navigation Menu is displayed correctly.");
		} catch (Exception e) {
			test.fail("Navigation Menu verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 4)
	public void testVerifyHealthPrograms() {
		test.info("Verifying Programs section");
		try {
			WebElement programs = driver.findElement(By.linkText("PROGRAMS"));
			Assert.assertTrue(programs.isDisplayed(), "Programs section is not displayed!");
			test.pass("Programs section is displayed successfully.");
			programs.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			test.fail("Programs section verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 5)
	public void testVerifyServicesDisplayed() {
		test.info("Verifying Services section");
		try {
			WebElement services = driver.findElement(By.id("menu-item-331"));
			Assert.assertTrue(services.isDisplayed(), "Services section is not displayed!");
			test.pass("Services section is displayed successfully.");
		} catch (Exception e) {
			test.fail("Services section verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 6)
	public void testVerifyCPRDisplayed() {
		test.info("Verifying CPR section");
		try {
			WebElement CPR = driver.findElement(By.id("menu-item-467"));
			Assert.assertTrue(CPR.isDisplayed(), "CPR Section is not displayed!");
			test.pass("CPR section is displayed successfully.");
		} catch (Exception e) {
			test.fail("CPR section verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 7)
	public void testVerifyContactUsDisplayed() {
		test.info("Verifying Contact Us section");
		try {
			WebElement contactUS = driver.findElement(By.cssSelector("li#menu-item-209"));
			Assert.assertTrue(contactUS.isDisplayed(), "Contact Us section is not displayed!");
			test.pass("Contact Us section is displayed successfully.");
		} catch (Exception e) {
			test.fail("Contact Us section verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 8)
	public void testVerifyNewsDisplayed() {
		test.info("Verifying News section");
		try {
			WebElement news = driver.findElement(By.id("menu-item-1097"));
			Assert.assertTrue(news.isDisplayed(), "News section is not displayed!");
			test.pass("News section is displayed successfully.");
		} catch (Exception e) {
			test.fail("News section verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 9)
	public void testVerifyMyAccountDisplayed() {
		test.info("Verifying My Account section");
		try {
			WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]"));
			Assert.assertTrue(myAccount.isDisplayed(), "My Account section is not displayed!");
			test.pass("My Account section is displayed successfully.");
		} catch (Exception e) {
			test.fail("My Account section verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 10)
	public void testVerifyContactUsFunctionality() {
		test.info("Verifying Contact Us functionality");
		try {
			WebElement contactUs = driver.findElement(By.cssSelector("li#menu-item-209"));
			contactUs.click();
			String title = driver.getTitle();
			test.info("Actual Title: " + title);
			String expectedTitle = "CONTACT US - West Florida Area Health Education Center, Inc";
			Assert.assertTrue(title.contentEquals(expectedTitle), "Contact Us Title Mismatched");
			test.pass("Contact Us Title verified successfully.");

			WebElement address = driver.findElement(By.partialLinkText("South Ferdon Blvd"));
			String actualAddress = address.getText();
			Assert.assertTrue(actualAddress.contains("Crestview"), "Address mismatched");
			test.pass("Address contains 'Crestview'. Verified successfully.");
		} catch (Exception e) {
			test.fail("Contact Us functionality verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 11)
	public void testSearchBoxWithValidInputs() {
		test.info("Testing Search Box with valid input");
		try {
			WebElement searchBox = driver.findElement(By.xpath("(//input[contains(@placeholder,'Search...')])[1]"));
			searchBox.sendKeys("Books");
			driver.navigate().to("https://westfloridaahec.org/?s=Books");
			WebElement result = driver.findElement(By.xpath("//h1[text()='Search results for: Books']"));
			Assert.assertTrue(result.isDisplayed(), "No Search Result Found");
			test.pass("Search Box with valid input verified successfully.");
		} catch (Exception e) {
			test.fail("Search Box with valid input verification failed: " + e.getMessage());
		}
	}

	@Test(priority = 12)
	public void testSearchBoxWithInvalidInputs() {
		test.info("Testing Search Box with invalid input");
		try {
			WebElement searchBox = driver.findElement(By.xpath("(//input[contains(@placeholder,'Search...')])[1]"));
			searchBox.sendKeys("#123XBooks");
			driver.navigate().to("https://westfloridaahec.org/?s=#123XBooks");
			WebElement result = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h2"));
			Assert.assertTrue(result.isDisplayed(), "No Search Result Found");
			Assert.assertTrue(result.getText().contains("Couldn't find what you're looking for!"),
					"Search Result Test Case Failed.");
			test.pass("Search Box with invalid input verified successfully.");
		} catch (Exception e) {
			test.fail("Search Box with invalid input verification failed: " + e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 13)
	public void testVerifySearchBar() {
		test.info("Verifying Search Bar functionality");
		try {
			WebElement searchBar = driver.findElement(By.xpath("(//input[@type='search'])[1]"));
			searchBar.sendKeys("Tobacco");
			String enteredString = searchBar.getAttribute("value");
			test.info("Entered text in search bar: " + enteredString);

			WebElement searchButton = driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
			searchButton.click();

			WebElement searchResult = driver.findElement(By.xpath("//h1[text()='Search results for: Tobacco']"));
			Assert.assertTrue(searchResult.isDisplayed(), "Wrong Search Results are Displayed!");
			test.pass("Search Bar functionality verified successfully.");
		} catch (Exception e) {
			test.fail("Search Bar functionality verification failed: " + e.getMessage());
		}
	}
}
