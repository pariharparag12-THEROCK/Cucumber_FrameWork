package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductPage {

	
	WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath ="//a[@id='nav-cart']")
	private WebElement carticon;
	
	@FindBy (xpath = "//span[contains(text(),'Sign in to your account')]/parent::a")
	private WebElement SignInToYourAccountButton;
	
	
	public AmazonProductPage(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnCarticon() {
		wait.until(ExpectedConditions.elementToBeClickable(carticon));
		carticon.click();
		
	}
	
	
	public void clickOnSignInToYourAccountButton() {
		wait.until(ExpectedConditions.elementToBeClickable(SignInToYourAccountButton));
		SignInToYourAccountButton.click();
		
	}
	
	public String navigateToSignInWindow() {
		
		String title = driver.getTitle();
		
		return title;	
	}
	
	
	
	
}
