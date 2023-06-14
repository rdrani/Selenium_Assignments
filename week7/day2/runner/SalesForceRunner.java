package assignments.week7.day2.runner;

import assignments.week7.day2.steps.BaseClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/assignments/week7/day2/features"
					, glue = "assignments.week7.day2.steps"
					, publish = true
					, monochrome = true
//					, dryRun = true 
//					, tags = "@Sanity or @Unit"
					)
public class SalesForceRunner extends BaseClass{

}
