package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import subscribestepdefination.Hooks;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubScription {

    WebDriver webDriver;
    @FindBy(css = "div.subscription div.title")
    public WebElement panelSubscription;

    @FindBy(css = "input[type=\"email\"]")
    public WebElement txtEmail;

    @FindBy(css = "div.mod-input span")
    public WebElement txtMessege;

    @FindBy(css = "button.next-btn-primary")
    public WebElement buttonSubcribe;

    //Get content DivAlertExtraSubscription;
    public WebElement txtHovatenAES;
    public List<WebElement> dropDownListAESAfterClickNamNu;
    public List<WebElement> dropDownListAESLoaiTinMuonNhan;
    public WebElement allowButtonAES;
    public WebElement currentContentDisplaySex;
    public WebElement currentTypeReceiveMail;
    public WebElement extraSubcriptionForm;
    public WebElement txtAESHoVaTenMessege;
    private Object object;

    public SubScription(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public void openSubcribeExtra() {
        webDriver.get("http://testmaster.vn/");
        this.webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        System.out.println("Init Element");
        PageFactory.initElements(webDriver, this);

    }


    public void inputTxtEmail(String email) {
        this.txtEmail.sendKeys(email);
    }

    public WebElement getDivEmailExisted() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, 3);
        WebElement divEmailExisted = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.cssSelector("div.body-message"))));
        return divEmailExisted;
    }

    public WebElement getButtonAllowButton() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, 3);
        WebElement allowButton = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.cssSelector("button[id=\"allow-button\"]"))));
        return allowButton;
    }

    //Set doi tuong Dynamic trong form add information subcription
    public void setElementDivAlertExtraSubscription() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, 3);
        WebElement extraSubcriptionForm = wait.until(ExpectedConditions.visibilityOf(this.webDriver.findElement(By.cssSelector("div.extra-subscription-form"))));
        this.extraSubcriptionForm = extraSubcriptionForm;
        this.txtHovatenAES = webDriver.findElement(By.cssSelector("input.form-control"));
        this.dropDownListAESAfterClickNamNu = webDriver.findElements(By.cssSelector("ul[aria-labelledby=\"ddlGender\"] a"));
        this.dropDownListAESLoaiTinMuonNhan = webDriver.findElements(By.cssSelector("ul[aria-labelledby=\"ddlNewsType\"] a"));
        this.allowButtonAES = webDriver.findElement(By.cssSelector("button#allow-button"));
        this.currentContentDisplaySex = webDriver.findElement(By.cssSelector("button#ddlGender span.content-display"));
        this.currentTypeReceiveMail = webDriver.findElement(By.cssSelector("button#ddlNewsType span.content-display"));
    }

    public WebElement getTxtAESHoVaTenMessege() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, 3);
        txtAESHoVaTenMessege = wait.until(ExpectedConditions.visibilityOf(this.webDriver.findElement(By.cssSelector("div.popover-body div.error"))));
        return txtAESHoVaTenMessege;
    }
}


