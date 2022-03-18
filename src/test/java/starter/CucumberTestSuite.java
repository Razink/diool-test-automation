package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        tags = "@TEST_DFQA-60"
)
public class CucumberTestSuite {

}
