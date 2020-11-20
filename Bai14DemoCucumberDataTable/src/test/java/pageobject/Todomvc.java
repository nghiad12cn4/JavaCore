package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Todomvc {
    WebDriver webDriver;
    @FindBy(css = "input.new-todo")
    public WebElement inputTextField;

    @FindAll(
            @FindBy(css = "label.ng-binding"))
    public List<WebElement> dropDownList;

    public Todomvc(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openPage() {
        this.webDriver.get("http://todomvc.com/examples/angularjs/#/");
        this.webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }


    public void inItElement() {
        PageFactory.initElements(this.webDriver, this);
    }


}
