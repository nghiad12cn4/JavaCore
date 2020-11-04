package stepdefination3;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LoginPage;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions3 {
    WebDriver driver;
    LoginPage loginPage;
    String input = "nghia";

    //Scenario scenario;

    @Before
    public void inIt() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/web.driver.chrome/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
    }

    @Given("The login page is shown3")
    public void the_login_page_is_shown() {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.openLoginPage();


    }


    @When("User input email")
    public void user_input_email() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.inputUsername(input);
        Thread.sleep(3000);
        //System.out.println(this.loginPage.txtEmail.getText());
        System.out.println("hihi" + this.loginPage.getCurrentTxtEmail());
    }

    @Then("The suggestion is shown")
    public void the_suggestion_is_shown() throws InterruptedException {
        this.loginPage.setListSuggestMail();
        List<WebElement> listSuggestMail = this.loginPage.listSuggestMail;
        for (int i = 0; i < listSuggestMail.size(); i++) {
//            System.out.println(listSuggestMail.get(i).getText());
            System.out.println(listSuggestMail.get(i).getAttribute("textContent"));
        }

        //Get list xem lay duoc list chua
        //Click 1 suggestion random
        Random random = new Random();
        System.out.println(listSuggestMail.size());
        int rdlist = random.nextInt(listSuggestMail.size());
        System.out.println(rdlist);
        WebElement itemChoosen = this.driver.findElement(By.xpath(" //li[contains(text(),'" + listSuggestMail.get(rdlist).getText() + "')]"));
        String expectedResult = itemChoosen.getText();
        Actions actions = new Actions(this.driver);
        actions.moveToElement(itemChoosen);
        actions.click(itemChoosen).perform();
        //getText current txtEmail
        System.out.println("Acutal result");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOf((this.driver.findElement(By.cssSelector("label.login-email ul")))));
//        WebElement txtEmail = this.driver.findElement(By.id("login-email"));
//        System.out.println(txtEmail.getText());
        //Khong hien thi ra gi khi dung Driver truyen tu class nay
        // So sanh voi ket qua mong muon
        System.out.println("Actualresult get bang WebElement" + this.loginPage.txtEmail.getAttribute("value"));
        //Tai sao chi co the lay getAtribute value
        //String expectedResult = listSuggestMail.get(rdlist).getText();
        String actualResult = this.loginPage.txtEmail.getAttribute("value");
        assertEquals(expectedResult, actualResult);
    }


    @After
    public void afterTest() {
        this.driver.quit();

    }

}

