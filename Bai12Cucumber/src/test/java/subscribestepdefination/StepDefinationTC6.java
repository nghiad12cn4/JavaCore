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
        this.webDriver = StepDefinationTC4.webDriver;
        this.subScription = StepDefinationTC4.subScription;
    }

    @When("^User input valid value for all field$")
    public void user_input_valid_value_for_all_field() throws Throwable {
        //input valid ho va ten
        subScription.txtHovatenAES.sendKeys("Le Duc Nghia");
        Actions action = new Actions(this.webDriver);
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
        String actualResult = "Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký";
        Assert.assertEquals(expectedResult, actualResult);

    }


}
