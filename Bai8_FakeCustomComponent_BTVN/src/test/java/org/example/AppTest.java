package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;

    @Before
    public void inIt() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://www.booking.com/");

    }

    @Test
    public void checkSearchBoxDestination() {
        WebElement searchDestination = driver.findElement(By.cssSelector("input[type=search]"));
        searchDestination.click();
        String input = "Hanoi";
        String expectedResultContain = input.toLowerCase();
        searchDestination.sendKeys("hanoi");
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, 15);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("ul[role=listbox]"))));
        List<WebElement> elements = driver.findElements(By.cssSelector("li[role=option]"));
        for (int i = 0; i < elements.size(); i++) {
            String stringOption = elements.get(i).getText().replaceAll("\\s+", "");//xoa tat ca cac ky tu khong nhin thay duoc
            String lowerCaseActual = stringOption.toLowerCase();
            System.out.println(lowerCaseActual);
            Assert.assertTrue(lowerCaseActual.contains(expectedResultContain));
        }
    }

    @Test
    public void checkSearchCheckInCheckOut() throws InterruptedException {
        WebElement checkInCheckOut = driver.findElement(By.cssSelector("span[class=\"sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb\"]"));
        checkInCheckOut.click();
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, 15);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class=\"bui-calendar__month\"]"))));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime checkIn = LocalDateTime.now().plusDays(1);
        LocalDateTime checkOut = LocalDateTime.now().plusDays(3);
        String elementCheckIn = "td[data-date=\"" + dtf.format(checkIn) + "\"]";
        String elementCheckOut = "td[data-date=\"" + dtf.format(checkOut) + "\"]";
        WebElement checkInItem = driver.findElement(By.cssSelector(elementCheckIn));
        checkInItem.click();
        WebElement checkOutItem = driver.findElement(By.cssSelector(elementCheckOut));
        checkOutItem.click();
        //Cho cho toi khi khong tim thay chuoi check out (co nghia search da duoc chon)
        Thread.sleep(1000);
        //Hoi anh Khanh co cach nao khac sleep
        //So sanh voi ExpectedResult
        //Ngay hien tai 15
        String expectedResultCheckIn = "Oct 16";
        String expectedResultCheckOut = "Oct 18";
        WebElement webElementCheckOut = driver.findElement(By.cssSelector("div[data-placeholder=\"Check-out\"]"));
        WebElement webElementCheckIn = driver.findElement(By.cssSelector("div[data-placeholder=\"Check-in\"]"));
        Assert.assertTrue(webElementCheckIn.getText().trim().contains(expectedResultCheckIn));
        Assert.assertTrue(webElementCheckOut.getText().trim().contains(expectedResultCheckOut));
    }

    @Test
    public void checkInputAdultChildRoom() throws InterruptedException {
        WebElement componentAdultChildRoom = driver.findElement(By.cssSelector("span.xp__guests__count"));
        componentAdultChildRoom.click();
        //Doi den khi mo Popup
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, 15);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[aria-label=\"Decrease number of Adults\"]"))));
        WebElement buttonDecreaseAdults = driver.findElement(By.cssSelector("button[aria-label=\"Decrease number of Adults\"]"));
        WebElement buttonIncreaseAdults = driver.findElement(By.cssSelector("button[aria-label=\"Increase number of Adults\"]"));
        WebElement buttonDecreaseChildren = driver.findElement(By.cssSelector("button[aria-label=\"Decrease number of Children\"]"));
        WebElement buttonIncreaseChildren = driver.findElement(By.cssSelector("button[aria-label=\"Increase number of Children\"]"));
        WebElement buttonDecreaseRoom = driver.findElement(By.cssSelector("button[aria-label=\"Decrease number of Rooms\"]"));
        WebElement buttonIncreaseRoom = driver.findElement(By.cssSelector("button[aria-label=\"Increase number of Rooms\"]"));
        int currentValueAdults = Integer.parseInt(driver.findElement(By.cssSelector("div.sb-group__field-adults span.bui-stepper__display")).getText());
        int currentValueChildren = Integer.parseInt(driver.findElement(By.cssSelector("div.sb-group-children span.bui-stepper__display")).getText());
        int currentValueRoom = Integer.parseInt(driver.findElement(By.cssSelector("div.sb-group__field-rooms span.bui-stepper__display")).getText());
        while (currentValueAdults < 5) {
            buttonIncreaseAdults.click();
            currentValueAdults++;
        }
        while (currentValueChildren < 1) {
            currentValueChildren++;
            buttonIncreaseChildren.click();
        }
        while (currentValueRoom < 3) {
            currentValueRoom++;
            buttonIncreaseRoom.click();
        }

        Thread.sleep(1000);
        String actualAdult = driver.findElement(By.cssSelector("span[data-adults-count]")).getText();
        String actualChild = driver.findElement(By.cssSelector("span[data-children-count]")).getText();
        String actualRoom = driver.findElement(By.cssSelector("span[data-room-count]")).getText();
        String expectedAdult = "5";
        String expectedChild = "1";
        String expectedRoom = "3";
        System.out.println(actualAdult);
        System.out.println(actualChild);
        System.out.println(actualRoom);
        Assert.assertTrue(actualAdult.contains(expectedAdult));
        Assert.assertTrue(actualChild.contains(expectedChild));
        Assert.assertTrue(actualRoom.contains(expectedRoom));


    }


    @After
    public void afterTest() {
        driver.quit();
    }

}
