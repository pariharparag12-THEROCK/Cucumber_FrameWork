package stepDefinationClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHomePage;
import qa.DriverFactory;

public class AmazonHomePageStep {
	
	WebDriver driver;

	//AmazonHomePage homepage = new AmazonHomePage(driver);
	
	AmazonHomePage homepage = new AmazonHomePage(DriverFactory.getDriver());
	
	@Given("user must be on the homepage")
	public void user_must_be_on_the_homepage() throws InterruptedException {
		
		driver = DriverFactory.getDriver();
		Thread.sleep(3000);
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		
	}

	@Then("Page Tiltle should contain {string}")
	public void page_tiltle_should_contain(String string) {
	   
		String Title =	homepage.fetchTitle();
		
		boolean IsPresent =	Title.contains(string);
		
		Assert.assertEquals(IsPresent, true);
		
	}

	@Then("Cart icon should get displayed to user")
	public void cart_icon_should_get_displayed_to_user() {
		boolean isDisplayed =	homepage.CartIcon();
		Assert.assertTrue(isDisplayed);
	}

	@When("user search {string} in the search field")
	public void user_search_in_the_search_field(String string) {
		homepage.searchProduct(string);
	}

	
	  @Then("user should see the mobiles") public void
	  user_should_see_the_mobiles() { String title = driver.getTitle(); boolean
	  IsPresent = title.contains("Amazon.in : mobile");
	  
	  Assert.assertEquals(IsPresent, true); 
	  //AssertTrue(IsPresent); 
	  
	  }
	 

	@When("user clicks on mobile")
	public void user_clicks_on_mobile() {
	   homepage.clickOnMobile();
	}

	
	  @Then("user should be navigated to mobile page") public void
	  user_should_be_navigated_to_mobile_page() { String mobilePageTitle =
	  homepage.getTitleMobilePage(); boolean IsPresent =
	  mobilePageTitle.contains("Samsung Galaxy M14 5G");
	  Assert.assertEquals(IsPresent, true); }
	 
}
