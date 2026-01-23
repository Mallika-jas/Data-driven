package Hooks;

import Basepage.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks extends BaseTest {

    @Before
    public void launchBrowser() {
        getDriver();
    }

    @After
    public void closeBrowser() {
        quitDriver();
    }
}
