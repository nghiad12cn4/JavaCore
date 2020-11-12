package subscribestepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobject.SubScription;

import java.util.Random;

public class StepDefinationTC6 {
    WebDriver webDriver;
    SubScription subScription;
    String validEmail;

    public StepDefinationTC6() {
        this.webDriver = StepDefinitionsTC1.webdriver;
        this.subScription = StepDefinitionsTC1.subScription;
    }

    @Given("^User input valid email \\(not existed\\) 6$")
    public void user_input_valid_email_not_existed_6() throws Throwable {
        Random random = new Random();
        //Nhap mail bat ki de tranh trung Email da dang ki
        int rdItemChoosenSex = random.nextInt(1000);
        validEmail = "nghiad12cn" + rdItemChoosenSex + "@gmail.com";
        this.subScription.inputTxtEmail(validEmail);
    }

    @And("^User Click DangKy button6$")
    public void user_click_dangky_button6() throws Throwable {
        subScription.buttonSubcribe.click();

    }

    @And("^User Show div Subribe extra panel6$")
    public void user_show_div_subribe_extra_panel6() throws Throwable {
        subScription.setElementDivAlertExtraSubscription();
        Assert.assertTrue(subScription.extraSubcriptionForm.isDisplayed());
    }

    @When("^User input valid value for all field$")
    public void user_input_valid_value_for_all_field() throws Throwable {
        //input valid ho va ten
        subScription.txtHovatenAES.sendKeys("Le Duc Nghia");
        Actions action = new Actions(this.webDriver);
//        this.subScription.currentTypeReceiveMail.click();
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
    }

    @And("^User click Dong y button6$")
    public void user_click_dong_y_button6() throws Throwable {
        subScription.allowButtonAES.click();
    }


    @Then("^The popup \"([^\"]*)\" is shown$")
    public void the_popup_something_is_shown(String expectedResult) throws Throwable {
        String actualResult = "Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký";
        Assert.assertEquals(expectedResult, actualResult);

    }


}
