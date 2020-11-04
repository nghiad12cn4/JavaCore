package stepdefinationhideshowpassword;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;

public class StepDefinationHideShowPassword {
    WebDriver driver;
    LoginPage loginPage;
    String typePassword;

    @Before
    public void inIt() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/web.driver.chrome/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
    }


    @Given("^The login page is shown$")
    public void the_login_page_is_shown() throws Throwable {
        this.loginPage.openLoginPage();
    }

    @When("User click show\\/hide password")
    public void user_click_show_hide_password() {
        //GettrangThai cua Password
        this.loginPage.inputPassword("nghia123456");
        typePassword = this.loginPage.txtPassword.getAttribute("type");
        System.out.println(typePassword);
    }


    @Then("^Password is shown plaintext or Password show secret text$")
    public void password_is_shown_plaintext_or_password_show_secret_text() throws Throwable {
        if (typePassword.equals("password")) {
            this.loginPage.hideShowPassIcon.click();
            String expectedResult = "text";
            String actualResult = this.loginPage.txtPassword.getAttribute("type");
            System.out.println(actualResult);
            Assert.assertEquals(expectedResult, actualResult);
        } else {
            String expectedResult2 = "password";
            String actualResult2 = this.loginPage.txtPassword.getAttribute("password");
            System.out.println(actualResult2);
            Assert.assertEquals(expectedResult2, actualResult2);
        }


    }

    @After
    public void afterTest() {
        this.driver.quit();

    }
}
