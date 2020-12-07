package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingHomePage {
    public RemoteWebDriver remoteWebDriver;

    @FindBy(css = "input[type=search]")
    public WebElement searchDestination;


    @FindBy(css = "ul[role=listbox]")
    public WebElement dropdownlistAfterClick;


    @FindAll(@FindBy(css = "li[role=option]"))
    public List<WebElement> listItemDestination;

    @FindBy(css = "input[type=search]")
    public WebElement searchFieldDestination;


    public BookingHomePage(RemoteWebDriver remoteWebDriver) {
        this.remoteWebDriver = remoteWebDriver;
    }

    public void inIt() {
        PageFactory.initElements(remoteWebDriver, this);
    }
}



