package TEST_RUNNER_FIREFOX;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/main/resources/features/b.feature",glue="STEP_DEF_FIREFOX")

public class Test_Runner extends AbstractTestNGCucumberTests {
}
