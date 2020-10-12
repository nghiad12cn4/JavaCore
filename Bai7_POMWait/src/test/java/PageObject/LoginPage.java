package PageObject;

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

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

}
