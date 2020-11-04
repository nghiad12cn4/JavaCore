package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import sun.plugin.com.PropertyGetDispatcher;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    @FindBy(id = "login-email")
    public WebElement txtEmail;
    @FindBy(id = "login-pwd")
    public WebElement txtPassword;
    @FindBy(id = "login-submit")
    public WebElement btnSubmit;
    @FindBy(id = "login-pwd-show")
    public WebElement hideShowPassIcon;
    @FindBy(css = "span.login-btn")
    public WebElement tabSignIn;
    @FindBy(css = "register-btn")
    public WebElement tabRegister;
    @FindBy(className = "login-email-tip")
    public WebElement messageEmail;
    @FindBy(className = "login-pwd-tip")
    public WebElement messagePassword;

    public List<WebElement> listSuggestMail;
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this);// phai lam o ham openLoginPage vi khi day moi coc Page truyen vao
    }

    public void openLoginPage() {
        this.driver.get("https://sea.banggood.com/login.html");
        this.driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void inputUsername(String username) {
        txtEmail.sendKeys(username);
    }

    public void inputPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void setListSuggestMail() {
        this.listSuggestMail = this.driver.findElements(By.cssSelector("label.login-email ul.list li"));
    }

    public String getCurrentTxtEmail() {
        return this.txtEmail.getText();
    }
}
