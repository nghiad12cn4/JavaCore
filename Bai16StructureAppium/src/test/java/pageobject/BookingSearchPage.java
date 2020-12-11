package pageobject;

import bookingpagestepdefination.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingSearchPage {
    public RemoteWebDriver remoteWebDriver;
    public WebDriver webDriver;

    public WebElement getSearchDestination() {
        if (Hooks.browserName.equals("chrome")) {
            return webDriver.findElement(By.cssSelector("input[type=search]"));
        } else {
            return remoteWebDriver.findElement(By.cssSelector("input#input_destination"));
        }
    }


    public WebElement getDropdownlistAfterClick() {
        if (Hooks.browserName.equals("chrome")) {
            return webDriver.findElement(By.cssSelector("ul[role=listbox]"));
        }
        return remoteWebDriver.findElement(By.cssSelector("div.searchbox_cross_product__overlay"));
    }


    public List<WebElement> getListItemDestination() {
        if (Hooks.browserName.equals("chrome")) {
            return webDriver.findElements(By.cssSelector("li[role=option]"));
        }
        return remoteWebDriver.findElements(By.cssSelector("li[role=\"menuitem\"]"));
    }

    public BookingSearchPage(RemoteWebDriver remoteWebDriver) {
        this.remoteWebDriver = remoteWebDriver;
        System.out.println("Constructor Adnroid driver");
    }

    public BookingSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openBookingSearchPage() {
        if (Hooks.browserName.equals("chrome")) {
            this.webDriver.get("https://www.booking.com/");
            this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.webDriver.manage().window().maximize();
        } else {
            this.remoteWebDriver.get("https://www.booking.com/");
            this.remoteWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}
