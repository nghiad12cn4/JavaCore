package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;

    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "ANDROID");
        cap.setCapability("deviceName", "H3AKGV920069PWZ");
        cap.setCapability("appPackage", "com.asus.calculator");
        cap.setCapability("appActivity", "com.asus.calculator.Calculator");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement nine = driver.findElement(By.id("com.asus.calculator:id/digit9"));
        WebElement six = driver.findElement(By.id("com.asus.calculator:id/digit6"));
        WebElement operatorPlus = driver.findElement(By.id("com.asus.calculator:id/plus"));
        WebElement operatorEqual = driver.findElement(By.id("com.asus.calculator:id/equal"));
        WebElement resultNumber = driver.findElement(By.id("com.asus.calculator:id/resultEditTextID"));
        nine.click();
        operatorPlus.click();
        six.click();
        operatorEqual.click();
        assertEquals("15", resultNumber.getText());
    }
}
