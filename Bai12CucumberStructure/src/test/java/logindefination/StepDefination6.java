package logindefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefination6 {
//    #Testcase 6
//    Scenario: Show message when user input user pass NOT exist
//    When User input email NOT exist, User input password NOT exist
//    Then The error message "Lỗi: Không khớp với Địa chỉ E-mail và / hoặc Mật khẩu." is shown
    WebDriver driver;

    public StepDefination6() {
        this.driver = Hooks.driver;
    }

    @When("^User input email NOT exist, User input password NOT exist$")
    public void user_input_email_not_exist_user_input_password_not_exist() throws Throwable {
        Hooks.loginPage.inputUsername("nghia123@gmail.com");
        Hooks.loginPage.inputPassword("nghia123");
        Hooks.loginPage.btnSubmit.click();
    }

    @Then("^The error message \"([^\"]*)\" is shown$")
    public void the_error_message_something_is_shown(String expectedResult) throws Throwable {
        WebDriverWait wait = new WebDriverWait(this.driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(Hooks.loginPage.messageEmail));
        String actualResult = Hooks.loginPage.messageEmail.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
