package com.qa.cucmberbdd.stepdef;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class Stepdefination {


	WebDriver driver;
	WebDriverWait wait;

	// Given User open the browser
	@Given("User open the browser")
	public void user_open_the_browser() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
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

	// And User clicks on signin button
	@Given("User clicks on signin button")
	public void user_clicks_on_signin_button() {
		WebElement signInButton = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		signInButton.click();
	}

	// When User enter his registered "usertest123@gmail.com"
	@When("User enter his registered {string}")
	public void user_enter_his_registered(String string) {
		WebElement userEmailIdField = driver.findElement(By.id("email"));
		wait.until(ExpectedConditions.visibilityOf(userEmailIdField));
		userEmailIdField.sendKeys("usertest123@gmail.com");
	}

	// And User enters his password "John123!"
	@When("User enters his password {string}")
	public void user_enters_his_password(String string) {
		WebElement userPasswordField = driver.findElement(By.id("passwd"));
		wait.until(ExpectedConditions.visibilityOf(userPasswordField));
		userPasswordField.sendKeys("John123!");
	}
	
	// And User clicks on signin button
	@When("And User clicks on signin button")
	public void And_User_clicks_on_signin_button() {
		WebElement signinButton = driver.findElement(By.id("SubmitLogin"));
		signinButton.click();
	}

	// Then User first and last name is displayed as "John Patric" in top right corner
	@Then("User first and last name is displayed as {string} in top right corner")
	public void user_first_and_last_name_is_displayed_as_in_top_right_corner(String userFirstNamenLastName) {
		wait.until(ExpectedConditions.titleIs("My account - My Store"));
		WebElement userFirstNameLastName = driver.findElement(By.xpath("//a[@title='View my customer account']/span"));
		Assert.assertEquals("User name is not matching user the given one",userFirstNamenLastName,userFirstNameLastName.getText());	
	}
	
	// And User is on the next page where title is "My Store"
	@Given("User is on the next page where title is {string}")
	public void user_is_on_the_next_page_where_title_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	// Then User is able to see the main categories
	//	| WOMEN 	|
	// 	| DRESSES	|
	//  | T-SHIRTS 	|
	@Then("User is able to see the main categories")
	// public void user_is_able_to_see_the_main_categories(io.cucumber.datatable.DataTable dataTable)
	public void user_is_able_to_see_the_main_categories(List<String> mainCategories) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	   
		List<String> mainCatogiesList = mainCategories;
		List<WebElement> actualMainCategoriesList = driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li"));
		for (int i = 0; i < mainCatogiesList.size(); i++) {
			Assert.assertEquals(mainCatogiesList.get(i), actualMainCategoriesList.get(i).getText());
		}
		
	}
	
	// When User Search for product "<product_name>"
	@When("User Search for product {string}")
	public void user_search_for_product(String productName) {
		WebElement searchBoxElement = driver.findElement(By.id("search_query_top"));
		wait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
		searchBoxElement.sendKeys(productName);
		WebElement searchButtonElement = driver.findElement(By.name("submit_search"));
		searchButtonElement.click();
		
	    
	}

	// Then Search Result page is displayed
	@Then("Search Result page is displayed")
	public void search_result_page_is_displayed() {
	   List<WebElement> productContainers = driver.findElements(By.xpath("//div[@class='product-container']"));
	   for (int i = 0; i < productContainers.size(); i++) {
		   Assert.assertTrue(productContainers.get(i).isDisplayed());
	   }
	}

}
