package StepDefinations;

import org.testng.Assert;
import Basepage.BaseTest;
import io.cucumber.java.en.*;
import pageobject.Crud;
import pageobject.Loginn;

public class CollectionSteps extends BaseTest {

    Loginn login;
    Crud crud;

    @Given("user is on awards login page")
    public void user_is_on_awards_login_page() {
        login = new Loginn(getDriver());
        crud = new Crud(getDriver());
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        login.Clickaccount();
        login.user("mallikahs25@gmail.com");
        login.pass("Beckman@123");
        Assert.assertTrue(login.isUserLoggedIn(getDriver()));
    }

    @And("user adds a collection")
    public void user_adds_a_collection() {
        crud.coll_verify();
    }

    @And("user deletes the collection")
    public void user_deletes_the_collection() {
        crud.dele_coll();
    }
}
