package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.DriverFactory;

public class AmazonHooks {

	WebDriver driver;
	
	@Before
	public void launchBrowser()   {
		
		
		DriverFactory df = new DriverFactory();
		
		driver =	df.initBrowser("chrome");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@After (order = 2)
	public void tearDown(Scenario scenario) {
		
			boolean hasFailed =	scenario.isFailed();
			
			if (hasFailed==true) {
			
				String ScenarioName = scenario.getName();
				
				String	ScenarioWithoutSpace	=	ScenarioName.replace(" ", "_");
				
				TakesScreenshot ts = (TakesScreenshot)driver;
				
				byte source[] = ts.getScreenshotAs(OutputType.BYTES);
				
				scenario.attach(source, "image/png", ScenarioWithoutSpace);
				
			}
			
		
	}
	
	
	
	@After(order =1)
	public void closedBrowser() {
		driver.quit();
	}
	
	
	
	
}
