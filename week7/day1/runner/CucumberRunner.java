package assignments.week7.day1.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/main/java/assignments/week7/day1/features"} // to execute all feature files in a package, use path of package alone Eg:/src/test/java/features/
					, glue="assignments.week7.day1.steps"				//to map step definition package to runner
					, monochrome = true 		//used to remove unreadable characters/details in console
					, publish = true)			//to publish Cucumber report in console
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
