package org.example;

import static org.junit.Assert.assertTrue;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;

    @Before
    public void initTest() throws MalformedURLException {
        //Khoi tao driver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("deviceName", "H3AKGV920069PWZ");
        capabilities.setCapability("app", "C:\\Users\\nghia\\Desktop\\Calculator_v7.8.apk\\");
//appium driver thi su dung duoc cho ca IOS, ANDROID
//Android driver chi su dung duoc cho Android nhung co mot so chuc nang rieng biet (method)
        //IOS driver chi su dung cho IOS nhung co mot so chuc nang rieng biet (method)
        //Muc do doc lap test manual cho DB chi la tam thoi, TestAuto chi su dung API
        //Doc lap vinh cuu la su dung docker cho moi User test, tu dong setup khi co request
        //Cac lenh swipe, scroll, vuot su dung Linux shell de thuc hien
        driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String phepTinh = "1245+324234-1";
        MobileElement chiaOperator = this.driver.findElement(By.id("com.google.android.calculator:id/op_div"));
        MobileElement nhanOperator = this.driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
        MobileElement congOperator = this.driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement truOperator = this.driver.findElement(By.id("com.google.android.calculator:id/op_sub"));
        for (int i = 0; i < phepTinh.length(); i++) {
            if (phepTinh.charAt(i) == '+') {
                congOperator.click();
                continue;
            }
            if (phepTinh.charAt(i) == '*') {
                nhanOperator.click();
                continue;
            }
            if (phepTinh.charAt(i) == '/') {
                chiaOperator.click();
                continue;
            }
            if (phepTinh.charAt(i) == '-') {
                truOperator.click();
                continue;
            } else {
                MobileElement numberElement = (MobileElement) this.driver.findElement(By.id("com.google.android.calculator:id/digit_" + phepTinh.charAt(i)));
                numberElement.click();
            }
        }
        //Verify
        MobileElement resultField = (MobileElement) this.driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
        Assert.assertEquals("325478", resultField.getText());
    }

}
