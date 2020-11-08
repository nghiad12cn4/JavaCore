package logindefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefination5 {
//    #Testcase 5
//    Scenario: Show error message when leave blank Username Password
//    When The user attempt to input invalid email address
//    Then The message "Nhập địa chỉ email hợp lệ." will be shown
    WebDriver driver;

    public StepDefination5() {
        this.driver = Hooks.driver;
    }

    @When("^The user attempt to input invalid email address$")
    public void the_user_attempt_to_input_invalid_email_address() throws Throwable {
        Hooks.loginPage.inputUsername("kjasdfjk");
        Hooks.loginPage.inputPassword("123213213");
        Hooks.loginPage.btnSubmit.click();
    }


    @Then("^The message \"([^\"]*)\" will be shown$")
    public void the_message_something_will_be_shown(String expectedResult) throws Throwable {
        WebDriverWait wait = new WebDriverWait(this.driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(Hooks.loginPage.messageEmail));
        String actualResult = Hooks.loginPage.messageEmail.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
