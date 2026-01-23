package Acti;

/*import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import typeone.Base.BaseTest;
import typeone.Homepage.HomepageTest;
import typeone.Homepage.Saved_cart;
import typeone.Listeners.TestListener;

@Listeners(TestListener.class)
public class Acting extends BaseTest {
	Saved_cart sv = new Saved_cart(driver); 
	HomepageTest ht = new HomepageTest(driver);
	 
    @Test(priority = 1)
    public void firsttestcase() {
        ht.Clickaccount();
        ht.user("mallikahs25@gmail.com");
        ht.pass("Beckman@123");
        Assert.assertTrue(ht.isUserLoggedIn(driver),"User should be logged in");
    }

    @Test(priority = 2)
    public void secondtestcase() {  
        sv.add_test();
        //sv.dele_test();
        Assert.assertTrue(true, "Collection added successfully");
    }
    
    @Test(priority = 3)
    public void thirdtestcase() {     
        //sv.add_test();
        sv.dele_test();
        Assert.assertTrue(true, "Collection deleted successfully");
    } 
}*/

 

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import typeone.Base.BaseTest;
import typeone.Homepage.HomepageTest;
import typeone.Homepage.Saved_cart;

public class Acting extends BaseTest {

    HomepageTest ht;
    Saved_cart sv;

    @Given("user is on awards login page")
    public void user_is_on_login_page() {
        ht = new HomepageTest(driver);
    }

    @When("user logs in with valid credentials")
    public void user_logs_in() {
        ht.Clickaccount();
        ht.user("mallikahs25@gmail.com");
        ht.pass("Beckman@123");

        Assert.assertTrue(ht.isUserLoggedIn(driver),
                "User should be logged in");
    }

    @And("user adds a collection")
    public void user_adds_collection() {
        sv = new Saved_cart(driver);
        sv.add_test();
    }

    @And("user deletes the collection")
    public void user_deletes_collection() {
        sv.dele_test();
    }

    @Then("collection should be deleted successfully")
    public void verify_collection_deleted() {
        Assert.assertTrue(
            driver.findElements(
                org.openqa.selenium.By.xpath("//img[@alt='Bat1']")
            ).isEmpty(),
            "Collection not deleted"
        );
    }
}

 







