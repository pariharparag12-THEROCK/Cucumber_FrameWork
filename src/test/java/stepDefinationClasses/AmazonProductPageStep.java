package stepDefinationClasses;

import org.testng.Assert;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonProductPage;
import qa.DriverFactory;

public class AmazonProductPageStep {
	
	
	
	AmazonProductPage productpage = new AmazonProductPage(DriverFactory.getDriver());
	
	
	/*
	 * @Given("Given user must be on the homepage") public void
	 * given_user_must_be_on_the_homepage() { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

	@When("user clicks on cart icon")
	public void user_clicks_on_cart_icon() {
		
		productpage.clickOnCarticon();
	   
	}

	@When("user clicks on SignInToYourAccount button")
	public void user_clicks_on_sign_in_to_your_account_button() {
		productpage.clickOnSignInToYourAccountButton();
	}


	@Then("user should be navigated to SignIn window")
	public void user_should_be_navigated_to_sign_in_window() {
		
			String title =	productpage.navigateToSignInWindow();
			
			boolean IsPresent = title.contains("Amazon Sign In");
			
			
			Assert.assertEquals(IsPresent, true);
	}
}
