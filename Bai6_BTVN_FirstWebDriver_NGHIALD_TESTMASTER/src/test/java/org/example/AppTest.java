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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        this.driver.get("http://testmaster.vn/Account/Login?ReturnUrl=%2fadmin");
        System.out.println("Test");
        driver.manage().window().maximize();
        WebElement txtUsername = driver.findElement(By.xpath("//body/div[1]/div[3]/input[1]"));
        WebElement txtPassword = driver.findElement(By.xpath("//body/div[1]/div[4]/input[1]"));
        WebElement btnSubmit = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[6]/button[1]"));
        txtUsername.sendKeys("autotestotp@gmail.com");
        txtPassword.sendKeys("abc123");
        btnSubmit.sendKeys(Keys.ENTER);
        String content = driver.findElement(By.tagName("body")).getText();
        WebDriverWait wait = new WebDriverWait(driver, 10); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/div[3]/input[1]")));
        //doi den khi hien thi Chuoi Verify code
        Boolean expectedResult = driver.findElement(By.xpath("//body/div[2]/div[3]/input[1]")).isDisplayed();
        Boolean actualResult = true;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @After
    public void afterTest() {
       // driver.close();
        //driver.quit();
        //Khong hieu sao co ham nay lai loi?
    }


}
