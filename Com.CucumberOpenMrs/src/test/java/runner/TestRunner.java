package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ".\\features", glue = "stepDef",
plugin = {"json:target/cucumber.json", "html:target/cucumber-reports"})
public class TestRunner extends AbstractTestNGCucumberTests
{

}
