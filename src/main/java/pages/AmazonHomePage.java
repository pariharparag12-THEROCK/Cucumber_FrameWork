package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
	
	 WebDriver driver;
	 
	 private WebDriverWait wait;
	 
	 @FindBy (xpath = "//a[@id='nav-cart']")
	 private WebElement carticon;
	 
	 @FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	 private WebElement searchTextField;
	 
	 @FindBy (xpath = "//input[@id='nav-search-submit-button']")
	 private WebElement searchBoxIcon;
	 
	 @FindBy (xpath = "//span[contains(text(),'Samsung Galaxy M14 5G (ICY Silver,')]/parent::a")
	 private WebElement samsungmobile;
	 
	
	public AmazonHomePage(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public String fetchTitle() {
		
		String Title = driver.getTitle();
		return Title;
	}
	
	
	public boolean CartIcon() {
		
		wait.until(ExpectedConditions.elementToBeClickable(carticon));	
		boolean isDisplayed = carticon.isDisplayed();
		return isDisplayed;
			
	}
	
	
	public void searchProduct(String Product) {
		
		wait.until(ExpectedConditions.elementToBeClickable(searchTextField));
		searchTextField.sendKeys(Product);
		
		wait.until(ExpectedConditions.elementToBeClickable(searchBoxIcon));
		searchBoxIcon.click();
	}
	
	
	public void clickOnMobile() {
		wait.until(ExpectedConditions.elementToBeClickable(samsungmobile));
		samsungmobile.click();
	}
	
	
	public String getTitleMobilePage() {
		
			
			String mobilePageTitle ="";
		
		
			String p = driver.getWindowHandle();
			
			Set<String> pc = driver.getWindowHandles();
		
		
			for ( String  c : pc) {
				
					if (!c.equalsIgnoreCase(p)) {
						
						driver.switchTo().window(c);
						
						 mobilePageTitle = driver.getTitle();
						
						driver.close();
					}
					
					
				
				
			}
		
			driver.switchTo().window(p);
			
			
	
			return mobilePageTitle;
		
	}
	
	
}
