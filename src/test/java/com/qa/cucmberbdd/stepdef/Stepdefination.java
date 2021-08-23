package com.qa.cucmberbdd.stepdef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefination {
	
	
	WebDriver driver;
	
	// Given User open the browser
	@Given("User open the browser")
	public void user_open_the_browser() {
		driver = new ChromeDriver();
	}

	// And user maximize the browser
	@Given("user maximize the browser")
	public void user_maximize_the_browser() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	// When User open the Url "http://automationpractice.com/"
	@When("User open the Url {string}")
	public void user_open_the_url(String appUrl) {
	    driver.get(appUrl);
	}
	
	// Then User is gets redirected to "http://automationpractice.com/index.php"
	@Then("User is gets redirected to {string}")
	public void user_is_gets_redirected_to(String appExpectedUrl) {
		Assert.assertEquals("Url redirection is not as expected",appExpectedUrl, driver.getCurrentUrl());
	}
	
	// And User close the browser
	@Then("User close the browser")
	public void user_close_the_browser() {
	   driver.quit();
	}
	
	// Then User is able to see the app title "My Store"
	@Then("User is able to see the app title {string}")
	public void user_is_able_to_see_the_app_title(String appLandingPageTitle) {
		Assert.assertEquals("Page title is incorrect",appLandingPageTitle, driver.getTitle());
	}
	
	
	
	
	
	

}
