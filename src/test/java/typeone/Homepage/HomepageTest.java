package typeone.Homepage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomepageTest extends Basic{
    public HomepageTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
        @FindBy(xpath="//div/strong[text()='Log in']") WebElement logoption;
        @FindBy(xpath="//input[@placeholder='Email or Username']") WebElement un;
        @FindBy(xpath="//input[@placeholder='Password']") WebElement ps; 
        @FindBy(xpath="//button/span[contains(text(),'Log in now')]") WebElement logaction;
        @FindBy(xpath="//img[@class='circle-avatar__img']") WebElement logoutnavigation;
        @FindBy(xpath="//a[contains(text(),'Logout')]") WebElement logoutverify;
        @FindBy(xpath="//strong[contains(text(), 'Log in')]") WebElement logoutdoneverify;
        @FindBy(xpath="//span[contains(text(),'Incorrect E-mail, username or password')]")
		public WebElement loginErrorMessage;
        Actions act = new Actions(driver);
        
        public void Clickaccount() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(logoption)).click();  // Waits for element to be clickable
        }
        public void user(String username) {
        	un.clear();
        	un.sendKeys(username);
        }
        public void pass(String password) {
        	ps.clear();
        	ps.sendKeys(password);
        	//logaction.click();
        }
        public void userlogin() {
        	logaction.click();
        }
        
        public boolean isLoginInvalidByUrl(WebDriver driver) {
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.contains("/login");
        }
        
        public boolean LoginButtonPresent() {
            try {
            	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
            			wait.until(ExpectedConditions.visibilityOf(logoption));
                return logoption.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
        
        
        public boolean isUserLoggedIn(WebDriver driver) {
            try {
            	Actions actions = new Actions(driver);
                actions.moveToElement(logoutnavigation).perform();
                return logoutverify.isDisplayed();
            } catch (Exception e) {
                return false; 
            }
        }
        
        public void logout_action() {
        	act.moveToElement(logoutnavigation).perform();
            logoutverify.click();
        }
        

}
  