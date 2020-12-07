package test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {
    static WebDriver driver;

    @Before
    public WebDriver inIt() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver2.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        return driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "error");
        }
        driver.quit();
    }
}
