package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    //Khi mở popup login lên thì focus set vào username, khi login với username rỗng -> focus vào username, password rỗng -> focus vào password
    //Anh em thử tìm idea để check vấn đề này nha, khi nhập password thì nó sẽ secure ko show, làm sao check content sẽ hiển thị khi nhấn vào nút show password
    /**
     * Rigorous Test :-)
     */
    WebDriver webDriver;

    @Before
    public void inIt() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.webDriver = new ChromeDriver();
        this.webDriver.get("https://www.fido.ca/pages/#/easylogin/main");
        this.webDriver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
        this.webDriver.manage().window().maximize();
        openPageSignIn();
    }

    public void openPageSignIn() {
        WebElement Xicon = webDriver.findElement(By.cssSelector("span.ute-icon-circle-x"));
        System.out.println(Xicon.isDisplayed());
        Xicon.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        Boolean popupFirst = wait.until(ExpectedConditions.invisibilityOf(Xicon)); //webDriver.findElement(By.cssSelector("div.fade"));
        WebElement linkSignIn = webDriver.findElement(By.cssSelector("li.stateActive span.acs-brdr"));
        linkSignIn.click();
    }


    @Test
    public void openPopupCheckActive() {
        this.webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe[src=\"/pages/easylogin-fido/signin/en/\"]")));
        WebElement tbUserName = this.webDriver.findElement(By.id("username"));
        WebElement tbPassword = this.webDriver.findElement(By.id("password"));
        WebElement buttonLogin = this.webDriver.findElement(By.cssSelector("button.state-btn"));
        WebElement focusUsername = this.webDriver.switchTo().activeElement();
        Assert.assertEquals(tbUserName, focusUsername);
    }

    @Test
    public void activeLeaveBlankUserPass() {
        this.webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe[src=\"/pages/easylogin-fido/signin/en/\"]")));
        WebElement tbUserName = this.webDriver.findElement(By.id("username"));
        WebElement tbPassword = this.webDriver.findElement(By.id("password"));
        WebElement buttonLogin = this.webDriver.findElement(By.cssSelector("button.state-btn"));
        tbUserName.sendKeys("");
        tbPassword.sendKeys("");
        buttonLogin.click();
        WebElement focusUsername = this.webDriver.switchTo().activeElement();
        Assert.assertEquals(tbUserName, focusUsername);
    }

    @Test
    public void showPassword() throws InterruptedException {
        this.webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe[src=\"/pages/easylogin-fido/signin/en/\"]")));
        WebElement tbUserName = this.webDriver.findElement(By.id("username"));
        WebElement tbPassword = this.webDriver.findElement(By.id("password"));
        WebElement buttonLogin = this.webDriver.findElement(By.cssSelector("button.state-btn"));
        WebElement buttonShowPass = this.webDriver.findElement(By.cssSelector("button[title=\"Show password entered\"]"));
        tbUserName.sendKeys("nghiad12cn4@gmail.com");
        tbPassword.sendKeys("nghia989899");
        buttonShowPass.click();
        String actualPassword = "nghia989899";
        String passWordExpected = tbPassword.getAttribute("value");
        assertEquals(passWordExpected, actualPassword);
    }

    @After
    public void quitDriver() {
        webDriver.quit();
    }

}
