package com.ahecBDD.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/features",
		glue = "com.ahecBDD.stepDefinitions",
		plugin = {"pretty","html:cucumber-reports.html"},
		monochrome= true
		)
public class testRunner {

}
