package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Cucumber/Feature",
   
   glue = { "stepdefinition"}
   )
public class Test_runner {
}