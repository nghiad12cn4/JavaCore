package subscribestepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.SubScription;

import java.util.List;

public class StepDefinationTC2 {
    WebDriver webDriver;
    SubScription subScription;
    String existedEmail;

    public StepDefinationTC2() {
        this.webDriver = StepDefinitionsTC1.webdriver;
        this.subScription = StepDefinitionsTC1.subScription;
    }

    @When("^The user attempt to input existed email (.+)$")
    public void the_user_attempt_to_input_existed_email(String email) throws Throwable {
        subScription.inputTxtEmail(email);
        subScription.buttonSubcribe.click();
    }

    @When("The alert {string}+{string}+{string} is shown")
    public void the_alert_is_shown(String string, String string2, String string3) {
        Boolean actualResult = this.subScription.getDivEmailExisted().isDisplayed();
        Assert.assertTrue(actualResult);
        String actualResultContentDivMessage = this.subScription.getDivEmailExisted().getText();
        String expectedResultContentDivMessage = string + string2 + string3;
        System.out.println("Expected result content div " + expectedResultContentDivMessage);
        Assert.assertEquals(expectedResultContentDivMessage, actualResultContentDivMessage);
    }

    @And("^The user click accept button$")
    public void the_user_click_accept_button() throws Throwable {
        subScription.getButtonAllowButton().click();
    }

    @Then("^The focus element is txtEmail$")
    public void the_focus_element_is_txtemail() throws Throwable {
        WebElement actualElement = webDriver.switchTo().activeElement();
        WebElement expectedElement = this.subScription.txtEmail;
        Assert.assertEquals(expectedElement, actualElement);
    }

    @And("^The content email clears$")
    public void the_content_email_clears() throws Throwable {
        Assert.assertTrue(subScription.txtEmail.getText().isEmpty());
    }
}
