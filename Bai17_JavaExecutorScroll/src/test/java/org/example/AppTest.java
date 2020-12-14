package org.example;

import static org.junit.Assert.assertTrue;

import PageObject.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;
    LoginPage loginPage;

    /**
     * Rigorous Test :-)
     */
    @Before
    public void inIt() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Webdrivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://www.lazada.vn/");
        this.loginPage = new LoginPage(this.driver);
        this.driver.manage().window().maximize();
        this.loginPage.signUpLink.click();
        this.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void shouldAnswerWithTrue() {
        this.loginPage.dayDropdownList.click();
        WebElement element31 = driver.findElement(By.cssSelector("ul.next-menu-content li[value='31']"));
        element31.click();
    }

    @Test
    public void shouldAnswerWithTrue2() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        this.loginPage.dayDropdownList.click();
        WebElement element31 = driver.findElement(By.cssSelector("ul.next-menu-content li[value='31']"));
        je.executeScript("arguments[0].scrollIntoView(true);", element31);
        je.executeScript("arguments[0].click();", element31);
    }

    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
