package stepdefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;

import static org.junit.Assert.*;

public class StepDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    //Scenario scenario;

    @Before
    public void inIt() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/web.driver.chrome/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
        System.out.println("abccc");
        //this.scenario = scenario;
    }

    @Given("^The login page is shown$")
    public void the_login_page_is_shown() throws Throwable {
        this.loginPage.openLoginPage();
    }

    @When("^The user attempt login with Username \"([^\"]*)\"  and Password \"([^\"]*)\"$")
    public void the_user_attempt_login_with_username_something_and_password_something(String email, String pass) throws Throwable {
        this.loginPage.inputUsername("");
        this.loginPage.inputPassword("");
        this.loginPage.btnSubmit.click();
        Thread.sleep(4000);
    }

    @Then("The message “Please enter your email.” And “Please enter password.” will be showed below corresponding field")
    public void the_message_please_enter_your_email_and_please_enter_password_will_be_showed_below_corresponding_field() {
        // Write code here that turns the phrase above into concrete actions

        if (this.loginPage.messageEmail.isDisplayed()) {
            String actualResultEmail = this.loginPage.messageEmail.getText();
            String expectedResultEmail = "Vui lòng nhập email.";
            System.out.println(actualResultEmail);
            Assert.assertEquals(expectedResultEmail, actualResultEmail);
        }
        if (this.loginPage.messagePassword.isDisplayed()) {
            String actualResultPassword = this.loginPage.messagePassword.getText();
            System.out.println(actualResultPassword);
            String expectedResultPassword = "Xin vui lòng nhập mật khẩu.";
            Assert.assertEquals(expectedResultPassword, actualResultPassword);
        }
    }

    @After
    public void afterTest() {
        this.driver.quit();

    }

}

