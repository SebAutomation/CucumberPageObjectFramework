package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.TestUtils;

public class Hooks {

    private TestUtils testUtils;

    public Hooks(TestUtils testUtils) {
        this.testUtils = testUtils;
    }

    @Before
    public void setUp() {
        testUtils.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        testUtils.screenshotInCaseOfFailure(scenario);
        testUtils.closeBrowser();
    }
}


