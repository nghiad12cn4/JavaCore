package subscribestepdefination;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report.html"}, glue = "subscribestepdefination", features = "src/test/resources/feature")
public class RunCucumberTest {

}
