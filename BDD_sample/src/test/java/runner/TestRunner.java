package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"StepDefinations", "Hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-report.html"
    },
    monochrome = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
