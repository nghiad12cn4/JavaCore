package org.example;

import static org.junit.Assert.assertTrue;

import PageObject.BookingHomePage;
import PageObject.BookingHomePageAndroid;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {

    BookingHomePageAndroid bookingHomePageAndroid;
    RemoteWebDriver driver;
    BookingHomePage bookingHomePage;
    String device = "window";

    @Before
    public void inIt() throws MalformedURLException {
        if (device.equals("window")) {
            inItWindow();
        } else {
            inItAndroid();
        }
    }


    public void inItAndroid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "H3AKGV920069PWZ");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("chrome.binary", "src/test/resources/chromedriver86.exe");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        this.driver = new RemoteWebDriver(url, capabilities);
        this.bookingHomePageAndroid = new BookingHomePageAndroid(this.driver);
        this.driver.get("https://www.booking.com/");
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.bookingHomePageAndroid.inIt();
    }

    public void inItWindow() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver87.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://www.booking.com/");
        this.bookingHomePage = new BookingHomePage(this.driver);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.bookingHomePage.inIt();
    }

    @Test
    public void Test() {
        if (device.equals("window")) {
            checkSearchBoxDestinationWeb();
        } else {
            checkSearchBoxDestinationAndroid();
        }
    }

    public void checkSearchBoxDestinationAndroid() {
        this.bookingHomePageAndroid.searchDestination.click();
        String input = "Hanoi";
        String expectedResultContain = input.toLowerCase();
        System.out.println(this.bookingHomePageAndroid.searchDestination.isDisplayed());
        this.bookingHomePageAndroid.searchDestination.sendKeys(expectedResultContain);
        this.bookingHomePageAndroid.inIt();
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, 15);
        webDriverWait.until(ExpectedConditions.visibilityOf(this.bookingHomePageAndroid.dropdownlistAfterClick));
        for (int i = 0; i < this.bookingHomePageAndroid.listItemDestination.size(); i++) {
            String stringOption = this.bookingHomePageAndroid.listItemDestination.get(i).getText().replaceAll("\\s+", "");//xoa tat ca cac ky tu khong nhin thay duoc
            String stringParse = StringUtils.stripAccents(stringOption);//xoa dau tieng viet
            String lowerCaseActual = stringParse.toLowerCase();
            Assert.assertTrue(lowerCaseActual.contains(expectedResultContain));
        }
    }

    public void checkSearchBoxDestinationWeb() {
        this.bookingHomePage.searchDestination.click();
        String input = "Hanoi";
        String expectedResultContain = input.toLowerCase();
        this.bookingHomePage.searchDestination.sendKeys(expectedResultContain);
        this.bookingHomePage.inIt();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < this.bookingHomePage.listItemDestination.size(); i++) {
            String stringOption = this.bookingHomePage.listItemDestination.get(i).getText().replaceAll("\\s+", "");//xoa tat ca cac ky tu khong nhin thay duoc
            String stringParse = StringUtils.stripAccents(stringOption);//xoa dau tieng viet
            String lowerCaseActual = stringParse.toLowerCase();
            Assert.assertTrue(lowerCaseActual.contains(expectedResultContain));
        }
    }


    @After
    public void afterTest() throws InterruptedException {
        driver.quit();
    }

}
