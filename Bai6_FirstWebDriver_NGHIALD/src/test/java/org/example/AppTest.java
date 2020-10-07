package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.gecko.driver", "F:\\Automation test\\WebDriver\\geckodriver.exe");
        System.out.println("Tesstt");
        this.driver = new FirefoxDriver();
    }

    @Test
    public void Test() {
        this.driver.get("https://www.facebook.com/");
        System.out.println("Test");
        driver.manage().window().maximize();
        WebElement txtUsername = driver.findElement(By.name("email"));
        WebElement txtPassword = driver.findElement(By.name("pass"));
        WebElement btnSubmit = driver.findElement(By.name("login"));
        txtUsername.sendKeys("nghiad12cn4@gmail.com");
        txtPassword.sendKeys("Kenh14.vn");
        btnSubmit.sendKeys(Keys.ENTER);
        String actualResult = driver.getTitle();
        String expectedResult = "Facebook";
        Assert.assertFalse(actualResult.contains("-"));
        driver.close();
    }

    @After
    public void afterTest() {
        //driver.close();
    }


}
