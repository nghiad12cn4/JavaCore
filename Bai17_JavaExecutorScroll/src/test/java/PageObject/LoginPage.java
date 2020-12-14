package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(css = "div.mod-login-input-loginName input")
    public WebElement txtUsername;
    @FindBy(css = "div[id=\"anonLogin\"] a")
    public WebElement linkDangNhap;
    @FindBy(css = "input[type=password]")
    public WebElement txtPassword;
    @FindBy(css = "div.scale_text span[data-nc-lang*=_startTEXT")
    public WebElement slider;

    @FindBy(id = "anonSignup")
    public WebElement signUpLink;

    @FindBy(css = "ul.next-menu-content li[value='12']")
    public WebElement month12;

    @FindBy(css = "span#day")
    public WebElement dayDropdownList;


    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

}
