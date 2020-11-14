package subscribestepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.SubScription;

import java.util.Random;

public class StepDefinationTC3 {
    WebDriver webDriver;
    SubScription subScription;
    String validEmail;

    public StepDefinationTC3() {
        this.webDriver = StepDefinitionsTC1.webdriver;
        this.subScription = StepDefinitionsTC1.subScription;
    }

    @When("^Input valid email \\(not existed\\)$")
    public void input_valid_email_not_existed() throws Throwable {
        Random random = new Random();
        int rdInt = random.nextInt(1000);
        validEmail = "ducnghiasp" + rdInt + "@gmail.com";
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
