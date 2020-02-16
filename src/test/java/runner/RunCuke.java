package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.Test;


@CucumberOptions(
        plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        features = {"src/test/resources/features"},
        monochrome = true,
        glue = "steps",
        tags = {"@Search-Cars"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        snippets = SnippetType.CAMELCASE)

public class RunCuke extends BaseRunner{
    @Test(groups = "cucumber", description = "Runs Cucumber All Feature", dataProvider = "features")
    public void runTests(CucumberFeatureWrapper cucumberFeatureWrapper) {

        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }
}
