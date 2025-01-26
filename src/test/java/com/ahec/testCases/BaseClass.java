package com.ahec.testCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ahec.utilities.ExtentManager;
import com.ahec.utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {

	ReadConfig read = new ReadConfig();

	protected WebDriver driver;
	protected static Logger logger;
	protected static ExtentReports extent;
	protected ExtentTest test;

	public String baseURL = read.getApplicationURL();
	public String username = read.getUsername();
	public String password = read.getPassword();

	@BeforeSuite
	public void setUpExtent() {
		extent = ExtentManager.getInstance();
		if (extent == null) {
			throw new IllegalStateException("ExtentReports instance was not initialized correctly.");
		}
		System.out.println("ExtentReports initialized.");
	}

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		logger = Logger.getLogger("ahec");
		PropertyConfigurator.configure("Log4j.properties");

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		driver.get(baseURL);
		driver.manage().window().maximize();

		logger.info("Browser initialized: " + browser);
	}

	@BeforeMethod
	public void setupTest(Method method) {
		if (extent == null) {
			throw new IllegalStateException("ExtentReports is not initialized. Ensure @BeforeSuite runs correctly.");
		}
		test = extent.createTest(method.getName());
		logger.info("Starting test: " + method.getName());
	}

	@AfterMethod
	public void logTestStatus(ITestResult result) {
		if (test == null) {
			logger.error("ExtentTest is null. Skipping status logging.");
			return;
		}

		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			test.pass("Test Passed");
			logger.info("Test Passed: " + result.getName());
			break;
		case ITestResult.FAILURE:
			test.fail("Test Failed: " + result.getThrowable());
			logger.error("Test Failed: " + result.getName(), result.getThrowable());
			break;
		case ITestResult.SKIP:
			test.skip("Test Skipped: " + result.getThrowable());
			logger.warn("Test Skipped: " + result.getName());
			break;
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			logger.info("Browser session ended.");
		}
	}

	@AfterSuite
	public void tearDownExtent() {
		if (extent != null) {
			extent.flush();
			System.out.println("ExtentReports flushed.");
		}
	}

	public void captureScreenshot(String testName) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./screenshots/" + testName + ".png"));
			test.info("Screenshot captured: " + testName);
		} catch (IOException e) {
			test.fail("Failed to capture screenshot: " + e.getMessage());
		}
	}
}
