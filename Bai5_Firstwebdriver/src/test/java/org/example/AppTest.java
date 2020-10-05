package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        //System.setProperty("webdriver.chrome.driver", "F:\\Automation test\\WebDriver\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "F:\\Automation test\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com.vn/");
        driver.manage().window().maximize();

        //Actions/Steps
        WebElement txtSearch = driver.findElement(By.name("q"));
        txtSearch.sendKeys("testmaster.vn"); //Nhap mot chuoi
        txtSearch.sendKeys(Keys.ENTER); //Nhan mot phim he thong

        //Test
        //Lay ket qua thuc te, so sanh voi ket qua gia thiet. Neu dung => Pass, neu khong thi False
        String expected = "testmaster. vn";
        String actual = driver.getTitle();
        Assert.assertTrue(actual.startsWith(expected));

    }
}
