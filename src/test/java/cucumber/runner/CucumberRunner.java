package cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/cucumber/features", glue = "cucumber/stepdefinitions", stepNotifications = true)
public class CucumberRunner extends AbstractTestNGCucumberTests
{

}
