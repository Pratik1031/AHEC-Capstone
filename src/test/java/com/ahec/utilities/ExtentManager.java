package com.ahec.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			createInstance("extent-report.html");
		}
		return extent;
	}

	private static ExtentReports createInstance(String filePath) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setReportName("Test Execution Report");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Tester", "Pratik Dahekar");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "Chrome");

		return extent;
	}
}
