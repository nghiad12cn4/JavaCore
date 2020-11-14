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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.SubScription;

import javax.swing.*;
import java.util.Random;

public class StepDefinationTC5 {
    WebDriver webDriver;
    SubScription subScription;
    String validEmail;

    public StepDefinationTC5() {
        this.webDriver = StepDefinationTC4.webDriver;
        this.subScription = StepDefinationTC4.subScription;
    }

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
        WebDriverWait wait = new WebDriverWait(this.webDriver, 3);
        Boolean actualResult = wait.until(ExpectedConditions.invisibilityOf(subScription.extraSubcriptionForm));
        Assert.assertTrue(actualResult);

    }


}
