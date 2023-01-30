package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Features/Login.feature"},
        plugin={"pretty","html:reports/SwagLabsReport.html"},
        glue = "stepDefinitions",
        monochrome = true,
        dryRun=false,
        tags="@sanity"
)
public class TestNG_Runner{

}
