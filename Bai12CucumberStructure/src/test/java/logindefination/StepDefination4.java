package logindefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class StepDefination4 {

//    #Testcase 4
//    Scenario: Show password as a plan text and secret text
//    Given The Password is shown
//    When The user enter the password then try to show their password before hide it again
//    Then The password display as a plan text
//    And The password show as a secret character after click hide
    WebDriver driver;
    String typePassword;

    public StepDefination4() {
        this.driver = Hooks.driver;
    }

    @Given("^The Password is shown$")
    public void the_password_is_shown() throws Throwable {
        Assert.assertTrue(Hooks.loginPage.txtPassword.isDisplayed());
    }

    @When("^The user enter the password then try to show their password before hide it again$")
    public void the_user_enter_the_password_then_try_to_show_their_password_before_hide_it_again() throws Throwable {
        Hooks.loginPage.inputPassword("nghia123456");
        Hooks.loginPage.hideShowPassIcon.click();

    }

    @Then("^The password display as a plan text$")
    public void the_password_display_as_a_plan_text() throws Throwable {
        String expectResult = "text";
        String typePasswordActual = Hooks.loginPage.txtPassword.getAttribute("type");
        Assert.assertEquals(expectResult, typePasswordActual);
    }


    @And("^The password show as a secret character after click hide$")
    public void the_password_show_as_a_secret_character_after_click_hide() throws Throwable {
        Hooks.loginPage.hideShowPassIcon.click();
        String expectResult = "password";
        String typePasswordActual = Hooks.loginPage.txtPassword.getAttribute("type");
        Assert.assertEquals(expectResult, typePasswordActual);
    }
}
