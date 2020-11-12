package subscribestepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.SubScription;

public class StepDefinationTC2 {
    WebDriver webDriver;
    SubScription subScription;
    String existedEmail;

    public StepDefinationTC2() {
        this.webDriver = Hooks.webDriver;
        this.subScription = StepDefinitionsTC1.subScription;
    }

    @When("^The user attempt to input existed email$")
    public void the_user_attempt_to_input_existed_email() throws Throwable {
        existedEmail = "khanh.tx@live.com";
        subScription.inputTxtEmail(existedEmail);
    }

    @And("^The user click button Dangky$")
    public void the_user_click_button_dangky() throws Throwable {
        subScription.buttonSubcribe.click();
    }


    @And("^The alert is shown$")
    public void the_alert_is_shown() throws Throwable {
        Boolean actualResult = this.subScription.getDivEmailExisted().isDisplayed();
        Assert.assertTrue(actualResult);
        String actualResultContentDivMessage = this.subScription.getDivEmailExisted().getText();
        String expectedResultContentDivMessage = "E-mail " + existedEmail + " đã được sử dụng, bạn hãy chọn một E-mail khác";
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
