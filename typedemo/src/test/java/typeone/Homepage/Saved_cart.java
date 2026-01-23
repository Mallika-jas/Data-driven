package typeone.Homepage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Saved_cart extends Basic {

    public Saved_cart(WebDriver driver) {
        super(driver);
    }

    // ---------- HEADER / DROPDOWN ----------
    @FindBy(css = "img.circle-avatar__img")
    WebElement setting;

    @FindBy(css = "a.dropdown-user__link[href*='collections']")
    WebElement collectionverify;

    // ---------- COLLECTION ELEMENTS ----------
    @FindBy(xpath = "//span[normalize-space()='Bat']")
    List<WebElement> checkBatPresence;
    
    @FindBy(xpath = "//img[@alt='Bat']")
    List<WebElement> batImage;

    @FindBy(xpath = "//div[@class='button button--large--rounded js-add-collection']")
    WebElement create_collection;

    @FindBy(id = "folder-name")
    WebElement name;

    @FindBy(id = "folder-description")
    WebElement desc;

    @FindBy(xpath = "//div[contains(@class,'choices__item')]")
    WebElement choice;

    @FindBy(xpath = "//div[contains(text(),'Resources')]")
    WebElement resourceOption;

    @FindBy(xpath = "//label[@for='private']")
    WebElement pri;

    @FindBy(xpath = "//span[@class='button__content']")
    WebElement save;

    @FindBy(css = ".js-modal-close")
    WebElement closeicon;

    @FindBy(xpath = "//div[@data-show-options-target='optionsButton']")
    WebElement menu_to_colle;

    @FindBy(xpath = "//span[contains(text(),'Remove collection')]")
    WebElement remove_option;

    @FindBy(xpath = "//div[contains(text(),'Delete collection')]")
    WebElement dele_confirm;
    
    @FindBy(xpath = "//img[@alt='Bat1']/ancestor::figure//div[@data-show-options-target='optionsButton']")
    WebElement batThreeDots;


    Actions act = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // ---------- NAVIGATION ----------
    public void collection_navigation() {
        js.executeScript("arguments[0].click();", setting);
        js.executeScript("arguments[0].click();", collectionverify);
        System.out.println("Collection executed");
    }

    // ---------- ADD COLLECTION ----------
    public void add_collection() {
    	js.executeScript("arguments[0].click();",create_collection);
    	System.out.print("collection addtion entered");
        //create_collection.click();
        name.sendKeys("Bat1");
        desc.sendKeys("First cart");
        choice.click();
        resourceOption.click();
        pri.click();
        save.click();
        closeicon.click();
        driver.navigate().refresh();
    }

    // ---------- DELETE COLLECTION ----------
    public void delete_collection() {
    	System.out.println("entered into delete method");
    	js.executeScript("arguments[0].click();", batThreeDots);
    	js.executeScript("arguments[0].click();",menu_to_colle);
    	js.executeScript("arguments[0].click();",remove_option);
    	js.executeScript("arguments[0].click();",dele_confirm);
    	driver.navigate().refresh();
    	
    	//batThreeDots.click();
        //menu_to_colle.click();
        //remove_option.click();
        //dele_confirm.click();
    }

    // ---------- MAIN TEST LOGIC ----------
    public void add_test() {

        collection_navigation();
        if (batImage.size() > 0) {
            delete_collection();
            add_collection();
        } else {
            add_collection();
        }
    }
    
    public void dele_test() {
    	collection_navigation();
    	delete_collection();
    }
}

/*package typeone.Homepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Saved_cart extends Basic {
	    public Saved_cart(WebDriver driver) {
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
	        
	        @FindBy(xpath="//img[@class='circle-avatar__img']") WebElement setting;
	        @FindBy(xpath="//div[@class='dropdown-user']//ul//li//a[normalize-space()='Collections']") WebElement collectionverify;
	        @FindBy(xpath=("//span[normalize-space()='Bat']"))
			public WebElement CheckBatPresence;
	        @FindBy(xpath=("//span[normalize-space()='Bat1']"))WebElement CheckBat1Presence;
	        
	      
	        
	        
	        @FindBy(xpath="//div[@class='button button--large--rounded js-add-collection']")WebElement create_collection;
	       // @FindBy(xpath="//span[contains(text(),'Bat')]")WebElement add_coll_verify;
	        
	        @FindBy(xpath="//div[@data-show-options-target='optionsButton']")WebElement menu_to_colle;
	        @FindBy(xpath="//span[contains(text(),'Remove collection')]")WebElement remove_option;
	        @FindBy(xpath="//span[contains(text(),'Edit')]")WebElement edit_option;
	        @FindBy(xpath="//div[contains(text(),'Delete collection')]")WebElement dele_confirm;
	        
	        Actions act = new Actions(driver);
	        boolean checkbat=CheckBatPresence.isDisplayed();
	        boolean checkbat1=CheckBat1Presence.isDisplayed();
	        
	        public void collection_navigation() {
	        	//act.moveToElement(setting).moveToElement(collectionverify).click().build().perform();	        	
	            //act.scrollByAmount(0, 500).perform();
	        	 System.out.println(" 0 passed"); 
	        	setting.click();          // open dropdown (if needed)
	        	 System.out.println("1 passed");
	        	    collectionverify.click();
	        	    System.out.println("2 passed");
	        	    act.scrollByAmount(0, 500).perform();
	        	    System.out.println("3 passed");
	        }
                 
	        public void add_collection() {	// adding collection
	        	create_collection.click();
	        	name.sendKeys("bat");
	        	desc.sendKeys("First cart");
	        	choice.click();
	        	resourceOption.click(); 
	        	pri.click();
	        	save.click();
	        	closeicon.click();
	        }
	        
	         public void edit_collection() { 	//Edit the collection
	        	 menu_to_colle.click();
	        	 edit_option.click();
	        	 name.clear();name.sendKeys("bat1");
	        	 save.click();
		         closeicon.click();	 
	         }
	         
	        public void delete_coll() {  //deleting collection
	        	menu_to_colle.click();
	        	remove_option.click();
	        	dele_confirm.click();
	        }
	 
	        public void add_test() {
	        	collection_navigation();
	        	boolean bat=CheckBatPresence.isDisplayed();
	        	if (bat==true) {
	        		delete_coll();	        		
	        	}else {
	        	    add_collection();
	        	}	        	   
	        }
}
	
*/
	        
	    /*    public void coll_verify() {
	        	colle_navigation();
	            Colle2.click();
	            add_collection();
	            boolean ans= add_coll_verify.isDisplayed();
	            System.out.print(ans);
	       }
	       
	        public void Byimageadd_coll() {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        	nex.click();
	        	savecoll.click();
	        	add_collection();
	        }
	        
	       public void Collection_presence_add() 
	       	{
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
	       
}*/


/*Add : snackbar=Your collection has been created
Creation -> check 'Bat' is there
{
 if yes : Delete and add 'bat'| if no: add 'bat'
}

Edit: Your changes have been saved.
Creation -> check 'Bat' is there
{
 if yes : Edit | if no: add 'bat' and Edit as 'bat1'
}

Delete: Your changes have been saved.
Creation -> check 'Bat' is there
{
 if yes : Delete | if no: Add 'bat' and Delete 'bat'
}*/



