package stepdefinationinvalidemail;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LoginPage;

public class StepDefinationInvalidEmail {
    WebDriver driver;
    LoginPage loginPage;


    @Before
    public void inIt() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/web.driver.chrome/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
    }

    @Given("^The login page is shown$")
    public void the_login_page_is_shown() throws Throwable {
        this.loginPage.openLoginPage();
    }

    @When("^The user attempt Invalid email address$")
    public void the_user_attempt_invalid_email_address() throws Throwable {
        this.loginPage.inputUsername("kjasdfjk");
        this.loginPage.inputPassword("123213213");
        this.loginPage.btnSubmit.click();


    }

    @Then("^The message “Enter a valid email address” will be shown$")
    public void the_message_enter_a_valid_email_address_will_be_shown() throws Throwable {
        WebDriverWait wait = new WebDriverWait(this.driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(this.loginPage.messageEmail));
        String actualResult = this.loginPage.messageEmail.getText();
        System.out.println(actualResult);
        String expectedResult = "Nhập địa chỉ email hợp lệ.";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @After
    public void afterTest() {
        this.driver.quit();

    }

}
