package test;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.Todomvc;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StepDefinitions {
    WebDriver webDriver;
    Todomvc todomvcpage;
    DataTable dataTable;

    public StepDefinitions() {
        this.webDriver = Hooks.driver;
        this.todomvcpage = new Todomvc(this.webDriver);
    }

    @Given("^The todo mvc angular page is shown$")
    public void the_todo_mvc_angular_page_is_shown() throws Throwable {
        this.todomvcpage.openPage();
        this.todomvcpage.inItElement();
    }

    @When("^User input 5 items on todomvc angular page$")
    public void user_input_5_items_on_todomvc_angular_page(DataTable dataTable) throws Throwable {
        this.dataTable = dataTable;
        todomvcpage.inItElement();
//        WebElement inputTextField = todomvcpage.inputTextField;
        List<Map<String, String>> list = dataTable.asMaps();
        for (Map<String, String> s : list) {
            todomvcpage.inputTextField.clear();
            todomvcpage.inputTextField.sendKeys(s.get("items"));
            todomvcpage.inputTextField.sendKeys(Keys.ENTER);
        }
    }

    @And("^User refresh page$")
    public void user_refresh_page() throws Throwable {
        this.webDriver.navigate().refresh();
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.todomvcpage.inItElement();
    }

    @Then("^The list can still show on drop down list$")
    public void the_list_can_still_show_on_drop_down_list() throws Throwable {
        //lay expected result
        List<Map<String, String>> listExpected = dataTable.asMaps();
        ArrayList<String> listExpectedString = new ArrayList<>();
        for (Map<String, String> s :
                listExpected) {
            String item = s.get("items");
            listExpectedString.add(item);
        }
        //actual result
        List<WebElement> webElements = this.todomvcpage.dropDownList;
        ArrayList<String> listActualString = new ArrayList<>();
        for (WebElement e :
                webElements) {
            String item = e.getText();
            listActualString.add(item);
        }
        Assert.assertEquals(listExpectedString, listActualString);
    }

}
