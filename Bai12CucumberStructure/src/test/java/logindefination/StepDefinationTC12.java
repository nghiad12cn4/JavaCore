package logindefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LoginPage;

public class StepDefinationTC12 {
    // Scenario: Show error message when leave blank Username Password
    //    When The user attempt login with Username ""  and Password ""
    //    Then The message "Please enter your email." will be showed below Email field
    //    And The message "Please enter password." will be showed below Passoword field
    WebDriver driver;
    String typePassword;

    public StepDefinationTC12() {
        this.driver = Hooks.driver;
    }

    //common Step
    @Given("^Navigate to login page$")
    public void navigate_to_login_page() throws Throwable {
        Hooks.loginPage = new LoginPage(this.driver);
        Hooks.loginPage.openLoginPage();
        this.driver.manage().window().maximize();
    }


    @When("^The user attempt login with Username blank  and Password blank$")
    public void the_user_attempt_login_with_username_blank_and_password_blank() throws Throwable {
        Hooks.loginPage.inputUsername("");
        Hooks.loginPage.inputPassword("");
        Hooks.loginPage.btnSubmit.click();
        WebDriverWait wait = new WebDriverWait(this.driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(Hooks.loginPage.txtEmail));
    }

    @Then("^The message \"([^\"]*)\" will be showed below Email field$")
    public void the_message_something_will_be_showed_below_email_field(String expectedResultEmail) throws Throwable {
        String actualResultEmail = Hooks.loginPage.messageEmail.getText();
        Assert.assertEquals(expectedResultEmail, actualResultEmail);
    }

    @And("^The message \"([^\"]*)\" will be showed below Passoword field$")
    public void the_message_something_will_be_showed_below_passoword_field(String expectedResultPassword) throws Throwable {
        String actualResultPassword = Hooks.loginPage.messagePassword.getText();
        Assert.assertEquals(expectedResultPassword, actualResultPassword);
    }

}
