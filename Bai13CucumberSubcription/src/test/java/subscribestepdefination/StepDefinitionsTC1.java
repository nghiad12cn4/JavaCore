package subscribestepdefination;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.SubScription;

import org.junit.Assert;

public class StepDefinitionsTC1 {
    static WebDriver webdriver;
    static SubScription subScription;

    //Background access to Home page
    public StepDefinitionsTC1() {
        this.webdriver = Hooks.webDriver;
        webdriver.get("http://testmaster.vn/");
        subScription = new SubScription(this.webdriver);
        PageFactory.initElements(webdriver, this.subScription);
    }

    @Given("^Access to the Home page$")
    public void access_to_the_home_page() throws Throwable {
        subScription.openSubcribeExtra();
        this.webdriver.manage().window().maximize();
    }


    //  Scenario: Show error message when user registry leave blank or content not correct format
//  When The user attempt to input email blank or NOT correct format
//  Then The message "*Email không đúng định dạng" is shown
//  And The border of email is red
    @When("^The user attempt to input email blank or NOT correct format$")
    public void the_user_attempt_to_input_email_blank_or_not_correct_format() throws Throwable {
        subScription.inputTxtEmail("");
        subScription.buttonSubcribe.click();
    }

    @Then("^The message \"([^\"]*)\" is shown$")
    public void the_message_something_is_shown(String expectedMessage) throws Throwable {
        WebDriverWait wait = new WebDriverWait(this.webdriver, 3);
        wait.until(ExpectedConditions.visibilityOf(subScription.txtMessege));
        String actualMessage = "* Email không đúng định dạng";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @And("^The border of email is red$")
    public void the_border_of_email_is_red() throws Throwable {

        //getbackground-color lay mau nen cua Field
        String actualBorder = subScription.txtEmail.getCssValue("border-color");
        String expectedBorder = "rgb(255, 0, 0)";
        Assert.assertEquals(expectedBorder, actualBorder);

    }
}
