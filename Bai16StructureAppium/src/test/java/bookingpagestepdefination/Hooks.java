package bookingpagestepdefination;

import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    public static String browserName = System.getProperty("browser", "chrome");

    static WebDriver webDriver = null;
    static RemoteWebDriver remoteWebDriver = null;

    @Before
    public void inIt() throws MalformedURLException {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            this.webDriver = new ChromeDriver();
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "H3AKGV920069PWZ");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            capabilities.setCapability("chrome.binary", "src/test/resources/chromedriver86.exe");
            URL url = new URL("http://0.0.0.0:4723/wd/hub");
            this.remoteWebDriver = new RemoteWebDriver(url, capabilities);
        }
    }

    @After
    public void afterTest(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) this.webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "error");
        }
        if (browserName.equalsIgnoreCase("chrome")) {
            this.webDriver.quit();
        } else {
            this.remoteWebDriver.quit();
        }

    }
}
