package PageObject;

import io.appium.java_client.AppiumDriver;
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

public class BookingHomePageAndroid {
    public RemoteWebDriver remoteWebDriver;

    //    @FindBy(id = "input_destination") hoi anh khanh tai sao find by id khong duoc
    @FindBy(css = "input#input_destination")
    public WebElement searchDestination;

    @FindBy(css = "div.searchbox_cross_product__overlay")
    public WebElement dropdownlistAfterClick;

    @FindAll(@FindBy(css = "li[role=\"menuitem\"]"))
    public List<WebElement> listItemDestination;

    public BookingHomePageAndroid(RemoteWebDriver remoteWebDriver) {
        this.remoteWebDriver = remoteWebDriver;
    }

    public void inIt() {
        System.out.println("Init android success");
        PageFactory.initElements(remoteWebDriver, this);
    }
}
