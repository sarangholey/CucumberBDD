package com.qa.cucmberbdd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
		(
			features = "classpath:features"	,//to tell cucumber where is your feature file are...
			glue = "com.qa.cucmberbdd.stepdef", // to tell cucumber where is your step definition code reside in the framework......
			tags = "@search",
			plugin = {"pretty", // to generate reports
				      "html:target/html/htmlreport.html",
				      "json:target/json/file.json"
				     },
			monochrome = true,
			dryRun = false // to tell whether to test run(true) or actual run(false)
			
			
				
		)
public class TestRunner {

}
