package subscribestepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.SubScription;

import java.util.Random;

public class StepDefinationTC4 {
    static WebDriver webDriver;
    static SubScription subScription;
    String validEmail;

    public StepDefinationTC4() {
        this.webDriver = Hooks.webDriver;
        System.out.println("Van chay vao stepdefination4");
        subScription = new SubScription(this.webDriver);
        PageFactory.initElements(webDriver, this.subScription);
    }

    @Given("^The information subscription is shown$")
    public void the_information_subscription_is_shown() throws Throwable {
        webDriver.get("http://testmaster.vn/");
        subScription = new SubScription(this.webDriver);
        PageFactory.initElements(webDriver, this.subScription);
        Random random = new Random();
        int rdInt = random.nextInt(1000);
        validEmail = "ducnghiasp" + rdInt + "@gmail.com";
        this.subScription.inputTxtEmail(validEmail);
        this.subScription.buttonSubcribe.click();
        this.subScription.setElementDivAlertExtraSubscription();
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

