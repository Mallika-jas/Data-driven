package Acti;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import typeone.Base.BaseTest;
import typeone.Homepage.HomepageTest;
import typeone.Listeners.TestListener;

import org.testng.annotations.DataProvider;
import utility.Excelutility;
import java.io.IOException;


public class Acting extends BaseTest {

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws IOException {
		
		System.out.println("DATAPROVIDER CALLED");
		return Excelutility.getLoginData();
	}
  /*  @Test
    public void firsttestcase() {
        HomepageTest ht = new HomepageTest(driver);
        ht.Clickaccount();
        ht.user("mallikahs25@gmail.com");
        ht.pass("Beckman@123");
       	ht.userlogin();
        ht.logout_action();
       // Assert.assertTrue(ht.isUserLoggedIn(driver), "User should be logged in");
    }*/

    
	@Test(dataProvider = "loginData")
	public void firsttestcase(String username, String password) {

	    System.out.println("Trying login with: " + username);

	    HomepageTest ht = new HomepageTest(driver);
	    
	    if(ht.LoginButtonPresent()) {
	    ht.Clickaccount();
	    }
	    
	    ht.user(username);
	    ht.pass(password);
	    ht.userlogin();
	    if (ht.isLoginInvalidByUrl(driver)) {
	    	System.out.println("❌ INVALID login: " + username);
	    	takescreenshot("InvalidLogin_" + username.replace("@", "_"));
	    	
	    	
	    	// nothing else — next Excel row runs automatically
	    	} else {
	    	System.out.println("✅ VALID login: " + username);
	    	ht.logout_action();
	    	}
	}
}





