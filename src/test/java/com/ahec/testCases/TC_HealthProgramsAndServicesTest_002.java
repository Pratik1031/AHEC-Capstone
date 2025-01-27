package com.ahec.testCases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_HealthProgramsAndServicesTest_002 extends BaseClass {

	@Test(priority = 1)
	public void testVerifyCommunityBasedStudentEducation() {
		test.info("Starting testVerifyCommunityBasedStudentEducation");
		try {
			WebElement services = driver.findElement(By.id("menu-item-331"));
			services.click();
			test.info("Clicked on Services menu item");

			WebElement communityBasedStudentEducation = driver
					.findElement(By.xpath("//a[span[text()='Community Based Student Education and Training']]"));
			Actions a = new Actions(driver);
			a.moveToElement(communityBasedStudentEducation).click().build().perform();
			test.pass("Navigated to Community Based Student Education and Training");
			driver.navigate().back();
		} catch (Exception e) {
			test.fail("Failed in testVerifyCommunityBasedStudentEducation: " + e.getMessage());
			captureScreenshot("testVerifyCommunityBasedStudentEducation");
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void testVerifyContinuingEducationService() {
		test.info("Starting testVerifyContinuingEducationService");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement services = driver.findElement(By.id("menu-item-331"));
			services.click();
			test.info("Clicked on Services menu item");

			WebElement continuingEducationService = driver
					.findElement(By.xpath("//a[span[text()='Continuing Education Services']]"));
			wait.until(ExpectedConditions.elementToBeClickable(continuingEducationService));
			continuingEducationService.click();
			test.pass("Navigated to Continuing Education Services");
			driver.navigate().back();
		} catch (Exception e) {
			test.fail("Failed in testVerifyContinuingEducationService: " + e.getMessage());
			captureScreenshot("testVerifyContinuingEducationService");
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void testVerifyCoveringFlorida() {
		test.info("Starting testVerifyCoveringFlorida");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement programs = driver.findElement(By.linkText("PROGRAMS"));
			programs.click();
			test.info("Clicked on Programs menu item");

			WebElement coveringFlorida = driver
					.findElement(By.xpath("(//a[@href='https://westfloridaahec.org/navigators/'])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(coveringFlorida));
			Actions a = new Actions(driver);
			a.moveToElement(coveringFlorida).click().build().perform();
			test.pass("Clicked on Covering Florida link");

			String URL = driver.getCurrentUrl();
			String expectedURL = "https://westfloridaahec.org/navigators/";
			Assert.assertEquals(URL, expectedURL, "You Navigated to the Wrong Page!");
			test.pass("Navigated Correctly to Covering Florida Page: " + URL);
			driver.navigate().back();
		} catch (Exception e) {
			test.fail("Failed in testVerifyCoveringFlorida: " + e.getMessage());
			captureScreenshot("testVerifyCoveringFlorida");
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 4)
	public void testVerifyTobacco() {
		test.info("Starting testVerifyTobacco");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement programs = driver.findElement(By.linkText("PROGRAMS"));
			programs.click();
			test.info("Clicked on Programs menu item");

			WebElement tobacco = driver.findElement(By.xpath("//*[@id='menu-item-344']/a"));
			wait.until(ExpectedConditions.elementToBeClickable(tobacco));
			Actions actions = new Actions(driver);
			actions.moveToElement(tobacco).click().build().perform();
			test.pass("Clicked on Tobacco link");

			String currentURL = driver.getCurrentUrl();
			String expectedURL = "https://westfloridaahec.org/tobacco/";
			Assert.assertTrue(currentURL.equals(expectedURL), "You navigated to the wrong page!");
			test.pass("Navigated correctly to the Tobacco page: " + currentURL);
			driver.navigate().back();
		} catch (Exception e) {
			test.fail("Failed in testVerifyTobacco: " + e.getMessage());
			captureScreenshot("testVerifyTobacco");
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 5)
	public void testVerifyAhecScholar() {
		test.info("Starting testVerifyAhecScholar");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement programs = driver.findElement(By.linkText("PROGRAMS"));
			programs.click();
			test.info("Clicked on Programs menu item");

			WebElement AhecScholar = driver
					.findElement(By.xpath("(//a[@href='https://westfloridaahec.org/ahec-scholars/'])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(AhecScholar));
			Actions a = new Actions(driver);
			a.moveToElement(AhecScholar).click().build().perform();
			test.pass("Clicked on AHEC Scholars link");

			String URL = driver.getCurrentUrl();
			String expectedURL = "https://westfloridaahec.org/ahec-scholars/";
			Assert.assertEquals(URL, expectedURL, "You Navigated to the Wrong Page!");
			test.pass("Navigated Correctly to AHEC Scholars Page: " + URL);
			driver.navigate().back();
		} catch (Exception e) {
			test.fail("Failed in testVerifyAhecScholar: " + e.getMessage());
			captureScreenshot("testVerifyAhecScholar");
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 6)
	public void testVerifyHealthyAgeing() {
		test.info("Starting testVerifyHealthyAgeing");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement programs = driver.findElement(By.linkText("PROGRAMS"));
			programs.click();
			test.info("Clicked on Programs menu item");

			WebElement healthyAgeing = driver.findElement(By.xpath("//*[@id=\"menu-item-534\"]/a"));
			wait.until(ExpectedConditions.elementToBeClickable(healthyAgeing));
			Actions a = new Actions(driver);
			a.moveToElement(healthyAgeing).click().build().perform();
			test.pass("Clicked on Healthy Ageing link");

			String URL = driver.getCurrentUrl();
			String expectedURL = "https://westfloridaahec.org/healthy-aging/";
			Assert.assertEquals(URL, expectedURL, "You Navigated to the Wrong Page!");
			test.pass("Navigated Correctly to Healthy Ageing Page: " + URL);
			driver.navigate().back();
		} catch (Exception e) {
			test.fail("Failed in testVerifyHealthyAgeing: " + e.getMessage());
			captureScreenshot("testVerifyHealthyAgeing");
			Assert.fail(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 7 , enabled =  false)
	public void testEmbededVideo() {
		test.info("Test started: testEmbededVideo");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			// Navigate to Programs page
			WebElement programs = driver.findElement(By.linkText("PROGRAMS"));
			programs.click();
			test.info("Clicked on 'PROGRAMS' link.");

			WebElement AhecScholar = driver
					.findElement(By.xpath("(//a[@href='https://westfloridaahec.org/ahec-scholars/'])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(AhecScholar));
			Actions a = new Actions(driver);
			a.moveToElement(AhecScholar).click().build().perform();
			test.info("Navigated to AHEC Scholars page.");

			WebElement videoElement = driver.findElement(By.xpath("//video[contains(@preload, 'none')]"));
			Assert.assertTrue(videoElement.isDisplayed(), "Embedded video is not displayed.");
			test.info("Embedded video is displayed.");

			WebElement playButton = driver.findElement(By.xpath("//button[contains(@class, 'play-button')]"));
			playButton.click();
			test.info("Clicked on play button to start the video.");

			// Wait for the video to play
			WebDriverWait videoWait = new WebDriverWait(driver, Duration.ofSeconds(5));
			videoWait.until(ExpectedConditions.attributeContains(videoElement, "paused", "false"));

			Assert.assertTrue(videoElement.getAttribute("paused").equals("false"), "Video is not playing.");
			test.info("Video is playing successfully.");
		} catch (Exception e) {
			captureScreenshot("testEmbededVideo");
			test.fail("Error occurred while testing embedded video: " + e.getMessage());
			Assert.fail("Embedded video test failed.");
		}

		test.info("Test completed: testEmbededVideo");
	}

}
