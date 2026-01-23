package stepdefinitions;

public class CollectionSteps extends Hooks {


import org.testng.Assert;
import io.cucumber.java.en.*;
import typeone.Homepage.HomepageTest;
import typeone.Homepage.Saved_cart;


    HomepageTest ht;
    Saved_cart sv;

    @Given("user is on awards login page")
    public void user_is_on_login_page() {
        ht = new HomepageTest(Hooks.driver);
    }

    @When("user logs in with valid credentials")
    public void user_logs_in() {
        ht.Clickaccount();
        ht.user("mallikahs25@gmail.com");
        ht.pass("Beckman@123");

        Assert.assertTrue(ht.isUserLoggedIn(Hooks.driver));
    }

    @And("user adds a collection")
    public void user_adds_collection() {
        sv = new Saved_cart(Hooks.driver);
        sv.add_test();
    }

    @And("user deletes the collection")
    public void user_deletes_collection() {
        sv.dele_test();
    }

    @Then("collection should be deleted successfully")
    public void verify_collection_deleted() {
        Assert.assertTrue(
            Hooks.driver.findElements(
                org.openqa.selenium.By.xpath("//img[@alt='Bat1']")
            ).isEmpty()
        );
    }
}
