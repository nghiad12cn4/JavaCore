package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingHomePage {

    @FindBy(css = "input[type=search]")
    public WebElement searchDestination;

    @FindBy(css = "ul[role=listbox]")
    public WebElement dropdownlistAfterClick;

    @FindBy(css = "li[role=option]")
    public WebElement listItemDestination;

    @FindBy(css = "input[type=search]")
    public WebElement searchFieldDestination;

    public BookingHomePage(WebDriver driver) {
        PageFactory.initElements(driver, BookingHomePage.this);
    }


}
