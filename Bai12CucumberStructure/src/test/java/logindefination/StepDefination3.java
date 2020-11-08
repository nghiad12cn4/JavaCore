package logindefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import jdk.nashorn.internal.objects.NativeArray;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

//#Testcase 3
//        Scenario: The suggestion is shown when user input email
//        When User input email
//        Then The suggestion is shown
//        And User can choose matched item from suggestion
public class StepDefination3 {
    WebDriver driver;
    List<WebElement> listSuggestMail = null;
    String input = "nghiald";

    public StepDefination3() {
        this.driver = Hooks.driver;
    }

    @When("^User input email$")
    public void user_input_email() throws Throwable {
        Hooks.loginPage.inputUsername(input);
    }

    @Then("^The suggestion is shown$")
    public void the_suggestion_is_shown() throws Throwable {
        listSuggestMail = Hooks.loginPage.getListSuggestMail();
        for (int i = 0; i < listSuggestMail.size(); i++) {
            Assert.assertTrue(listSuggestMail.get(i).getAttribute("textContent").contains(input));
        }
    }

    @And("^User can choose matched item from suggestion$")
    public void user_can_choose_matched_item_from_suggestion() throws Throwable {
        Random random = new Random();
        int rdlist = random.nextInt(listSuggestMail.size());
        WebElement itemChoosen = this.driver.findElement(By.xpath(" //li[contains(text(),'" + listSuggestMail.get(rdlist).getText() + "')]"));
        String expectedResult = itemChoosen.getText();
        Actions actions = new Actions(this.driver);
        actions.moveToElement(itemChoosen);
        actions.click(itemChoosen).perform();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOf((this.driver.findElement(By.cssSelector("label.login-email ul")))));
        String actualResult = Hooks.loginPage.txtEmail.getAttribute("value");
        assertEquals(expectedResult, actualResult);
    }
}
