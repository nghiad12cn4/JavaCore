package stepdefinationinputemailpasswordnotexist;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LoginPage;

public class StepDefinationInputEmailPassNOTExist {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void inIt() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/web.driver.chrome/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
    }

    @Given("The login page is shown")
    public void the_login_page_is_shown() {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.openLoginPage();
    }

    @When("User input email NOT exist, User input password NOT exist")
    public void user_input_email_not_exist_user_input_password_not_exist() {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.inputUsername("nghia123@gmail.com");
        this.loginPage.inputPassword("nghia123");
        this.loginPage.btnSubmit.click();
    }

    @Then("The error message {string} is shown")
    public void the_error_message_is_shown(String expectedResult) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(this.driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(this.loginPage.messageEmail));
        String actualResult = this.loginPage.messageEmail.getText();
        Assert.assertEquals(expectedResult, actualResult);

    }

    @After
    public void afterTest() {
        this.driver.quit();

    }
}
