package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:targer/report.html"}, glue = "logindefination",
        features = "src/test/resources/loginfeature"
)
//glue chi dinh toi package chua Defination
public class RunCucumberTest {

}
