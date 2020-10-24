package org.example;

import static org.junit.Assert.assertTrue;

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
//        WebDriverWait wait = new WebDriverWait(webDriver, 15);
//        WebElement popupFirst = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("desktop windows chrome ver- modal-open xs portrait narrow"))); //webDriver.findElement(By.cssSelector("div.fade"));
        this.webDriver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
        Set<String> lstHander = this.webDriver.getWindowHandles();
        for (String handle : lstHander) {
            this.webDriver.switchTo().window(handle);
        }

        //System.out.println(popupFirst.getTagName());
        //WebElement Xicon = popupFirst.findElement(By.cssSelector("span.ute-icon-circle-x"));
        WebElement Xicon = webDriver.findElement(By.cssSelector("span.ute-icon-circle-x"));
        System.out.println(Xicon.isDisplayed());
        Xicon.click();
        Actions action = new Actions(webDriver);
        action.moveToElement(Xicon);
        action.click(Xicon);
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        Boolean popupFirst = wait.until(ExpectedConditions.invisibilityOf(Xicon)); //webDriver.findElement(By.cssSelector("div.fade"));
        WebElement linkSignIn = webDriver.findElement(By.cssSelector("li.stateActive span.acs-brdr"));
        linkSignIn.click();
        Thread.sleep(5000);
        Set<String> lstHander2 = this.webDriver.getWindowHandles();
        for (String handle2 : lstHander2) {
            this.webDriver.switchTo().window(handle2);
        }
        WebElement username = webDriver.findElement(By.name("email"));
        username.sendKeys("nghiad12cn4@gmail.com");
        WebElement password = webDriver.findElement(By.name("password"));
        password.sendKeys("leducnghia");
        WebElement showicon = webDriver.findElement(By.cssSelector("button[title=\"Show password entered\"]"));
        showicon.click();
        System.out.println(password.getText());
        //WebElement loginButton = webDriver.findElement(By.cssSelector("button.state-btn"));

        //webDriver.quit();
    }

    @Test
    public void shouldAnswerWithTrue() {

    }

    @After
    public void quitDriver() {
        webDriver.quit();
    }

}
