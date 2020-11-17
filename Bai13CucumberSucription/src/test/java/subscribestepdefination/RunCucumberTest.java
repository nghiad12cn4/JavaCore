package subscribestepdefination;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report.html"}, glue = "subscribestepdefination", features = "src/test/resources/feature")
public class RunCucumberTest {
//QUIZ: 1. get color sao luc ra the no luc ra the kia
    //2. Co che sinh gherkin
    //3. truyen gia tri "" vao when getText ra cung co dau "" => Solution
}
