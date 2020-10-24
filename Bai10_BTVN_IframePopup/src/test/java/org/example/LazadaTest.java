package org.example;

import org.junit.After;
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

public class LazadaTest {
    WebDriver webDriver;

    @Before
    public void inIt() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.webDriver = new ChromeDriver();

        //WebElement loginButton = webDriver.findElement(By.cssSelector("button.state-btn"));

        //webDriver.quit();
    }

    @Test
    public void shouldAnswerWithTrue() {
        this.webDriver.get("https://www.lazada.vn/");
//        WebDriverWait wait = new WebDriverWait(webDriver, 15);
//        WebElement popupFirst = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("desktop windows chrome ver- modal-open xs portrait narrow"))); //webDriver.findElement(By.cssSelector("div.fade"));
        this.webDriver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
        WebElement dangNhapButton = this.webDriver.findElement(By.id("anonLogin"));
        dangNhapButton.click();
        this.webDriver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
        WebElement facebookButton = this.webDriver.findElement(By.cssSelector("button.mod-third-party-login-fb"));
        facebookButton.click();
        Set<String> lstHander = this.webDriver.getWindowHandles();
        for (String handle : lstHander) {
            this.webDriver.switchTo().window(handle);
        }

        //System.out.println(popupFirst.getTagName());
        //WebElement Xicon = popupFirst.findElement(By.cssSelector("span.ute-icon-circle-x"));
        WebElement user = webDriver.findElement(By.id("email"));
        WebElement pass = webDriver.findElement(By.id("pass"));
        user.sendKeys("nghia");
        pass.sendKeys("134234");
    }

    @After
    public void quitDriver() {
        webDriver.quit();
    }

}

