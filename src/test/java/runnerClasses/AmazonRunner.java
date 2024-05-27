package runnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


				@CucumberOptions(
						
						
						//features = {"@target\\failed.txt"},
						
						features = {"src\\test\\resources\\featureFiles"},
						
						glue = {"stepDefinationClasses", "hooks"},
						
						publish = true,
						
						plugin = {"pretty", "html:target/CUCUMBER-REPORTS/AmazonTestResult.html", "rerun:target/failed.txt"}
						
						
				)
			
				
public class AmazonRunner extends AbstractTestNGCucumberTests{

}
