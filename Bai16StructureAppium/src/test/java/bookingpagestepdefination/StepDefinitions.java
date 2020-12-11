package bookingpagestepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.BookingSearchPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class StepDefinitions {
    WebDriver webdriver;
    RemoteWebDriver remoteWebDriver;
    BookingSearchPage bookingSearchPage;
    String expectedResultContain;
    Properties dataTest = new Properties();

    public StepDefinitions() throws IOException {
        if (Hooks.browserName.equalsIgnoreCase("chrome")) {
            this.webdriver = Hooks.webDriver;
            bookingSearchPage = new BookingSearchPage(webdriver);
        } else {
            System.out.println("Tao remote Android driver");
            this.remoteWebDriver = Hooks.remoteWebDriver;
            bookingSearchPage = new BookingSearchPage(remoteWebDriver);
        }
        Reader fReader = new FileReader("src/test/resources/testdata/data.properties");
        this.dataTest.load(fReader);
    }

    @Given("^The Homepage Booking.com is shown$")
    public void the_homepage_bookingcom_is_shown() throws Throwable {
        bookingSearchPage.openBookingSearchPage();
    }

    @When("^The user input (.+) on the search field$")
    public void the_user_input_on_the_search_field(String destination) throws Throwable {
        String input = this.dataTest.getProperty(destination);
        expectedResultContain = input.toLowerCase();
        this.bookingSearchPage.getSearchDestination().sendKeys(expectedResultContain);
    }

    @Then("^The destination contain keyword is shown$")
    public void the_destination_contain_keyword_is_shown() throws Throwable {
        if (Hooks.browserName.equalsIgnoreCase("chrome")) {
            WebDriverWait webDriverWait = new WebDriverWait(this.webdriver, 15);
            webDriverWait.until(ExpectedConditions.visibilityOf(this.bookingSearchPage.getDropdownlistAfterClick()));
        } else {
            Thread.sleep(7000);// dung ntn vi android khong co dau hieu nhan biet
        }
        for (int i = 0; i < this.bookingSearchPage.getListItemDestination().size(); i++) {
            String stringOption = this.bookingSearchPage.getListItemDestination().get(i).getText().replaceAll("\\s+", "");//xoa tat ca cac ky tu khong nhin thay duoc
            String stringParse = StringUtils.stripAccents(stringOption);//xoa dau tieng viet
            String lowerCaseActual = stringParse.toLowerCase();
            Assert.assertTrue(lowerCaseActual.contains(expectedResultContain));
        }
    }
}
