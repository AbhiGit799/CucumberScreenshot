package cucmberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    @CucumberOptions(
            features = "src/test/java/features/UserOpenChrome.feature",
            glue = "stepDefinitions",
            monochrome = true,
            plugin = {"html:target/cucumber.html","json:target/cucumber.json"},
            tags = "@First or @Learning"
    )
    public class TestRunner extends AbstractTestNGCucumberTests {
    }


