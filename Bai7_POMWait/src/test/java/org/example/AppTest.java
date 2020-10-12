package org.example;

import static org.junit.Assert.assertTrue;

import PageObject.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
        //implicit wait - mot dang wait cua selenium voi muc dich cho cho 1 page load xong (dau hieu reload lai page)
        this.loginPage = new LoginPage(this.driver);
        // WebElement linkDangNhap = this.driver.findElement(By.cssSelector("div[id=\"anonLogin\"] a"));
        // linkDangNhap.click();
        this.loginPage.linkDangNhap.click();
        WebDriverWait waitRedirect = new WebDriverWait(this.driver, 15);
        WebElement txtUsername = waitRedirect.until(ExpectedConditions.visibilityOf(this.loginPage.txtUsername));

        //this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Cho toi da 10s de page load, reload roi thi action luon

    }

    @Test
    public void shouldAnswerWithTrue() {
        //WebElement txtUsername = this.driver.findElement(By.cssSelector("div.mod-login-input-loginName input"));
        this.loginPage.txtUsername.sendKeys("ducnghiasp@gmail.com");
        this.loginPage.txtPassword.sendKeys("Kenh14.vn");
        //WebElement txtPassword = this.driver.findElement(By.cssSelector("input[type=password]"));
        //WebElement btnLogin = this.driver.findElement(By.cssSelector("button[type=submit]"));
        //txtUsername.sendKeys("ducnghiasp@gmail.com");
        //txtPassword.sendKeys("Kenh14.vn");
        //btnLogin.click();
        WebDriverWait waitRedirect = new WebDriverWait(this.driver, 15);
        WebElement slider = waitRedirect.until(ExpectedConditions.visibilityOf(this.loginPage.slider));
        System.out.println(slider.getTagName());
        Assert.assertTrue(slider.isDisplayed());


    }

    @After
    public void quitDriver() {

        driver.quit();
    }

}
