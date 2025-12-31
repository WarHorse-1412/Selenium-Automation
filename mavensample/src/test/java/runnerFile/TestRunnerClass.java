package runnerFile;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//the below annotation is used to configure cucumber connectivity
@CucumberOptions(
		//Attributes to configure cucumber connectivity
		features = "src/test/resources/Feature", // Path to your feature files
	    glue = "stepDefinition",    // Package where your step definitions are located
	    plugin = { "pretty",
	            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"   }, // Reporting options
	    monochrome = true,       // Readable console output
	    publish = true,
	    tags = "@LoginPage",
	    dryRun = false
	    )

public class TestRunnerClass extends AbstractTestNGCucumberTests{
	


}
