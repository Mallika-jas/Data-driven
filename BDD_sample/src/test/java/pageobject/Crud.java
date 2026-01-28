package pageobject;



import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Crud extends Basicc {
	    public Crud(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
	        @FindBy(xpath="//a[@href='https://nexus.hexagon.com/']/following-sibling::span[@class='figure-rollover__bt']")
	        WebElement nex;
	        @FindBy(xpath="//span[@class=\"js-create-collection button button--large--rounded--full js-tab\"]") WebElement savecoll;
	        @FindBy(xpath="//input[@id='folder-name']") WebElement name;
	        @FindBy(xpath="//input[@id='folder-description']") WebElement desc;
	        @FindBy(xpath="//div[@class='choices__item choices__placeholder choices__item--selectable']") WebElement choice;
	        @FindBy(xpath="//div[@class='choices__list']") WebElement choose;
	        @FindBy(xpath="//div[contains(@class,'choices__list')]//div[contains(text(),'Resources')]") WebElement resourceOption;
	        
	        @FindBy(xpath="//label[@for='private']")WebElement pri;
	        @FindBy(xpath="//span[@class='button__content']")WebElement save;
	        @FindBy(xpath="//div[@class=\"bt-nav bt-nav--right js-modal-close\"]")WebElement closeicon;
	        
	        @FindBy(xpath="//img[@class='circle-avatar__img']") WebElement logoutnavigation;
	        @FindBy(xpath="//a[contains(text(),'Collections')]") WebElement collectionverify;
	        
	        
	        Actions act = new Actions(driver);
	        
	        @FindBy(xpath="//div[@class='button button--large--rounded js-add-collection']")WebElement Colle2;
	        @FindBy(xpath="//span[contains(text(),'bat')]")WebElement add_coll_verify;
	        
	        @FindBy(xpath="//div[@data-show-options-target='optionsButton']")WebElement menu_to_delete_colle;
	        @FindBy(xpath="//span[contains(text(),'Remove collection')]")WebElement remove_option;
	        @FindBy(xpath="//div[contains(text(),'Delete collection')]")WebElement dele_confirm;
	        
	        public void add_collection() {	
	        	name.sendKeys("bat");
	        	desc.sendKeys("First cart");
	        	choice.click();
	        	resourceOption.click(); 
	        	pri.click();
	        	save.click();
	        	closeicon.click();
	        }
	        
	        public void Byimageadd_coll() {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        	nex.click();
	        	savecoll.click();
	        	add_collection();
	        }
	        
	        public void colle_navigation() {
	        	act.moveToElement(logoutnavigation).perform();
	            collectionverify.click();
	            act.scrollByAmount(0, 500).perform();
	        }
  
	        public void coll_verify() {
	        	colle_navigation();
	            Colle2.click();
	            add_collection();
	            boolean ans= add_coll_verify.isDisplayed();
	            System.out.print(ans);
	       }
	        
	       public void Collection_presence_add() {
	    	   colle_navigation();
	    	   boolean ans= add_coll_verify.isDisplayed();
	            if(ans==true) {
	            	//delete and add
	            	dele_coll();   //delete
	            	coll_verify(); // it will navigate and add
	            }
	            else {
	            	//add
	            	coll_verify();
	            }
			}
	       
	       public void Collection_presence_delete() {
	    	   colle_navigation();
	    	   boolean ans= add_coll_verify.isDisplayed();
	            if(ans==true) {
	            	//delete and add
	            	dele_coll();   //delete
	            }
	            else {
	            	//add
	            	coll_verify();
	            	dele_coll();
	            }
			}
	       
	       

			public void dele_coll() {
	        	//colle_navigation();
	        	menu_to_delete_colle.click();
	        	remove_option.click();
	        	dele_confirm.click();
	        	boolean ans= add_coll_verify.isDisplayed();
	            System.out.print(ans);
	        }
	        
	        
}