package subscribestepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.SubScription;

import java.util.Random;

public class StepAddInfSubscription {
    WebDriver webdriver;
    SubScription subScription;

    public StepAddInfSubscription() {
        this.webdriver = Hooks.webDriver;
        this.subScription = new SubScription(this.webdriver);
    }

    //#        4
//    Scenario: User attempt to input blank Hovaten field on Add Information form and click Dongy, the messagse is shown
//    Given The information subscription is shown
//    When Input blank ho va ten field
//    Then The message AES "* Bạn cần phải nhập dữ liệu" is shown
//    And Border is red
//    And Background is yellow
    @Given("^The information subscription is shown$")
    public void the_information_subscription_is_shown() throws Throwable {
        subScription.openSubcribeExtra();
        Random random = new Random();
        int rdInt = random.nextInt(1000);
        String validEmail = "ducnghiasp" + rdInt + "@gmail.com";
        this.subScription.inputTxtEmail(validEmail);
        this.subScription.buttonSubcribe.click();
        this.subScription.setElementDivAlertExtraSubscription();
        Assert.assertTrue(subScription.extraSubcriptionForm.isDisplayed());
    }


    @When("^Input blank ho va ten field$")
    public void input_blank_ho_va_ten_field() throws Throwable {
        subScription.txtHovatenAES.sendKeys("");
        subScription.allowButtonAES.click();
    }


    @Then("^The message AES \"([^\"]*)\" is shown$")
    public void the_message_aes_something_is_shown(String expectedMessage) throws Throwable {
        String actualResult = subScription.getTxtAESHoVaTenMessege().getText();
        Assert.assertEquals(expectedMessage, actualResult);
    }


    @And("^Border is red$")
    public void border_is_red() throws Throwable {
        String actualBorder = subScription.txtHovatenAES.getCssValue("border-color");
        String expectedBorder = "rgb(209, 116, 125)";
        Assert.assertEquals(expectedBorder, actualBorder);
    }

    @And("^Background is yellow$")
    public void background_is_yellow() throws Throwable {
        //getbackground-color lay mau nen cua Field
        String actualBorder = subScription.txtHovatenAES.getCssValue("border-right-color");
        String expectedBorder = "rgb(239, 18, 24)";
        Assert.assertEquals(expectedBorder, actualBorder);
    }

    //    #          5
//    Scenario: User attempt to input something in AddingInformation form then press Escape button
//    Given The information subscription is shown
//    When User input something hovaten field
//    And Press escape button
//    Then The subribe panel is hide
    @When("^User input something hovaten field$")
    public void user_input_something_hovaten_field() throws Throwable {
        this.subScription.txtHovatenAES.sendKeys("Le Duc Nghia");
    }

    @And("^Press escape button$")
    public void press_escape_button() throws Throwable {
        this.subScription.txtHovatenAES.sendKeys(Keys.ESCAPE);
    }

    @Then("^The subribe panel is hide$")
    public void the_subribe_panel_is_hide() throws Throwable {
        WebDriverWait wait = new WebDriverWait(this.webdriver, 3);
        Boolean actualResult = wait.until(ExpectedConditions.invisibilityOf(subScription.extraSubcriptionForm));
        Assert.assertTrue(actualResult);

    }
    //6

    @When("^User input valid value for all field$")
    public void user_input_valid_value_for_all_field() throws Throwable {
        //input valid ho va ten
        subScription.txtHovatenAES.sendKeys("Le Duc Nghia");
        Actions action = new Actions(this.webdriver);
        action.moveToElement(subScription.currentContentDisplaySex);
        action.click(subScription.currentContentDisplaySex).perform();
        Random random = new Random();
        //Chon gioi tinh bat ki
        int rdItemChoosenSex = random.nextInt(2);
        WebElement itemChoosenSex = subScription.dropDownListAESAfterClickNamNu.get(rdItemChoosenSex);
        action.moveToElement(itemChoosenSex);
        action.click(itemChoosenSex).perform();
        //Chon kieu tin nhan bat ki
        action.moveToElement(subScription.currentTypeReceiveMail);
        action.click(subScription.currentTypeReceiveMail).perform();
        int rdItemChoosenDropLoaiNhanMessege = random.nextInt(3);
        WebElement itemChoosenDropLoaiNhanMessege = subScription.dropDownListAESLoaiTinMuonNhan.get(rdItemChoosenDropLoaiNhanMessege);
        action.moveToElement(itemChoosenDropLoaiNhanMessege);
        action.click(itemChoosenDropLoaiNhanMessege).perform();
        subScription.allowButtonAES.click();

    }

    @Then("^The popup \"([^\"]*)\" is shown$")
    public void the_popup_something_is_shown(String expectedResult) throws Throwable {
        String actualResult = this.subScription.getDivEmailExisted().getText();
        Assert.assertEquals(expectedResult, actualResult);

    }
}



