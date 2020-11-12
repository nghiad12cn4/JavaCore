package subscribestepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobject.SubScription;

import java.util.Random;

public class StepDefinationTC4 {
    WebDriver webDriver;
    SubScription subScription;
    String validEmail;

    public StepDefinationTC4() {
        this.webDriver = StepDefinitionsTC1.webdriver;
        this.subScription = StepDefinitionsTC1.subScription;
    }

    @Given("^User input valid email \\(not existed\\) 2$")
    public void user_input_valid_email_not_existed_2() throws Throwable {
        Random random = new Random();
        int rdInt = random.nextInt(1000);
        validEmail = "ducnghiasp" + rdInt + "@gmail.com";
        this.subScription.inputTxtEmail(validEmail);
    }

    @And("^Click DangKy button$")
    public void click_dangky_button() throws Throwable {
        subScription.buttonSubcribe.click();
    }

    @And("^Show div Subribe extra panel$")
    public void show_div_subribe_extra_panel() throws Throwable {
        subScription.setElementDivAlertExtraSubscription();
        Assert.assertTrue(subScription.extraSubcriptionForm.isDisplayed());
    }


    @When("^Input blank ho va ten field$")
    public void input_blank_ho_va_ten_field() throws Throwable {
        subScription.txtHovatenAES.sendKeys("");
    }

    @And("^Click Dong y button$")
    public void click_dong_y_button() throws Throwable {
        subScription.allowButtonAES.click();
    }

    @Then("^The message4 \"([^\"]*)\" is shown$")
    public void the_message4_something_is_shown(String expectedResult) throws Throwable {
        subScription.setTxtAESHoVaTenMessege();
        String actualResult = subScription.txtAESHoVaTenMessege.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }


    @And("^Border is red$")
    public void border_is_red() throws Throwable {
        subScription.setTxtAESHoVaTenMessege();
        subScription.txtAESHoVaTenMessege.getText();
    }

    @And("^Background is yellow$")
    public void background_is_yellow() throws Throwable {
        //getbackground-color lay mau nen cua Field
        String actualBorder = subScription.txtHovatenAES.getCssValue("background-color");
        String expectedBorder = "rgba(255, 255, 0, 1)";
        Assert.assertEquals(expectedBorder, actualBorder);
    }

}

