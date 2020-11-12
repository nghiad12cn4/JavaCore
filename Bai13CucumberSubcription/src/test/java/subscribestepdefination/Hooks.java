package subscribestepdefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    static WebDriver webDriver;

    @Before
    public void inIt() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
    }

    @After
    public void afterTest(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) this.webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "error");
        }
        this.webDriver.quit();
    }
}

