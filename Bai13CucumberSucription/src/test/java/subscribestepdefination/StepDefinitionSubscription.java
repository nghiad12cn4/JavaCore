package subscribestepdefination;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.SubScription;

import org.junit.Assert;

import java.util.Random;

//NOTE: GIVEN DUNG CHUNG THI KHI CHAY SCENARIO LIEN QUAN TOI GIVEN THI CHAY VAO CONSTRUCTOR CUA SCENARIO CHUA GIVEN
public class StepDefinitionSubscription {
    WebDriver webdriver;
    SubScription subScription;

    public StepDefinitionSubscription() {
        this.webdriver = Hooks.webDriver;
        this.subScription = new SubScription(this.webdriver);
    }

    //  Scenario Outline: Show error message when user registry leave blank or content not correct format
//    Given Access to the Home page
//    When The user attempt to input <email> invalid
//    Then The message "* Email không đúng định dạng" is shown
//    And The border of email is red
//
//    Examples:
//      | email      |
//      | khanh.tx   |
//      | @yahoo.com |
    @Given("^Access to the Home page$")
    public void access_to_the_home_page() throws Throwable {
        subScription.openSubcribeExtra();
        System.out.println("Access to homepage Stepdefination 1");
    }

    @When("^The user attempt to input (.+) invalid$")
    public void the_user_attempt_to_input_invalid(String email) throws Throwable {
        subScription.inputTxtEmail(email);
        subScription.buttonSubcribe.click();
    }

    @Then("^The message \"([^\"]*)\" is shown$")
    public void the_message_something_is_shown(String expectedResult) throws Throwable {
        WebDriverWait wait = new WebDriverWait(this.webdriver, 3);
        wait.until(ExpectedConditions.visibilityOf(subScription.txtMessege));
        String actualMessage = "* Email không đúng định dạng";
        Assert.assertEquals(expectedResult, actualMessage);
    }

    @And("^The border of email is red$")
    public void the_border_of_email_is_red() throws Throwable {
        //getbackground-color lay mau nen cua Field
        String actualBorder = subScription.txtEmail.getCssValue("border-color");
        String expectedBorder = "rgb(255, 0, 0)";
        Assert.assertEquals(expectedBorder, actualBorder);

    }

    //    #2
//    Scenario Outline: Show error message when user registry existed email
//    Given Access to the Home page
//    When The user attempt to input existed email <email>
//    And The alert "E-mail <email> đã được sử dụng, bạn hãy chọn một E-mail khác" is shown
//    Examples:
//            | email                |
//            | ducnghiasp@gmail.com |
    @When("^The user attempt to input existed email (.+)$")
    public void the_user_attempt_to_input_existed_email(String email) throws Throwable {
        subScription.inputTxtEmail(email);
        subScription.buttonSubcribe.click();
    }

    @And("^The alert \"([^\"]*)\" is shown$")
    public void the_alert_something_is_shown(String expectedAddingText) throws Throwable {
        WebElement divEmailExisted = this.subScription.getDivEmailExisted();
        String actualResultContentDivMessage = this.subScription.getDivEmailExisted().getText();
        Assert.assertEquals(expectedAddingText, actualResultContentDivMessage);
    }

//         #3
//    Scenario: When user registry existed email, the subscription screen focus element is email and clear email content
//    Given User attempt to existed email, the alert is shown
//    When The user click Dong y button
//    Then The focus element is txtEmail
//    And The content email clears

    @Given("^User attempt to existed email, the alert is shown$")
    public void user_attempt_to_existed_email_the_alert_is_shown() throws Throwable {
        subScription.openSubcribeExtra();
        subScription.inputTxtEmail("ducnghiasp@gmail.com");
        subScription.buttonSubcribe.click();
        WebElement divEmailExisted = this.subScription.getDivEmailExisted();
        String actualResultContentDivMessage = this.subScription.getDivEmailExisted().getText();
        String expectedAddingText = "E-mail ducnghiasp@gmail.com đã được sử dụng, bạn hãy chọn một E-mail khác";
        Assert.assertEquals(expectedAddingText, actualResultContentDivMessage);
    }

    @When("^The user click Dong y button$")
    public void the_user_click_dong_y_button() throws Throwable {
        subScription.getButtonAllowButton().click();
    }

    @Then("^The focus element is txtEmail$")
    public void the_focus_element_is_txtemail() throws Throwable {
        WebElement actualElement = webdriver.switchTo().activeElement();
        WebElement expectedElement = this.subScription.txtEmail;
        Assert.assertEquals(expectedElement, actualElement);
    }

    @And("^The content email clears$")
    public void the_content_email_clears() throws Throwable {
        Assert.assertTrue(subScription.txtEmail.getText().isEmpty());
    }

    //Scenario 3
    @When("^Input valid email \\(not existed\\)$")
    public void input_valid_email_not_existed() throws Throwable {
        Random random = new Random();
        int rdInt = random.nextInt(1000);
        String validEmail = "ducnghiasp" + rdInt + "@gmail.com";
        this.subScription.inputTxtEmail(validEmail);
        subScription.buttonSubcribe.click();

    }

    @Then("^The extra description panel is shown$")
    public void the_extra_description_panel_is_shown() throws Throwable {
        subScription.setElementDivAlertExtraSubscription();
        Assert.assertTrue(subScription.extraSubcriptionForm.isDisplayed());

    }

    @And("^The Hovaten field is blank$")
    public void the_hovaten_field_is_blank() throws Throwable {
        String actualCurrentHovatenAES = subScription.txtHovatenAES.getText();
        String expectResultCurrentHovatenAES = "";
        Assert.assertEquals(expectResultCurrentHovatenAES, actualCurrentHovatenAES);

    }

    @And("^The \"([^\"]*)\" option is picked on Sex field$")
    public void the_something_option_is_picked_on_sex_field(String expectResultSex) throws Throwable {
        String actualResultSex = subScription.currentContentDisplaySex.getText();
        Assert.assertEquals(expectResultSex, actualResultSex);

    }

    @And("^The \"([^\"]*)\" option is picked on MessegeType field$")
    public void the_something_option_is_picked_on_messegetype_field(String expectResulTypeReceiveEmail) throws Throwable {
        String actualTypeReceiveEmail = subScription.currentTypeReceiveMail.getText();
        Assert.assertEquals(expectResulTypeReceiveEmail, actualTypeReceiveEmail);


    }

}
